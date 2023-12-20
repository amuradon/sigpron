package org.amuradon.tralon.sigpron.telegram.handlers;


import org.drinkless.tdlib.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultLogMessageHandler implements Client.LogMessageHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLogMessageHandler.class);
	
	@Override
	public void onLogMessage(int verbosityLevel, String message) {
		LOGGER.error(message);
		if (verbosityLevel == 0) {
			throw new Error(message);
        }
	}
	
}
