package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Chat;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestChatCreateFeature {
	public static void main(String[] args) {

		String chatText = "Hello baby..";

		// Generate random the user chat name
		LocalDateTime currentDateTime = LocalDateTime.now();
		Instant instant = currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant();
		long currentTimestamp = instant.toEpochMilli();
		int absoluteX = (int) currentTimestamp;
		int id = Math.abs(absoluteX);

		// Passing the different table data
		Chat insertChat = new Chat("direct", id);
		Chat insertChatParticipant = new Chat(2, 1);
		Chat insertMessage = new Chat(1, 1, chatText);

		ChatService chatService = new ChatService();

		try {
			chatService.createChat(insertChat, insertChatParticipant, insertMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChatSuccess() {

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
		}
	}

	@Test
	public void testChatFailure() {

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

	@Test
	public void testChatNullDetails() {

		Chat insertChat = null;
		Chat insertChatParticipant = null;
		Chat insertMessage = null;

		ChatService chatService = new ChatService();

		try {
			assertFalse(chatService.createChat(insertChat, insertChatParticipant, insertMessage));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
