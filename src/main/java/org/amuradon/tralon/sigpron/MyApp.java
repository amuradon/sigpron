package org.amuradon.tralon.sigpron;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.amuradon.tralon.sigpron.telegram.handlers.NewMessageHandler;
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

		SecretsManager secretsManager = new SecretsManager();
		
        // create client
        TelegramClient client = new TelegramClient(Arrays.asList(new NewMessageHandler()), secretsManager.getTelegramSecret());
        client.login();

	}
	
}
