package org.amuradon.tralon.sigpron.telegram.handlers;

import org.amuradon.tralon.sigpron.MyRouteBuilder;
import org.amuradon.tralon.sigpron.Signal;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.apache.camel.ProducerTemplate;
import org.drinkless.tdlib.TdApi;
import org.drinkless.tdlib.TdApi.FormattedText;
import org.drinkless.tdlib.TdApi.Message;
import org.drinkless.tdlib.TdApi.MessageText;
import org.drinkless.tdlib.TdApi.UpdateNewMessage;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NewMessageHandler implements TelegramClient.ResultHandler {
	
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
	
    @Override
    public void onResult(TdApi.Object object, TelegramClient client) {
        if (object.getConstructor() == TdApi.UpdateNewMessage.CONSTRUCTOR) {
        	TdApi.UpdateNewMessage event = (UpdateNewMessage) object;
        	Message message = event.message;
        	// TODO how to process old messages! E.g. after restart, downtime
    		if ((message.chatId == wolfxChatId || message.chatId == moneyTeamChatId)
    				&& message.content.getConstructor() == MessageText.CONSTRUCTOR) {
    			
    			SignalParser parser = SignalParser.WOLFX;
    			
    			if (message.chatId == moneyTeamChatId) {
    				parser = SignalParser.MONEY_TEAM;
    			}
    			
    			LOGGER.debug("Processing {} signal", parser);
				MessageText messageText = (MessageText) message.content;
				if (messageText.text.getConstructor() == FormattedText.CONSTRUCTOR) {
					FormattedText formattedText = messageText.text;
					Signal signal = parser.parseSignal(formattedText.text);
					
					if (signal != null) {
						// TODO is SEDA and asyncSend right combination?
						producer.asyncSendBody(MyRouteBuilder.SEDA_SIGNAL_RECEIVED, signal);
					}
    			}
    		}
        }
    }
}
