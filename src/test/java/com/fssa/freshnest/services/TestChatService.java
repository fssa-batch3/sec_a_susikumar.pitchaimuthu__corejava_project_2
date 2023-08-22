package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestChatService {

    // Test chat create feature
    // test the chat success
    @Test
    void testChatSuccess() {
        String chatText = "Hello baby..";
        int[] participantsId = {1, 2};

        // Generate random the user chat name
        String chatName = "Susi and pooja's conversation";

        Chat insertChat = new Chat("direct", chatName);
        Chat insertChatParticipant = new Chat(1, participantsId);
        Chat insertMessage = new Chat(1, 1, chatText);

        ChatService chatService = new ChatService();

        try {
            assertTrue(chatService.createChat(insertChat, insertChatParticipant, insertMessage));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    // test invalid chat details create
    @Test
    void testChatFailure() {
        String chatText = "";
        int[] participantsId = {1, 2};

        // Generate random the user chat name
        String chatName = "Susi and pooja's conversation";

        Chat insertChat = new Chat("direct", chatName);
        Chat insertChatParticipant = new Chat(1, participantsId);
        Chat insertMessage = new Chat(1, 1, chatText);

        ChatService chatService = new ChatService();

        try {
            assertFalse(chatService.createChat(insertChat, insertChatParticipant, insertMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Test chat read feature

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
        ServiceException exception = assertThrows(ServiceException.class, () -> chatService.readChat(null));

        assertEquals("Null argument passed to readChat", exception.getMessage());
    }
    // Test chat update feature

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


    // Test chat delete feature
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

}
