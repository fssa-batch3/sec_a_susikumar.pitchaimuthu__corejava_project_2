package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.ChatService;

public class TestChatReadFeature {
	public static void main(String[] args) {

		String chatText = "Hello chellam..";
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		int chatId = 2;

		Chat chat = new Chat(chatText, currentDate, currentTime, true, false, true, 9, 10, chatId);

		ChatService chatService = new ChatService();

		try {
			chatService.readChat(chat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChatRead() {
		String chatText = "Hello chellam..";
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		int chatId = 2;

		Chat chat = new Chat(chatText, currentDate, currentTime, true, false, true, 9, 10, chatId);

		ChatService chatService = new ChatService();

		try {
			assertTrue(chatService.readChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadChatNullDetails() {
		Chat chat = null;

		ChatService chatService = new ChatService();

		try {
			assertFalse(chatService.readChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
