package org.amuradon.tralon.sigpron;

import java.lang.reflect.AccessFlag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.amuradon.tralon.sigpron.secrets.SecretsManager;
import org.amuradon.tralon.sigpron.telegram.TelegramClient;
import org.amuradon.tralon.sigpron.telegram.handlers.NewMessageHandler;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.drinkless.tdlib.TdApi.UpdateNewMessage;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetChatList {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetChatList.class);

	@Test
	public void getChatList() throws InterruptedException {
        
		Client.configureTdlibLogging();
		
		SecretsManager secretsManager = new SecretsManager("test");
//		TelegramClient client = new TelegramClient(secretsManager, null);
//		client.login();
//		
//        // send LoadChats request if there are some unknown chats and have not enough known chats
//        client.send(new TdApi.LoadChats(new TdApi.ChatListMain(), 500), new TelegramClient.ResultHandler() {
//            @Override
//            public void onResult(TdApi.Object object, TelegramClient client) {
//                switch (object.getConstructor()) {
//                    case TdApi.Error.CONSTRUCTOR:
//                    	System.err.println(object);
//                        break;
//                    case TdApi.Ok.CONSTRUCTOR:
//                    	System.out.println(object);
//                        break;
//                    default:
//                        System.err.println("Receive wrong response from TDLib:\n" + object);
//                }
//            }
//        });
        
        Thread.sleep(10000);
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
