package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test cases for the ChatService class, which handles
 * various chat-related operations.
 *
 * @author SusikumarPitchaimuth
 */
class TestChatService {
	// Chat group creation for direct conversation
	@Test
	void testCreateChatGroupForDirectConversation() {
		Chat chat = new Chat();
		chat.setChatType("direct");
		chat.setChatName("direct conversation");
		int[] participant = { 1, 2 };
		chat.setParticipantsId(participant);

		ChatService chatService = new ChatService();
		try {
			assertTrue(chatService.insertChatGroup(chat) && chatService.insertChatParticipants(chat));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	// Chat group creation for group

	@Test
	void testCreateChatGroupForGroupConversation() {
		Chat chat = new Chat();
		chat.setChatType("group");
		chat.setChatName("Naangalam Apdithan");
		chat.setGroupTheme("Hey there we are in the freshnest");
		chat.setGroupImage("https://about.fb.com/wp-content/uploads/2014/11/groupslogo2.jpg");
		int[] participant = { 1, 2 };
		chat.setParticipantsId(participant);

		ChatService chatService = new ChatService();
		try {
			assertTrue(chatService.createChatGroup(chat) && chatService.insertChatParticipants(chat));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	// Test the chat success
	@Test
	void testChatSuccess() {
		String chatText = "Hello baby..";

		Chat insertMessage = new Chat(1, 1, chatText);

		ChatService chatService = new ChatService();

		try {
			assertTrue(chatService.createChat(insertMessage));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	// test invalid chat details create
	@Test
	void testChatFailure() {
		String chatText = "";

		Chat insertMessage = new Chat(1, 1, chatText);

		ChatService chatService = new ChatService();

		ServiceException result = assertThrows(ServiceException.class, () -> chatService.createChat(insertMessage));
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

		int messageId = 3;
		Chat chat = new Chat();
		chat.setMessageId(messageId);
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
		int messageId = 0;

		Chat chat = new Chat();
		chat.setMessageId(messageId);
		ChatService chatService = new ChatService();

		ServiceException result = assertThrows(ServiceException.class, () -> chatService.deleteChat(chat));
		assertEquals(ChatConstants.getInvalidChatDeleteMessage(), result.getMessage());

	}
	
	
	@Test
	void testUserChatAccount() {
		int userId = 1;
		ChatService chatService = new ChatService();
		
		try {
			chatService.listAllUserChatGroupsByUserId(userId);
			
		}catch(ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

}
