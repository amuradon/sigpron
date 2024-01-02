package org.amuradon.tralon.sigpron;

import java.util.Arrays;

import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.amuradon.tralon.sigpron.telegram.TelegramSecret;
import org.amuradon.tralon.sigpron.telegram.handlers.NewMessageHandler;
import org.apache.camel.component.telegram.TelegramComponent;
import org.apache.camel.quarkus.core.events.ComponentAddEvent;
import org.drinkless.tdlib.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.config.DefaultValuesConfigSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class AppLifecycleBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppLifecycleBean.class);
	
	private final SecretsManager secretsManager;
//	private final TelegramClient client;
	
	@Inject
	public AppLifecycleBean() {
		// TODO make Telegram client as managed bean, as of now I post-poning as using it "unit test" to get chat list
		Client.configureTdlibLogging();
		secretsManager = new SecretsManager();
		TelegramSecret secrets = secretsManager.getTelegramSecret();
		System.out.println(secrets);
		// TODO enable Telegram API
//		this.client = new TelegramClient(Arrays.asList(new NewMessageHandler()), secretsManager.getTelegramSecret());
	}
	
	void onStartup(@Observes StartupEvent event) {
		LOGGER.info("Sigpron is starting...");
		LOGGER.info("Working directory: {}", System.getProperty("user.dir"));
		
		LOGGER.debug("Telegram client login");
//        client.login();

	}

	void onShutdown(@Observes ShutdownEvent event) {
		LOGGER.info("Sigpron is shutting down...");
		
		LOGGER.debug("Telegram client logout");
//		client.logout();
	}
	
	public void onComponentAdd(@Observes ComponentAddEvent event) {
        if (event.getComponent() instanceof TelegramComponent) {
            /* Perform some custom configuration of the component */
        	TelegramComponent component = event.getComponent(TelegramComponent.class);
        	component.setAuthorizationToken(secretsManager.getTelegramSecret().botAuthToken());
        }
    }
}
