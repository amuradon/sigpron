package org.amuradon.tralon.sigpron.telegram.handlers;

import static org.mockito.Mockito.when;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amuradon.tralon.sigpron.Side;
import org.amuradon.tralon.sigpron.Signal;
import org.drinkless.tdlib.TdApi.FormattedText;
import org.drinkless.tdlib.TdApi.Message;
import org.drinkless.tdlib.TdApi.MessageText;
import org.drinkless.tdlib.TdApi.UpdateNewMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

public class NewMessageHandlerTest {

	@Test
	public void testMessage() {
		Message message = new Message();
		message.chatId = -1001338521686L;
		MessageText messageText = new MessageText();
		message.content = messageText;
		String text = """
		WOO/USDT 🌏 BUY
	
		🌏Enter above: 0.4919 (with a maximum value of 0.4924)
	
		🌏TP1 0.4939
		🌏TP2 0.4970
		🌏TP3 0.5065
		🌏SL 0.4735
		        
		🌏Leverage 10x
		        
		🌏Respect the entry zone. Check the bio of the channel for all the info required to follow our signals
		""";
		messageText.text = new FormattedText(text, null);
		
		/*
		 * NewMessageHandler handler = new NewMessageHandler(); handler.onResult(new
		 * UpdateNewMessage(message), null);
		 */
	
		
	}
}
