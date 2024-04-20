package org.amuradon.tralon.sigpron;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.AccessFlag;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.amuradon.tralon.sigpron.telegram.MessageIds;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.amuradon.tralon.sigpron.telegram.handlers.NewMessageHandler;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.drinkless.tdlib.TdApi.ChatList;
import org.drinkless.tdlib.TdApi.Object;
import org.drinkless.tdlib.TdApi.UpdateNewMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
public class GetChatList {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetChatList.class);

	@Test
	public void getChatList() throws InterruptedException {
		try {
			Files.deleteIfExists(Paths.get("chats.txt"));
			Files.createFile(Paths.get("chats.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (MockedConstruction<MessageIds> mocked = Mockito.mockConstruction(MessageIds.class, (mock, context) -> {
			when(mock.getName(anyInt())).thenReturn("message");
		})) {
		
			Client.configureTdlibLogging();
			
			SecretsManager secretsManager = new SecretsManager("test");
			TelegramClient client = new TelegramClient(secretsManager, null, new NoopNewMessageHandler());
			client.login();
			
	        // send LoadChats request if there are some unknown chats and have not enough known chats
	        client.send(new TdApi.LoadChats(new TdApi.ChatListMain(), 500), new TelegramClient.ResultHandler() {
	            @Override
	            public void onResult(TdApi.Object object, TelegramClient client) {
	                switch (object.getConstructor()) {
	                    case TdApi.Error.CONSTRUCTOR:
	                    	System.err.println(object);
	                        break;
	                    case TdApi.Ok.CONSTRUCTOR:
	                    	System.out.println(object);
	                        break;
	                    default:
	                        System.err.println("Receive wrong response from TDLib:\n" + object);
	                }
	            }
	        });
	        
	        Thread.sleep(10000);
		}
	}
	
	private static final class NoopNewMessageHandler extends NewMessageHandler {

		public NoopNewMessageHandler() {
			super(null, 0);
		}
		
		@Override
		public void onResult(Object object, TelegramClient client) {
			try {
				
				Files.writeString(Paths.get("chats.txt"), object.toString(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void getChatHistory() throws InterruptedException {
        
		Client.configureTdlibLogging();
		
		SecretsManager secretsManager = new SecretsManager("test");
//		TelegramClient client = new TelegramClient(secretsManager, null);
//		client.login();
		
        // send LoadChats request if there are some unknown chats and have not enough known chats
//        client.send(new TdApi.GetChatHistory(1001338521686L, 0, 0, 20, true), new NewMessageHandler());
        
        Thread.sleep(10000);
	}
	
	@Test
	public void getMessageIds() {
		List<String> list = new ArrayList<>();
		for(Class<?> clazz : TdApi.class.getClasses()) {
			if (!clazz.accessFlags().contains(AccessFlag.ABSTRACT)) {
				try {
					System.out.println(clazz.getSimpleName() + "=" + clazz.getField("CONSTRUCTOR").getInt(null));
				} catch (Exception e) {
					list.add(clazz.getSimpleName());
				}
			}
		}
		System.out.println("Not supported: " + list);
	}
	
}
