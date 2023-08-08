package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.ChatService;

public class TestChatCreateFeature {
	public static void main(String[] args) {

		String chatText = "Hello baby..";
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		Chat chat = new Chat(chatText, currentDate, currentTime, true, false, false, 9, 10);

		ChatService chatService = new ChatService();

		try {
			chatService.createChat(chat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChatSuccess() {

		String chatText = "Hello baby..";
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		Chat chat = new Chat(chatText, currentDate, currentTime, true, false, false, 9, 10);

		ChatService chatService = new ChatService();

		try {
			assertTrue(chatService.createChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChatFailure() {

		String chatText = "";
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		Chat chat = new Chat(chatText, currentDate, currentTime, true, false, false, 9, 10);

		ChatService chatService = new ChatService();

		try {
			assertFalse(chatService.createChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChatNullDetails() {

		Chat chat = null;

		ChatService chatService = new ChatService();

		try {
			assertTrue(chatService.createChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
