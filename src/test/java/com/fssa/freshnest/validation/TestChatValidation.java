package com.fssa.freshnest.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

/**
 * This class contains JUnit test cases for validating the functionality of the
 * {@link ChatValidator} class.
 *
 * @author SusikumarPitchaimuth
 */
class TestChatValidation {
	/**
	 * Test case for validating a valid chat message. It ensures that the
	 * {@link ChatValidator#validateChat(String)} method properly validates a valid
	 * chat message. If the validation fails unexpectedly, the test will fail.
	 * 
	 * @throws InvalidUserException
	 */
	// test valid chat
	@Test
	void testValidChatSendMessage() throws InvalidUserException {
		Chat validChat = new Chat("Hello, world!");
		assertTrue(ChatValidator.validateChatSendMessage(validChat));
	}

	@Test
	void testInvalidChatSendMessageNullChat() {
		InvalidUserException result = assertThrows(InvalidUserException.class, () -> {
			ChatValidator.validateChatSendMessage(null);
		});
		assertEquals(result.getMessage(), ChatConstants.getInvalidChatSendMessage());
	}

	@Test
	void testInvalidChatSendMessageEmptyMessage() {
		Chat invalidChat = new Chat("");
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> {
			ChatValidator.validateChatSendMessage(invalidChat);
		});
		assertEquals(result.getMessage(), ChatConstants.getInvalidChatTextMessage());

	}

	@Test
	void testValidReadChat() throws InvalidUserException {
		Chat validChat = new Chat("Hello, world!");
		assertTrue(ChatValidator.validateReadChat(validChat));
	}

	@Test
	void testInvalidReadChatNullChat() {
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> {
			ChatValidator.validateReadChat(null);
		});
		assertEquals(result.getMessage(), ChatConstants.getInvalidChatReadMessage());

	}

	@Test
	void testValidUpdateChat() throws InvalidUserException {
		Chat validChat = new Chat("Hello, world!");
		assertTrue(ChatValidator.validateUpdateChat(validChat));
	}

	@Test
	void testInvalidUpdateChatNullChat() {
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> {
			ChatValidator.validateUpdateChat(null);
		});
		assertEquals(result.getMessage(), ChatConstants.getInvalidChatUpdateMessage());

	}
	

	@Test
	void testValidChat() throws InvalidUserException {
		String validChatMessage = "Hello, world!";
		assertTrue(ChatValidator.validateChat(validChatMessage));
	}

	@Test
	void testInvalidChatEmptyMessage() {
		String invalidChatMessage = "";
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> {
			ChatValidator.validateChat(invalidChatMessage);
		});
		assertEquals(result.getMessage(), ChatConstants.getInvalidChatTextMessage());

	}

	@Test
	void testValidChatTypeDirect() throws InvalidUserException {
		assertTrue(ChatValidator.validateChatType("direct"));
	}

	@Test
	void testValidChatTypeGroup() throws InvalidUserException {
		assertTrue(ChatValidator.validateChatType("group"));
	}

	@Test
	void testInvalidChatTypeEmptyType() {
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> {
			ChatValidator.validateChatType("");
		});
		assertEquals(result.getMessage(), ChatConstants.getNullChatType());

	}

	@Test
	void testInvalidChatTypeInvalidType() {
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> {
			ChatValidator.validateChatType("invalidType");
		});
		assertEquals(result.getMessage(), ChatConstants.getInvalidChatTypeMessage());

		
	}

}
