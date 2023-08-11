package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TestChatCreateFeature {
  

    // test the chat success
    @Test
    void testChatSuccess() {
        String chatText = "Hello baby..";

        // Generate random the user chat name
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int) currentTimestamp;
        int id = Math.abs(absoluteX);

        Chat insertChat = new Chat("direct", id);
        Chat insertChatParticipant = new Chat(1, 1);
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

        // Generate random the user chat name
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
        long currentTimestamp = instant.toEpochMilli();
        int absoluteX = (int) currentTimestamp;
        int id = Math.abs(absoluteX);

        Chat insertChat = new Chat("direct", id);
        Chat insertChatParticipant = new Chat(1, 1);
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
