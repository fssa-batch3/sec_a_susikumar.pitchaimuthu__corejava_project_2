package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestChatReadFeature {
	public static void main(String[] args) {
		int chat_id = 1;

		Chat chat = new Chat(chat_id);

		ChatService chatService = new ChatService();

		try {
			chatService.readChat(chat);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChatRead() {
		int user_id = 2;

		Chat chat = new Chat(user_id);

		ChatService chatService = new ChatService();

		try {
			assertTrue(chatService.readChat(chat));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadChatNullDetails() {
		Chat chat = null;

		ChatService chatService = new ChatService();

		try {
			assertFalse(chatService.readChat(chat));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
