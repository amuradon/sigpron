package org.amuradon.tralon.sigpron.exchange;

import org.amuradon.tralon.sigpron.MyRouteBuilder;
import org.amuradon.tralon.sigpron.Signal;
import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.apache.camel.Body;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binance.connector.futures.client.FuturesClient;
import com.binance.connector.futures.client.WebsocketClient;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

// It has to be Singleton to be constructed eagerly and run PostConstruct method
@Singleton
@Named(BinanceFutures.BEAN_NAME)
@RegisterForReflection
public class BinanceFutures {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BinanceFutures.class);

	public static final String BEAN_NAME = "binanceFutures";
	
	private final FuturesClient futuresClient;
	
	private final WebsocketClient websocketClient;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	private final ProducerTemplate producer;
	
	@Inject
	public BinanceFutures(final SecretsManager secretsManager,
			@ConfigProperty(name = "binance.futures.http.host") String httpHost,
			@ConfigProperty(name = "binance.futures.websocket.host") String websocketHost,
			final ProducerTemplate producer) {
		this.producer = producer;
		futuresClient = new UMFuturesClientImpl(secretsManager.binanceFutures().apiKey(),
				secretsManager.binanceFutures().apiSecret(), "https://" + httpHost);
		websocketClient = new UMWebsocketClientImpl("wss://" + websocketHost);
	}

	public void processSignal(@Body Signal signal) {
		LOGGER.info("Processing signal {}", signal);
		
		// TODO process signal
		// get available balance from account
		// get configured amount to be used
		// send a new market / limit order to by immediately
		// once bought sell orders / stop order
		futuresClient.account().newOrder(null);
	}
	
	@PostConstruct
	public void createListenKey() {
		String result = futuresClient.userData().createListenKey();
		LOGGER.debug("Listening user stream");
		try {
			websocketClient.listenUserStream(mapper.readTree(result).get("listenKey").asText(),
					data -> producer.asyncSendBody(MyRouteBuilder.SEDA_BINANCE_USER_DATA_RECEIVED, data));
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("JSON parsing issue", e);
		}
	}

	public void extendListenKey() {
		futuresClient.userData().extendListenKey();
	}

	public void closeListenKey() {
		futuresClient.userData().closeListenKey();
	}
	
	
}
