package org.amuradon.tralon.sigpron;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

	// TODO chatId as variable? Different for environments? PROD vs TEST?
	public static final String TELEGRAM_BOT = "telegram:bots?chatId=2103542318";

	@Override
	public void configure() throws Exception {
		// TODO process messages and inputs for Telegram API authentication
//		from("telegram:bots")
//			.process(e -> e.getMessage().setBody(e.getMessage().getBody() + "echoed"))
//			.to("telegram:bots");

	}

}
