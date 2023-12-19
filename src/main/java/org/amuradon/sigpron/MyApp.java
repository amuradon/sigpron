package org.amuradon.sigpron;

import java.util.Arrays;

import org.amuradon.sigpron.telegram.TelegramClient;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.drinkless.tdlib.TdApi.UpdateNewMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApp {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyApp.class);

	public static void main(String[] args) {
		LOGGER.info("MyApp starting...");
		
		Client.configureTdlibLogging();

        // create client
        TelegramClient client = new TelegramClient(Arrays.asList(new NewMessageHandler()));
        client.login();

	}
	
	private static class NewMessageHandler implements TelegramClient.ResultHandler {
        @Override
        public void onResult(TdApi.Object object, TelegramClient client) {
        	LOGGER.debug(object.getClass().getSimpleName());
            switch (object.getConstructor()) {
                case TdApi.UpdateNewMessage.CONSTRUCTOR:
                	TdApi.UpdateNewMessage message = (UpdateNewMessage) object; 
                	System.out.println(message);

            }
        }
    }
	
}
