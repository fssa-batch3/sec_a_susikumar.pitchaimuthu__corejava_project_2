package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class TestChatReadFeature {
    
    // test the chat read success
    @Test
    void testChatReadSuccess() {
        int chat_id = 1;

        Chat chat = new Chat(chat_id);

        ChatService chatService = new ChatService();

        try {
            assertTrue(chatService.readChat(chat));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test the chat null read failure
    @Test
    void testReadChatNullDetails() {
        Chat chat = null;

        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.readChat(chat));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
