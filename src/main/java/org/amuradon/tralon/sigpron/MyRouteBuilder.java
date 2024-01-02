package org.amuradon.tralon.sigpron;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO process messages and inputs for Telegram API authentication
		from("telegram:bots")
			.process(e -> e.getMessage().setBody(e.getMessage().getBody() + "echoed"))
			.to("telegram:bots");

	}

}
