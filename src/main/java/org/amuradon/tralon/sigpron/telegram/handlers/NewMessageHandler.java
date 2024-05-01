package org.amuradon.tralon.sigpron.telegram.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amuradon.tralon.sigpron.MyRouteBuilder;
import org.amuradon.tralon.sigpron.Side;
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
	
	private static final String WOLFX_PATTERN = "((\\w+)\\/(\\w+)).*(BUY|SELL)\\n+.*above:\\s+(\\d+\\.\\d+).*of\\s+(\\d+\\.\\d+).*\\n+"
			+ ".*TP1\\s+(\\d+\\.\\d+)\\n+.*TP2\\s+(\\d+\\.\\d+)\\n+.*TP3\\s+(\\d+\\.\\d+)\\n+.*SL\\s+(\\d+\\.\\d+)\\n+.*Leverage\\s+(\\d+)x";
	
	private final ProducerTemplate producer;
	
	private final long wolfxChatId;
	
	@Inject
	public NewMessageHandler(final ProducerTemplate producer,
			@ConfigProperty(name = "telegram.signals.wolfx") final long wolfxChatId) {
		this.producer = producer;
		this.wolfxChatId = wolfxChatId;
	}
	
    @Override
    public void onResult(TdApi.Object object, TelegramClient client) {
        if (object.getConstructor() == TdApi.UpdateNewMessage.CONSTRUCTOR) {
        	TdApi.UpdateNewMessage event = (UpdateNewMessage) object;
        	Message message = event.message;
        	// TODO not process old messages!
    		if ((message.chatId == wolfxChatId)
    				&& message.content.getConstructor() == MessageText.CONSTRUCTOR) {
    			LOGGER.debug("Processing Wolfx signal");
				MessageText messageText = (MessageText) message.content;
				if (messageText.text.getConstructor() == FormattedText.CONSTRUCTOR) {
					FormattedText formattedText = messageText.text;
					Matcher matcher = Pattern.compile(WOLFX_PATTERN)
							.matcher(formattedText.text);
					if (matcher.find()) {
						try {
							Signal signal = new Signal(
    								matcher.group(1).replace("/", ""),
    								matcher.group(2),
    								matcher.group(3),
    								Side.valueOf(matcher.group(4).toUpperCase()),
    								Double.parseDouble(matcher.group(5)),
    								Double.parseDouble(matcher.group(6)),
    								Double.parseDouble(matcher.group(7)),
    								Double.parseDouble(matcher.group(8)),
    								Double.parseDouble(matcher.group(9)),
    								Double.parseDouble(matcher.group(10)),
    								Integer.parseInt(matcher.group(11))
    							);
							// TODO is SEDA and asyncSend right combination?
							producer.asyncSendBody(MyRouteBuilder.SEDA_SIGNAL_RECEIVED, signal);
						} catch (NumberFormatException | IndexOutOfBoundsException e) {
							LOGGER.error("Telegram message parsing failed", e);
						}
					}
    			}
    		}
        }
    }
}
