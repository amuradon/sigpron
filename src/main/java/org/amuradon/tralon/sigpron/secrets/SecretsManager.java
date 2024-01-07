package org.amuradon.tralon.sigpron.secrets;

import java.util.function.Function;

import org.amuradon.tralon.sigpron.telegram.TelegramSecret;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@ApplicationScoped
public class SecretsManager {

	private final SecretsManagerClient client;
	private TelegramSecret telegram;
	private UserSecret user;
	
	public SecretsManager() {
		client = SecretsManagerClient.builder()
	    		.credentialsProvider(EnvironmentVariableCredentialsProvider.create())
	            .region(Region.of("eu-west-1"))
	            .build();
	}
	
	private <T> T getSecret(T secret, String secretId, Function<JsonNode, T> creatSecret) {
		if (secret != null) {
			return secret;
		}

		GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
				.secretId(secretId)
				.build();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			GetSecretValueResponse getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
			JsonNode node = mapper.readTree(getSecretValueResponse.secretString());
			return creatSecret.apply(node);
		} catch (Exception e) {
			throw new IllegalStateException("Secret could not be loaded.", e);
		}
	}

	public TelegramSecret telegram() {
		return getSecret(telegram, "prod/sigpron/telegram",
					node -> telegram = new TelegramSecret(node.path("apiId").asInt(),
							node.path("apiHash").asText(), node.path("botAuthToken").asText()));
	}

	public UserSecret user() {
		return getSecret(user, "prod/sigpron/user",
				node -> user = new UserSecret(node.path("phoneNumber").asText(), node.path("email").asText()));
	}
}
