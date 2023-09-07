package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class contains test cases for the ChatService class, which handles various chat-related operations.
 *
 * @author SusikumarPitchaimuth
 */
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

        ServiceException result = assertThrows(ServiceException.class, () -> chatService.createChat(insertChat, insertChatParticipant, insertMessage));
        assertEquals(ChatConstants.getInvalidChatTextMessage(), result.getMessage());


    }

    // Test chat read feature

    // test the chat read success
    @Test
    void testChatReadSuccess() {
        int chat_id = 1;

        Chat chat = new Chat(chat_id);

        ChatService chatService = new ChatService();

        try {
            List<Chat> result = chatService.readChat(chat);
            for (Chat c : result) {
                System.out.print(c);
            }
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

        assertEquals(ChatConstants.getInvalidChatReadMessage(), exception.getMessage());
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

        ServiceException result = assertThrows(ServiceException.class, () -> chatService.updateChat(chat));
        assertEquals(ChatConstants.getInvalidChatUpdateMessage(), result.getMessage());


    }


    // Test chat delete feature
    // test the delete chat success or all details correct
    @Test
    void testChatDeleteSuccess() {

        int chatId = 1;
        int messageId = 1;

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
    void testDeleteWithInvalidChatIdFailure() {
        int chatId = 455;
        int messageId = 2;

        Chat chat = new Chat(true, chatId, messageId);

        ChatService chatService = new ChatService();

        ServiceException result = assertThrows(ServiceException.class, () -> chatService.deleteChat(chat));
        assertEquals(ChatConstants.getInvalidChatDeleteMessage(), result.getMessage());

    }

}
