package org.amuradon.tralon.sigpron.exchange;

import org.amuradon.tralon.sigpron.Signal;
import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.apache.camel.Body;
import org.apache.camel.Handler;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named(BinanceFutures.BEAN_NAME)
@RegisterForReflection
public class BinanceFutures {

	public static final String BEAN_NAME = "binanceFutures";
	
	private final SecretsManager secretsManager;
	
	@Inject
	public BinanceFutures(final SecretsManager secretsManager) {
		this.secretsManager = secretsManager;
	}

	@Handler
	public void process(@Body Signal signal) {
		System.out.println("*** Binance Future signal " + signal);
		System.out.println("*** Binance Future credentials " + secretsManager.binanceFutures().apiKey() + " " + secretsManager.binanceFutures().apiSecret());
	}
}
