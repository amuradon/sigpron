package org.amuradon.sigpron;

import java.util.Collections;

import org.amuradon.sigpron.telegram.TelegramClient;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import org.junit.jupiter.api.Test;

public class GetChatList {

	//@Test
	public void getChatList() {
        
		Client.configureTdlibLogging();
		
		TelegramClient client = new TelegramClient(Collections.emptyList());
		client.login();
		
            // send LoadChats request if there are some unknown chats and have not enough known chats
            client.send(new TdApi.LoadChats(new TdApi.ChatListMain(), 500), new TelegramClient.ResultHandler() {
                @Override
                public void onResult(TdApi.Object object, TelegramClient client) {
                    switch (object.getConstructor()) {
                        case TdApi.Error.CONSTRUCTOR:
                        	System.err.println(object);
//                            if (((TdApi.Error) object).code == 404) {
//                                synchronized (mainChatList) {
//                                    haveFullMainChatList = true;
//                                }
//                            } else {
//                                System.err.println("Receive an error for LoadChats:" + newLine + object);
//                            }
                            break;
                        case TdApi.Ok.CONSTRUCTOR:
                        	System.out.println(object);
//                            // chats had already been received through updates, let's retry request
//                            getMainChatList(limit);
                            break;
                        default:
                            System.err.println("Receive wrong response from TDLib:\n" + object);
                    }
                }
            });
	}
}
