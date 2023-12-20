package org.amuradon.tralon.sigpron.telegram.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amuradon.tralon.sigpron.Side;
import org.amuradon.tralon.sigpron.Signal;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.drinkless.tdlib.TdApi;
import org.drinkless.tdlib.TdApi.FormattedText;
import org.drinkless.tdlib.TdApi.Message;
import org.drinkless.tdlib.TdApi.MessageText;
import org.drinkless.tdlib.TdApi.UpdateNewMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewMessageHandler implements TelegramClient.ResultHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewMessageHandler.class);
	
	private static final String WOLFX_PATTERN = "((\\w+)\\/(\\w+)).*(BUY|SELL)\\n+.*above:\\s+(\\d+\\.\\d+).*of\\s+(\\d+\\.\\d+).*\\n+"
			+ ".*TP1\\s+(\\d+\\.\\d+)\\n+.*TP2\\s+(\\d+\\.\\d+)\\n+.*TP3\\s+(\\d+\\.\\d+)\\n+.*SL\\s+(\\d+\\.\\d+)\\n+.*Leverage\\s+(\\d+)x";
	
	private static final long WOLFX_VIP = -1001338521686L;
	
	private static final long WOLFX_VIP_TEST = -791024550L;
	
    @Override
    public void onResult(TdApi.Object object, TelegramClient client) {
        switch (object.getConstructor()) {
            case TdApi.UpdateNewMessage.CONSTRUCTOR:
            	TdApi.UpdateNewMessage event = (UpdateNewMessage) object;
            	Message message = event.message;
        		if (message.chatId == WOLFX_VIP || message.chatId == WOLFX_VIP_TEST) {
        			if (message.content.getConstructor() == MessageText.CONSTRUCTOR) {
        				MessageText messageText = (MessageText) message.content;
        				if (messageText.text.getConstructor() == FormattedText.CONSTRUCTOR) {
        					FormattedText formattedText = messageText.text;
        					Matcher matcher = Pattern.compile(WOLFX_PATTERN)
        							.matcher(formattedText.text);
        					if (matcher.find()) {
        						try {
        						Signal signal = new Signal(
        								matcher.group(1),
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
        						} catch (NumberFormatException | IndexOutOfBoundsException e) {
        							LOGGER.error("Telegram message parsing failed", e);
        						}
        					}
        				}
        			}
        		}
        }
    }
}
