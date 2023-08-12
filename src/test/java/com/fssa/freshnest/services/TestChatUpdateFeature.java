package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestChatUpdateFeature {


    // test the chat update success details
    @Test
    void testChatUpdateSuccess() {
        String chatText = "Hello chellam..";
        int chatId = 1;
        int messageId = 1;

        Chat chat = new Chat(chatText, chatId, messageId);

        ChatService chatService = new ChatService();

        try {
            assertTrue(chatService.updateChat(chat));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test the chat update failure
    @Test
    void testChatUpdateInvalidMessageIdFailure() {
        String chatText = "Hello chellam..";
        int chatId = 1;
        int messageId = -3;
        Chat chat = new Chat(chatText, chatId, messageId);

        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.updateChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test the null details failure
    @Test
    void testChatNullDetails() {
        Chat chat = null;
        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.updateChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
