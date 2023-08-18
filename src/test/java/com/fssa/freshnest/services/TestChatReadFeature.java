package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class TestChatReadFeature {

    // test the chat read success
    @Test
    void testChatReadSuccess() {
        int chat_id = 1;

        Chat chat = new Chat(chat_id);

        ChatService chatService = new ChatService();

        try {
            chatService.readChat(chat);
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    // test the chat null read failure
    @Test
    void testReadChatNullDetails() {
        ChatService chatService = new ChatService();

        try {
            chatService.readChat(null);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
