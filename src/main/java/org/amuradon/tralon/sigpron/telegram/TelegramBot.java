package org.amuradon.tralon.sigpron.telegram;

import java.util.function.Consumer;

import org.amuradon.tralon.sigpron.MyRouteBuilder;
import org.apache.camel.Consume;
import org.apache.camel.ProducerTemplate;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelegramBot {
	// For unknown reason the automatic implementation generation from interface did not work,
	// problem with Produce annotation
	
	private final ProducerTemplate producer;
	
	private Consumer<String> callback;

	public TelegramBot(ProducerTemplate producer) {
		this.producer = producer;
	}

	void sendMessage(String message) {
		producer.sendBody(MyRouteBuilder.TELEGRAM_BOT, message);
	}
	
	@Consume(MyRouteBuilder.TELEGRAM_BOT)
	public void onMessage(String message) {
		if (callback != null) {
			callback.accept(message);
			callback = null;
		}
		
	}

	public void setCallback(Consumer<String> callback) {
		this.callback = callback;
	}
}
