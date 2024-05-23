package org.amuradon.tralon.sigpron;

import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.apache.camel.component.telegram.TelegramComponent;
import org.apache.camel.quarkus.core.events.ComponentAddEvent;
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
	
	private final SecretsManager secretsManager;
	private final TelegramClient telegramClient;
	
	@Inject
	public AppLifecycleBean(SecretsManager secretsManager,
			TelegramClient telegramClient) {
		this.secretsManager  = secretsManager;
		this.telegramClient = telegramClient;
	}
	
	void onStartup(@Observes StartupEvent event) {
		LOGGER.info("Sigpron is starting...");
		LOGGER.info("Working directory: {}", System.getProperty("user.dir"));
		
		LOGGER.debug("Telegram client login");
		telegramClient.login();
	}

	void onShutdown(@Observes ShutdownEvent event) {
		LOGGER.info("Sigpron is shutting down...");
		
//		LOGGER.debug("Telegram client logout");
//		telegramClient.logout();
	}
	
	public void onComponentAdd(@Observes ComponentAddEvent event) {
        if (event.getComponent() instanceof TelegramComponent) {
            /* Perform some custom configuration of the component */
        	TelegramComponent component = event.getComponent(TelegramComponent.class);
        	component.setAuthorizationToken(secretsManager.telegram().botAuthToken());
        }
    }

}
