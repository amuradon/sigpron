package org.amuradon.tralon.sigpron.exchange;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	private static final String TRADING_STATUS = "TRADING";

	private static final String MARGIN_TYPE = "ISOLATED";

	private static final Logger LOGGER = LoggerFactory.getLogger(BinanceFutures.class);

	public static final String BEAN_NAME = "binanceFutures";
	
	private final UMFuturesClientImpl futuresClient;
	
	private final WebsocketClient websocketClient;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	private final ProducerTemplate producer;
	
	private final Map<String, Position> positions;
	
	private Map<String, Symbol> exchangeInfo;
	
	private long timeDifference;
	
	@Inject
	public BinanceFutures(final SecretsManager secretsManager,
			@ConfigProperty(name = "binance.futures.http.host") String httpHost,
			@ConfigProperty(name = "binance.futures.websocket.host") String websocketHost,
			final ProducerTemplate producer) {
		this.producer = producer;
		futuresClient = new UMFuturesClientImpl(secretsManager.binanceFutures().apiKey(),
				secretsManager.binanceFutures().apiSecret(), "https://" + httpHost);
		websocketClient = new UMWebsocketClientImpl("wss://" + websocketHost);
		positions = new HashMap<>();
	}
	
	public void processSignal(@Header("BalancePercentage") double balancePercentage, @Body Signal signal) {
		LOGGER.info("Processing signal {}", signal);
		
		// TODO process SELL signals as well
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
		
		double quantity = availableBalance * (balancePercentage / 100.0);
		LOGGER.debug("Available balance: {} USDT", availableBalance);
		LOGGER.debug("Balance percentage: {}", balancePercentage);
		LOGGER.debug("Aiming for: {} USDT", quantity);
		
		final String symbol = signal.symbol();
		
		Position position = positions.get(symbol);
		if (position == null) {
			LOGGER.error("No information for position {}. Skip processing", position);
			return;
		}

		Symbol symbolInfo = exchangeInfo.get(symbol);
		if (!symbolInfo.status.equalsIgnoreCase(TRADING_STATUS)) {
			LOGGER.error("The symbol {} is not in status {} but {}", symbol, TRADING_STATUS, symbolInfo.status);
			return;
		}
		
		LOGGER.debug("Processing symbol {} with position {}", symbol, position);
		if (!MARGIN_TYPE.equalsIgnoreCase(position.marginType())) {
			LOGGER.debug("Changing margin type of {} from {} to {}", symbol, position.marginType(), MARGIN_TYPE);
			futuresClient.account().changeMarginType(params()
					.put("symbol", symbol)
					.put("marginType", MARGIN_TYPE)
					.build());
		}
		
		if (signal.leverage() != position.leverage()) {
			LOGGER.debug("Changing leverage of {} from {} to {}", symbol, position.leverage(), signal.leverage());
			futuresClient.account().changeInitialLeverage(params()
					.put("symbol", symbol)
					.put("leverage", signal.leverage())
					.build());
		}
		
		
		if (symbolInfo.orderTypes.contains("MARKET")) {
			Map<String, Object> marketLotSize = symbolInfo.filterMapping.get("MARKET_LOT_SIZE");
			Map<String, Object> lotSize = symbolInfo.filterMapping.get("LOT_SIZE");
			double maxQty = Double.min(Double.parseDouble(marketLotSize.get("maxQty").toString()), Double.parseDouble(lotSize.get("maxQty").toString()));
			double minQty = Double.max(Double.parseDouble(marketLotSize.get("minQty").toString()), Double.parseDouble(lotSize.get("minQty").toString()));
			
			if (quantity < minQty) {
				LOGGER.error("Requested quantity {} is lesser than minimum {}", quantity, minQty);
				return;
			}
			
			double originalQuantity = quantity;
			quantity = Double.min(maxQty, originalQuantity);
			LOGGER.debug("Aiming for: {}, resolved to: {}", originalQuantity, quantity);
		}
		
		// TODO Get actual price and compare to requested
		
		// TODO to emulate Wolfx / Cornix for TP2 for BUY
		// - create STOP BUY >= stopPrice then once executed
		// - create 50% A TAKE_PROFIT SELL >= stopPrice TP1 or just LIMIT SELL (Cornix) ?
		// - create 50% B TAKE_PROFIT SELL >= stopPrice TP2 or just LIMIT SELL (Cornix) ?
		// - create SL1 100% STOP LIMIT SELL <= stopPrice
		// - once A executed, cancel SL1
		// - create SL2 50% STOP LIMIT SELL <= stopPrice
		// - once B executed, cancel SL2 
		futuresClient.account().newOrder(params()
				.put("symbol", symbol)
				.put("side", signal.side().name())
				.put("type", "MARKET")
				.put("quantity", 0.1)
				.put("newOrderRespType", "RESULT")
				.build());
		
	}
	
	public void getMarketData(@Body Signal signal) {
		futuresClient.market().markPriceKlines(params()
				.put("symbol", signal.symbol())
				.put("interval", "5m")
				.build());
	}
	
	@PostConstruct
	public void initialize() {
		try {
			// Create listen key
			String result = futuresClient.userData().createListenKey();
			LOGGER.debug("Listening user stream");
			websocketClient.listenUserStream(mapper.readTree(result).get("listenKey").asText(),
					data -> producer.asyncSendBody(MyRouteBuilder.SEDA_BINANCE_USER_DATA_RECEIVED, data));

			syncTime();
			
			// Get position mapping
			String posInfoResponse = futuresClient.account().positionInformation(params().build());
			Position[] positionArray =
					mapper.readValue(posInfoResponse, mapper.getTypeFactory().constructArrayType(Position.class));
			for (Position position : positionArray) {
				positions.put(position.symbol(), position);
			}
		
			// Get exchange info
			String echangeInfoResponse = futuresClient.market().exchangeInfo();
			Symbol[] symbols = mapper.readValue(mapper.readTree(echangeInfoResponse).get("symbols").traverse(),
					mapper.getTypeFactory().constructArrayType(Symbol.class));
			exchangeInfo = Arrays.stream(symbols)
					.filter(s -> s.contractType.equalsIgnoreCase("PERPETUAL"))
					.collect(Collectors.<Symbol, String, Symbol>toMap(s -> s.symbol, s -> s));
		
		} catch (IOException e) {
			throw new IllegalStateException("JSON parsing issue", e);
		}
	}

	public void syncTime() {
		try {
			String timeResponse = futuresClient.market().time();
			long serverTime = mapper.readTree(timeResponse).get("serverTime").asLong();
			long localTime = new Date().getTime();
			timeDifference = serverTime - localTime;
			LOGGER.info("Timing syncing - server {}, local {}, diff {}", serverTime, localTime, timeDifference);
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
	
	private final class MapBuilder {
		private final LinkedHashMap<String, Object> map;
		
		MapBuilder() {
			map = new LinkedHashMap<>();
			map.put("timestamp", new Date().getTime() + timeDifference);
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
