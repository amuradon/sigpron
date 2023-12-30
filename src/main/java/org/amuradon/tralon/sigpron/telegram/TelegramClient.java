package org.amuradon.tralon.sigpron.telegram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.amuradon.tralon.sigpron.telegram.handlers.DefautlResultHandler;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.drinkless.tdlib.TdApi.AuthorizationState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelegramClient {

	private static final AtomicLong currentQueryId = new AtomicLong();
	
	private int nativeClientId;

	private final List<ResultHandler> updateHandlers;
	private final ConcurrentHashMap<Long, ResultHandler> handlers;
	private final TelegramSecret secret;

	private boolean logged;
	
	public TelegramClient(List<ResultHandler> updateHandlers, TelegramSecret secret) {
        this.updateHandlers = new ArrayList<>();
        this.updateHandlers.add(new AuthorizationHandler());
        this.updateHandlers.addAll(updateHandlers);
        this.secret = secret;
        handlers = new ConcurrentHashMap<>();
    }
	
	public void login() {
		nativeClientId = Client.createNativeClient();
		Thread receiverThread = new Thread(new ResponseReceiver(this), "TDLib thread");
		// For now I don't want daemon thread as it causes JVM to end
		// receiverThread.setDaemon(true);
		receiverThread.start();
        
        send(new TdApi.GetOption("version"));
        
        long loginStart = System.currentTimeMillis();
        while (!logged && System.currentTimeMillis() - loginStart <= 10000) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new IllegalStateException("The login failed", e);
			}
        }
        
        if (!logged) {
        	throw new IllegalStateException("Login timed out.");
        }
	}
	
	public void logout() {
		send(new TdApi.LogOut());
	}


	/**
	 * Sends a request to the TDLib.
	 *
	 * @param query            Object representing a query to the TDLib.
	 * @param resultHandler    Result handler with onResult method which will be
	 *                         called with result of the query or with TdApi.Error
	 *                         as parameter. If it is null, nothing will be called.
	 * @param exceptionHandler Exception handler with onException method which will
	 *                         be called on exception thrown from resultHandler. If
	 *                         it is null, then defaultExceptionHandler will be
	 *                         called.
	 */
	public void send(TdApi.Function query, ResultHandler resultHandler) {
		long queryId = currentQueryId.incrementAndGet();
		if (resultHandler != null) {
			handlers.put(queryId, resultHandler);
		}
		Client.nativeClientSend(nativeClientId, queryId, query);
	}

	/**
	 * Sends a request to the TDLib with an empty ExceptionHandler.
	 *
	 * @param query         Object representing a query to the TDLib.
	 */
	public void send(TdApi.Function query) {
		send(query, new DefautlResultHandler());
	}

	/**
	 * Interface for handler for results of queries to TDLib and incoming updates
	 * from TDLib.
	 */
	public interface ResultHandler {
		/**
		 * Callback called on result of query to TDLib or incoming update from TDLib.
		 *
		 * @param object Result of query or update of type TdApi.Update about new
		 *               events.
		 * @param client
		 */
		void onResult(TdApi.Object object, TelegramClient client);
	}
	
	private static class AuthorizationHandler implements TelegramClient.ResultHandler {
		
		private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationHandler.class);
		
	    @Override
	    public void onResult(TdApi.Object object, TelegramClient client) {
	    	 if (object.getConstructor() != TdApi.UpdateAuthorizationState.CONSTRUCTOR) {
	             return;
	    	 }

	    	AuthorizationState authorizationState = ((TdApi.UpdateAuthorizationState) object).authorizationState;
	    	switch (authorizationState.getConstructor()) {
				case TdApi.AuthorizationStateWaitTdlibParameters.CONSTRUCTOR:
					LOGGER.info("Logging...");
					TdApi.SetTdlibParameters request = new TdApi.SetTdlibParameters();
					request.databaseDirectory = "tdlib";
					request.useMessageDatabase = false;
					request.useSecretChats = false;
					request.apiId = client.secret.apiId();
					request.apiHash = client.secret.apiHash();
					request.systemLanguageCode = "en";
					request.deviceModel = "Desktop";
					request.applicationVersion = "1.0";
					request.enableStorageOptimizer = true;
		
					client.send(request, new DefautlResultHandler());
					
					break;
				case TdApi.AuthorizationStateReady.CONSTRUCTOR:
					LOGGER.info("Logged successfully");
					client.logged = true;
					break;
				case TdApi.AuthorizationStateLoggingOut.CONSTRUCTOR:
					LOGGER.info("Logging out");
					break;
				case TdApi.AuthorizationStateClosing.CONSTRUCTOR:
					LOGGER.info("Closing");
					break;
				case TdApi.AuthorizationStateClosed.CONSTRUCTOR:
					LOGGER.info("Closed");
					break;
				default:
					LOGGER.debug("Message {} not processed by this handler", object.getConstructor());
			}
	    }
	}

	private static class ResponseReceiver implements Runnable {

		private static final int MAX_EVENTS = 1000;
		private final int[] clientIds = new int[MAX_EVENTS];
		private final long[] eventIds = new long[MAX_EVENTS];
		private final TdApi.Object[] events = new TdApi.Object[MAX_EVENTS];

		private final TelegramClient client;

		public ResponseReceiver(TelegramClient client) {
			this.client = client;
		}

		@Override
		public void run() {
			while (true) {
				int resultN = Client.nativeClientReceive(clientIds, eventIds, events, 100000.0 /* seconds */);
				for (int i = 0; i < resultN; i++) {
					processResult(clientIds[i], eventIds[i], events[i]);
					events[i] = null;
				}
			}
		}

		private void processResult(int clientId, long id, TdApi.Object object) {
			List<ResultHandler> handlers = id == 0 ? client.updateHandlers : Collections.singletonList(client.handlers.remove(id));
			if (handlers != null) {
				for (ResultHandler resultHandler : handlers) {
					resultHandler.onResult(object, client);
				}
			}

		}

	}

}
