package org.amuradon.tralon.sigpron.secrets;

import org.amuradon.tralon.sigpron.telegram.TelegramSecret;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public class SecretsManager {

	private final SecretsManagerClient client;
	
	public SecretsManager() {
		client = SecretsManagerClient.builder()
	    		.credentialsProvider(EnvironmentVariableCredentialsProvider.create())
	            .region(Region.of("eu-west-1"))
	            .build();
	}
	
	public TelegramSecret getTelegramSecret() {
	    GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
	            .secretId("prod/sigpron/telegram")
	            .build();

	    ObjectMapper mapper = new ObjectMapper();
	    try {
	    	GetSecretValueResponse getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
			JsonNode node = mapper.readTree(getSecretValueResponse.secretString());
			return new TelegramSecret(node.path("apiId").asInt(), node.path("apiHash").asText());
		} catch (Exception e) {
			throw new IllegalStateException("Secret could not be loaded.", e);
		}
	}
}
