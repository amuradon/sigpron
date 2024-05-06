package org.amuradon.tralon.sigpron.telegram.handlers;

import org.amuradon.tralon.sigpron.MyRouteBuilder;
import org.amuradon.tralon.sigpron.Signal;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import telegram4j.tl.BaseMessage;
import telegram4j.tl.BaseUpdates;
import telegram4j.tl.Chat;
import telegram4j.tl.Update;
import telegram4j.tl.UpdateNewChannelMessage;

@ApplicationScoped
public class NewMessageHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewMessageHandler.class);
	
	private final ProducerTemplate producer;
	
	private final long wolfxChatId;
	
	private final long moneyTeamChatId;
	
	@Inject
	public NewMessageHandler(final ProducerTemplate producer,
			@ConfigProperty(name = "telegram.signals.wolfx") final long wolfxChatId,
			@ConfigProperty(name = "telegram.signals.moneyteam") final long moneyTeamChatId) {
		this.producer = producer;
		this.wolfxChatId = wolfxChatId;
		this.moneyTeamChatId = moneyTeamChatId;
	}
	
    public void handle(BaseUpdates updates) {
		if (updates.chats().size() > 1) {
			throw new IllegalStateException("There is more than one Telegram source chat for updates.\n" + updates);
		} else if (updates.chats().isEmpty()) {
			throw new IllegalStateException("There is no Telegram source chat for updates.\n" + updates);
		}
		
		Chat chat = updates.chats().get(0);
		if(chat.id() == wolfxChatId || chat.id() == moneyTeamChatId) {
			
			SignalParser parser = SignalParser.WOLFX;
			
			if (chat.id() == moneyTeamChatId) {
				parser = SignalParser.MONEY_TEAM;
			}

			LOGGER.debug("Processing {} signal", parser);
			
			for (Update update: updates.updates()) {
				if (update instanceof UpdateNewChannelMessage message
						&& message.message() instanceof BaseMessage baseMessage) {
					Signal signal = parser.parseSignal(baseMessage.message());
		
					if (signal != null) {
						// TODO is SEDA and asyncSend right combination?
						producer.asyncSendBody(MyRouteBuilder.SEDA_SIGNAL_RECEIVED, signal);
					}
				}
			}
		}
    }
}
