package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Chat;

public class TestChatDeleteFeature {

	public static void main(String[] args) {

		int chat_id = 1;

		Chat chat = new Chat(true,chat_id);

		ChatService chatService = new ChatService();

		try {
			chatService.deleteChat(chat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteSuccess() {

		int chatId = 2;

		Chat chat = new Chat(true, chatId);

		ChatService chatService = new ChatService();

		try {
			assertTrue(chatService.deleteChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteFailure() {

		int chatId = 2232;

		Chat chat = new Chat(true, chatId);

		ChatService chatService = new ChatService();

		try {
			assertFalse(chatService.deleteChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChatDeleteNullDetails() {
		Chat chat = null;

		ChatService chatService = new ChatService();

		try {
			assertFalse(chatService.deleteChat(chat));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
