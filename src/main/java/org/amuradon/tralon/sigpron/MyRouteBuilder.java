package org.amuradon.tralon.sigpron;

import java.net.URI;

import org.amuradon.tralon.sigpron.exchange.BinanceFutures;
import org.apache.camel.EndpointInject;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.vertx.http.VertxHttpComponent;
import org.apache.camel.component.vertx.websocket.VertxWebsocketEndpoint;

import io.vertx.core.http.HttpMethod;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MyRouteBuilder extends EndpointRouteBuilder {

	// TODO chatId as variable? Different for environments? PROD vs TEST?
	public static final String TELEGRAM_BOT = "telegram:bots?chatId=2103542318";
	
	public static final String SEDA_SIGNAL_RECEIVED = "seda:signalReceived";
	
	@EndpointInject("vertx-websocket://wss:{{binance.futures.websocket.host}}:443/ws/${listenKey}")
	private VertxWebsocketEndpoint binanceWebsocket;

	@Override
	public void configure() throws Exception {
		// TODO process messages and inputs for Telegram API authentication
//		from("telegram:bots")
//			.process(e -> e.getMessage().setBody(e.getMessage().getBody() + "echoed"))
//			.to("telegram:bots");
		
		from(SEDA_SIGNAL_RECEIVED)
			.to("log:messageBus?level=DEBUG")
			.bean(BinanceFutures.BEAN_NAME);
		
		// POST listenKey
		// PUT listenKey every 60 minutes
		// Reconnect every 24 hours
		// Handle events - closed, expired....
		// Handle user data events
		
		// TODO run on Camel start event ? Potentially can trigger from CDI event to direct:...
		from("")
			.setHeader("CamelHttpMethod", () -> HttpMethod.POST)
			.to("vertx-http:https://{{binance.futures.http.host}}/fapi/v1/listenKey")
			.log("*** ListenKey ${body}")
			// TODO extract listen key and and put WS endpoint ?
			.to("controlbus:route?routeId=userDataStream&action=start");
		
		// Every 60 minutes ping listen key to keep alive, required by Binance
		from("timer:keepAlive?delay=360000&fixedRate=true&period=360000")
			.setHeader("CamelHttpMethod", () -> HttpMethod.PUT)
			.to("vertx-http:https://{{binance.futures.http.host}}/fapi/v1/listenKey");
		
		// XXX this is a bit of workaround otherwise Camel appends ?consumeAsClient=true to the URL send to Binance
		// server that returns 400 Bad request in such case. Is there better way?
		binanceWebsocket.getConfiguration().setConsumeAsClient(true);
		// The route can't be autostarted, the POST listenKey has to happen first
		from(binanceWebsocket)
			.routeId("userDataStream")
			.autoStartup(false)
			.log("*** User Data Stream ${body}");
	}

}
