package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestChatDeleteFeature {


    // test the delete chat success or all details correct
    @Test
    void testChatDeleteSuccess() {

        int chatId = 1;
        int messageId = 2;

        Chat chat = new Chat(true, chatId, messageId);
        ChatService chatService = new ChatService();
        try {
            assertTrue(chatService.deleteChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    // test the delete user details failure
    @Test
    void testDeleteFailure() {
        int chatId = 224;
        int messageId = 2;

        Chat chat = new Chat(true, chatId, messageId);

        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.deleteChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test the null chat delete
    @Test
    void testChatDeleteNullDetails() {
        Chat chat = null;

        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.deleteChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
