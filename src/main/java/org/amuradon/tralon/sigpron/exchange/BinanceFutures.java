package org.amuradon.tralon.sigpron.exchange;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.amuradon.tralon.sigpron.MyRouteBuilder;
import org.amuradon.tralon.sigpron.Side;
import org.amuradon.tralon.sigpron.Signal;
import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.apache.camel.Body;
import org.apache.camel.Header;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.binance.connector.futures.client.WebsocketClient;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.annotation.PostConstruct;
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
	
	private final UMFuturesClientImpl futuresClient;
	
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

	public void processSignal(@Header("BalancePercentage") double balancePercentage, @Body Signal signal) {
		LOGGER.info("Processing signal {}", signal);
		
		// TODO process SELL signals as well, ignore for now as I don't understand them
		if (signal.side() == Side.SELL) {
			return;
		}
		
		// get available balance from account
		String balanceResponseData = futuresClient.account().futuresAccountBalance(params().build());
		double availableBalance = 0;
		try {
			Iterator<JsonNode> iterator = mapper.readTree(balanceResponseData).elements();
			while (iterator.hasNext()) {
				JsonNode node = iterator.next();
				if (node.get("asset").asText().equalsIgnoreCase("USDT")) {
					availableBalance = node.get("availableBalance").asDouble();
					break;
				}
			}
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("JSON parsing issue", e);
		}
		
		double orderAmount = availableBalance * (balancePercentage / 100.0);
		LOGGER.debug("Available balance: {} USDT", availableBalance);
		LOGGER.debug("Balance percentage: {}", balancePercentage);
		LOGGER.debug("Using: {} USDT", orderAmount);
		
		final String symbol = signal.symbol().replace("/", "");
		futuresClient.account().changeMarginType(params()
				.put("symbol", symbol)
				.put("marginType", "ISOLATED")
				.build());
		
		futuresClient.account().changeInitialLeverage(params()
				.put("symbol", symbol)
				.put("leverage", signal.leverage())
				.build());
		
		// XXX create order - does not work yet
		futuresClient.account().newOrder(params()
				.put("symbol", symbol)
				.put("side", signal.side().name())
				.put("type", "MARKET")
				.put("quantity", orderAmount)
				.put("newOrderRespType", "RESULT")
				.build());
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

	// TODO so far not used, use it when shutting down application
	public void closeListenKey() {
		futuresClient.userData().closeListenKey();
	}
	
	private MapBuilder params() {
		return new MapBuilder();
	}
	
	private static final class MapBuilder {
		private final LinkedHashMap<String, Object> map;
		
		MapBuilder() {
			map = new LinkedHashMap<>();
			map.put("timestamp", new Date().getTime());
		}
		
		MapBuilder put(String key, Object value) {
			map.put(key, value);
			return this;
		}
		
		LinkedHashMap<String, Object> build() {
			return map;
		}
	}
}
