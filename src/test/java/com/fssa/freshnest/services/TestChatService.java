package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;



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
			assertTrue(chatService.insertDirectGroup(chat) && chatService.insertChatParticipants(chat));
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

	// Get specific chat group details

	@Test
	void testGetSpecificChatGroupDetails() {
		int chatId = 1;
		int userId = 1;
		ChatService chatService = new ChatService();
		Chat chat = new Chat();
		chat.setChatId(chatId);
		String chatType = "group";
		chat.setUserId(userId);
		
		try {
			Chat chatGroupDetails;

			if (chatType.equals("direct")) {
				chatGroupDetails = chatService.getDirectChatGroupDetails(chat);
			} else {
				chatGroupDetails = chatService.getGroupChatDetails(chat);
			}

			List<Chat> chatMessages = chatService.getSpecificChatGroupChatMessages(chatGroupDetails);
			assertNotNull(chatMessages);
		}catch(ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void testGetDirectConversationChatGroupDetails() {
		int chatId = 1;
		int userId = 1;
		ChatService chatService = new ChatService();
		Chat chat = new Chat();
		chat.setChatId(chatId);
		String chatType = "direct";
		chat.setUserId(userId);
		
		try {
			Chat chatGroupDetails;

			if (chatType.equals("direct")) {
				chatGroupDetails = chatService.getDirectChatGroupDetails(chat);
			} else {
				chatGroupDetails = chatService.getGroupChatDetails(chat);
			}

			List<Chat> chatMessages = chatService.getSpecificChatGroupChatMessages(chatGroupDetails);
			assertNotNull(chatMessages);
		}catch(ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	@Test
	void getUserChatGroupsAndDetails() {
		ChatService chatService = new ChatService();
		int userId = 1;
		
		try {
		List<Chat> chatGroups = chatService.getUserChatGroups(userId);
		List<Chat> groups = new ArrayList<>(); 
		
		for (Chat ch : chatGroups) {
		    String chatType = ch.getChatType(); 
		    int chatId = ch.getChatId();
		    if(chatType.equals("direct")) {
		    	groups.add(chatService.getUserDirectConversationGroupDetails(chatId, userId));
		    }else {
		    	groups.add(chatService.getUserGroupConversationGroupDetails(chatId, userId));
		    }
		}
		assertNotNull(groups);
		}catch(ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

}
