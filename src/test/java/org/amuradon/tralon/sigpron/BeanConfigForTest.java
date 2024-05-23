package org.amuradon.tralon.sigpron;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import org.mockito.MockMakers;

import io.quarkus.test.Mock;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Mock
@ApplicationScoped
public class BeanConfigForTest {

	@Mock
	@Produces
	public SecretsManagerClient secretsManagerClient() {
		SecretsManagerClient secretsManagerClientMock = mock();
		GetSecretValueResponse secretValueResponseMock = mock(GetSecretValueResponse.class, withSettings().mockMaker(MockMakers.INLINE));
		when(secretsManagerClientMock.getSecretValue(any(GetSecretValueRequest.class)))
			.thenReturn(secretValueResponseMock);
		
		// Returning values for all secrets on each request, I don't want to waste time with splitting now
		when(secretValueResponseMock.secretString()).thenReturn(
				"""
				{
					"apiId": "someApiId",
					"apiHash": "someApiHash",
					"botToken": "someBotToken",
					"phoneNumber": "123456789",
					"email": "some@email.com",
					"apiKey": "someApiKey",
					"apiSecret": "someApiSecret"
				}
				""");
		return secretsManagerClientMock;
	}
}
