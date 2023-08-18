package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestChatCreateFeature {


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

    // test the null chat creation
    @Test
    void testChatNullDetails() {
        ChatService chatService = new ChatService();
        try {
            assertFalse(chatService.createChat(null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
