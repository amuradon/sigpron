package org.amuradon.tralon.sigpron;

import java.util.Arrays;

import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.amuradon.tralon.sigpron.telegram.handlers.NewMessageHandler;
import org.drinkless.tdlib.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class AppLifecycleBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppLifecycleBean.class);
	
	private final TelegramClient client;
	
	@Inject
	public AppLifecycleBean() {
		// TODO make Telegram client as managed bean, as of now I post-poning as using it "unit test" to get chat list
		Client.configureTdlibLogging();
		SecretsManager secretsManager = new SecretsManager();
		this.client = new TelegramClient(Arrays.asList(new NewMessageHandler()), secretsManager.getTelegramSecret());
	}
	
	void onStartup(@Observes StartupEvent event) {
		LOGGER.info("Sigpron is starting...");
		
		LOGGER.debug("Telegram client login");
        client.login();

	}

	void onShutdown(@Observes ShutdownEvent event) {
		LOGGER.info("Sigpron is shutting down...");
		
		LOGGER.debug("Telegram client logout");
		client.logout();
	}
}
