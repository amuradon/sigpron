package org.amuradon.tralon.sigpron;

import org.amuradon.tralon.sigpron.exchange.BinanceFutures;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyRouteBuilder extends EndpointRouteBuilder {

	// TODO chatId as variable? Different for environments? PROD vs TEST?
	public static final String TELEGRAM_BOT = "telegram:bots?chatId=2103542318";
	
	public static final String SEDA_SIGNAL_RECEIVED = "seda:signalReceived";
	
	public static final String SEDA_BINANCE_USER_DATA_RECEIVED = "seda:binanceUserDataReceived";
	
	@Override
	public void configure() throws Exception {
		// TODO process messages and inputs for Telegram API authentication
//		from("telegram:bots")
//			.process(e -> e.getMessage().setBody(e.getMessage().getBody() + "echoed"))
//			.to("telegram:bots");
		
		// Reconnect every 24 hours
		// Handle events - closed, expired....
		// Handle user data events
		
		// Every 60 minutes ping listen key to keep alive, required by Binance
		from("timer:keepAlive?delay=360000&fixedRate=true&period=360000")
			.bean(BinanceFutures.BEAN_NAME, "extendListenKey");
		
		from(SEDA_BINANCE_USER_DATA_RECEIVED)
			.multicast()
			.to("telegram:bots")
			.log("*** User Data Stream ${body}");
			// TODO publish to analytics - Elasticsearch, OpenSearch...
	}

}
