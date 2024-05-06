package org.amuradon.tralon.sigpron.telegram.handlers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.amuradon.tralon.sigpron.MarginType;
import org.amuradon.tralon.sigpron.Side;
import org.amuradon.tralon.sigpron.Signal;
import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import telegram4j.tl.BaseMessage;
import telegram4j.tl.BaseUpdates;
import telegram4j.tl.Channel;
import telegram4j.tl.UpdateNewChannelMessage;

@ExtendWith(MockitoExtension.class)
public class NewMessageHandlerTest {

	private static final String WOLFX_MESSAGE =
			"""
			WOO/USDT 🌏 BUY
		
			🌏Enter above: 0.4919 (with a maximum value of 0.4924)
		
			🌏TP1 0.4939
			🌏TP2 0.4970
			🌏TP3 0.5065
			🌏SL 0.4735
			        
			🌏Leverage 10x
			        
			🌏Respect the entry zone. Check the bio of the channel for all the info required to follow our signals
			""";

	private static final String MONEY_TEAM_MESSAGE =
			"""
			🏅PREMIUM SIGNAL🏅

			Exchange: Bingx (https://bingx.com/invite/KOZYQ1)
			➡️FOLLOW (https://bingx.com/invite/KOZYQ1)

			🟩LONG
			Name: WOO/USDT
			Margin: CROSS 10X

			↪️ENTRY ZONE (USDT):
			0.4919-0.4924

			🎯TARGETS (USDT):
			1) 0.4939
			2) 0.4970
			3) 0.5065
			4) 0.5165
			5) 0.5265
			6) 0.5365

			⛔️Recommended StopLoss:
			0.4735
			📊Ratio 1:3
			""";
	
	
	@Mock
	private ProducerTemplate producerMock;
	
	@Captor
	private ArgumentCaptor<Signal> signalCaptor;
	
	@Mock
	private BaseUpdates baseUpdatesMock;
	
	@Mock
	private Channel channelMock;
	
	@Mock
	private UpdateNewChannelMessage updateNewChannelMessageMock;
	
	@Mock
	private BaseMessage baseMessageMock;
	
	private NewMessageHandler handler;
	
	@BeforeEach
	public void prepare() {
		when(baseUpdatesMock.chats()).thenReturn(Collections.singletonList(channelMock));
		when(baseUpdatesMock.updates()).thenReturn(Collections.singletonList(updateNewChannelMessageMock));
		when(updateNewChannelMessageMock.message()).thenReturn(baseMessageMock);
		
		handler = new NewMessageHandler(producerMock, 1, 2);
	}
	
	@Test
	public void testWolfxMessage() {
		testMessage(WOLFX_MESSAGE, 1);
	}

	@Test
	public void testMoneyTeamMessage() {
		Signal signal = testMessage(MONEY_TEAM_MESSAGE, 2);
		Assertions.assertEquals(0.5165, signal.takeProfit4());
		Assertions.assertEquals(0.5265, signal.takeProfit5());
		Assertions.assertEquals(0.5365, signal.takeProfit6());
		Assertions.assertEquals(MarginType.CROSS, signal.marginType());
	}

	private Signal testMessage(String messageContent, long chatId) {
		when(channelMock.id()).thenReturn(chatId);
		when(baseMessageMock.message()).thenReturn(messageContent);
		
		handler.handle(baseUpdatesMock);
	
		verify(producerMock).asyncSendBody(anyString(), signalCaptor.capture());
		Signal signal = signalCaptor.getValue();
		Assertions.assertEquals("WOO/USDT", signal.symbol());
		Assertions.assertEquals("WOO", signal.base());
		Assertions.assertEquals("USDT", signal.quote());
		Assertions.assertEquals(Side.BUY, signal.side());
		Assertions.assertEquals(0.4919, signal.stopPrice());
		Assertions.assertEquals(0.4924, signal.price());
		Assertions.assertEquals(0.4939, signal.takeProfit1());
		Assertions.assertEquals(0.4970, signal.takeProfit2());
		Assertions.assertEquals(0.5065, signal.takeProfit3());
		Assertions.assertEquals(0.4735, signal.stopLoss());
		Assertions.assertEquals(10, signal.leverage());
		return signal;
	}
}
