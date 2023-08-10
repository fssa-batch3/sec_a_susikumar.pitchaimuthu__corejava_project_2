package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Chat;

public class TestChatDeleteFeature {

	public static void main(String[] args) {
		int chatId = 1;
		int messageId = 2;
		
		Chat chat = new Chat(true, chatId, messageId);
		ChatService chatService = new ChatService();
		try {
			chatService.deleteChat(chat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	@Test
	public void testChatDeleteSuccess() {

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

	@Test
	public void testDeleteFailure() {
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
