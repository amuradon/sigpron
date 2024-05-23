package org.amuradon.tralon.sigpron;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

@ApplicationScoped
public class BeanConfig {

	@Produces
	@ApplicationScoped
	public SecretsManagerClient secretsManagerClient() {
		return SecretsManagerClient.builder()
	    		.credentialsProvider(EnvironmentVariableCredentialsProvider.create())
	            .region(Region.of("eu-west-1"))
	            .build();
	}
}
