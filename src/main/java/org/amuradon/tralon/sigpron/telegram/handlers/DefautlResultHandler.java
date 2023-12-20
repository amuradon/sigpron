package org.amuradon.tralon.sigpron.telegram.handlers;

import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.drinkless.tdlib.TdApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefautlResultHandler implements TelegramClient.ResultHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefautlResultHandler.class);
	
    @Override
    public void onResult(TdApi.Object object, TelegramClient client) {
        switch (object.getConstructor()) {
            case TdApi.Error.CONSTRUCTOR:
            	LOGGER.error("Receive an error: \n{}", object);
                break;
            case TdApi.Ok.CONSTRUCTOR:
            	if (LOGGER.isDebugEnabled()) {
            		LOGGER.debug(object.toString());
            	}
                break;
            default:
            	LOGGER.info("Receive response from TDLib:\n{}", object);
        }
    }
}
