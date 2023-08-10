package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class ChatValidator {

	private static final String INVALID_CHAT_MESSAGE = "chat details are not valid";
	// create chat
	public static boolean validateCreateChat(Chat insertChat, Chat insertChatParticipant, Chat insertMessage)
			throws InvalidUserException {

		if (insertChat != null && insertChatParticipant != null && insertMessage != null
				&& validateChat(insertMessage.getChatMessage()) && validateChatType(insertChat.getChatType())
				&& validateChatGroupName(insertChat.getChatName())) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_CHAT_MESSAGE);
		}

	}

	// read chat
	public static boolean validateReadChat(Chat chat) throws InvalidUserException {

		if (chat != null) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_CHAT_MESSAGE);
		}

	}

	// update chat

	public static boolean validateUpdateChat(Chat chat) throws InvalidUserException {

		if (chat != null) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_CHAT_MESSAGE);
		}

	}

	// Delete chat

	public static boolean validateDeleteChat(Chat chat) throws InvalidUserException {

		if (chat != null) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_CHAT_MESSAGE);
		}

	}

	public static boolean validateChat(String chat) {

		boolean match = false;
		if (chat == null || chat.equals(" ") || chat.isEmpty())
			return false;
		String regex = "^.+$";

		String chatMessage = "...";
		if (chatMessage.matches(regex)) {
			match = true;
			System.out.println("The chat message is valid");
		} else {
			match = false;
			System.out.println("The chat message is not valid");
		}

		return match;
	}

	// validate chat type
	public static boolean validateChatType(String type) {

		if (type.equals("direct") || type.equals("group")) {
			System.out.println("The chat type is valid");
			return true;
		} else {

			System.out.println("The chat type is not valid");
			return false;
		}

	}

	// validate chat group name
	public static boolean validateChatGroupName(int name) {
		if (name > 0) {
			System.out.println("The chat name is valid");
			return true;
		} else {
			System.out.println("The chat name is not valid");
			return false;
		}

	}

}
