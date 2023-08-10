package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestChatUpdateFeature {

    public static void main(String[] args) {

        String chatText = "Hello chellam..";
        int chatId = 1;

        Chat chat = new Chat(chatText, chatId);

        ChatService chatService = new ChatService();

        try {
            chatService.updateChat(chat);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testChatUpdateSuccess() {
        String chatText = "Hello chellam..";
        int chatId = 1;

        Chat chat = new Chat(chatText, chatId);

        ChatService chatService = new ChatService();

        try {
            assertTrue(chatService.updateChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testChatUpdateFailure() {
        String chatText = "Hello chellam..";
        int chatId = 1;

        Chat chat = new Chat(chatText, chatId);

        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.updateChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testChatNullDetails() {
        Chat chat = null;

        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.updateChat(chat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
