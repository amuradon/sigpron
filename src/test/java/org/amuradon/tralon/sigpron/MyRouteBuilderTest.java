package org.amuradon.tralon.sigpron;

import static org.mockito.Mockito.when;

import java.util.Collections;

import org.amuradon.tralon.sigpron.telegram.handlers.NewMessageHandler;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import telegram4j.tl.BaseMessage;
import telegram4j.tl.BaseUpdates;
import telegram4j.tl.Channel;
import telegram4j.tl.UpdateNewChannelMessage;

@QuarkusTest
@QuarkusTestResource(HttpMockResource.class)
public class MyRouteBuilderTest {

	private static final String WOLFX_MESSAGE =
			"""
			BTC/USDT 🌏 BUY

			🌏Enter above: 68500.0 (with a maximum value of 68510.0)

			🌏TP1 68550.0
			🌏TP2 68570.0
			🌏TP3 68590.0
			🌏SL 68420.0

			🌏Leverage 10x

			🌏Respect the entry zone. Check the bio of the channel for all the info required to follow our signals
			""";

	@Inject
	NewMessageHandler newMessageHandler;
	
	@ConfigProperty(name = "telegram.signals.wolfx")
	long wolfxChatId;
	
	@Mock
	private BaseUpdates baseUpdatesMock;
	
	@Mock
	private Channel channelMock;
	
	@Mock
	private UpdateNewChannelMessage updateNewChannelMessageMock;
	
	@Mock
	private BaseMessage baseMessageMock;
	
	private AutoCloseable mocks;
	
	@BeforeEach
	public void prepare() {
		// In QuarkusTest the annotation @ExtendWith(MockitoExtension.class) does not work, so doing manual way
		mocks = MockitoAnnotations.openMocks(this);
		
		when(baseUpdatesMock.chats()).thenReturn(Collections.singletonList(channelMock));
		when(baseUpdatesMock.updates()).thenReturn(Collections.singletonList(updateNewChannelMessageMock));
		when(updateNewChannelMessageMock.message()).thenReturn(baseMessageMock);
		when(channelMock.id()).thenReturn(wolfxChatId);
		when(baseMessageMock.message()).thenReturn(WOLFX_MESSAGE);
		
		// TODO
		// Mock Binance server
		//   - Mock websockets
		// 	 - WS seems to connect to default port what is wrong
	}
	
	@AfterEach
	public void closeMocks() throws Exception {
		mocks.close();
	}
	
	@Test
	public void test() {
		newMessageHandler.handle(baseUpdatesMock);
		
		// TODO somehow needs to wait for async processing like WS...
	}

}
