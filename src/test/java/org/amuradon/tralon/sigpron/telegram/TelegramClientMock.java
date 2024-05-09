package org.amuradon.tralon.sigpron.telegram;

import org.amuradon.tralon.sigpron.telegram.TelegramClient;

import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class TelegramClientMock implements TelegramClient {

	// As it is used in AppLifecycleBean in Quarkus startup cannot be mocked by Mockito, it needs to done manually
	
	@Override
	public void login() {
		// Do nothing
	}
	
}
