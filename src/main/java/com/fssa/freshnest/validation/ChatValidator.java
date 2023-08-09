package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class ChatValidator {

	// create chat
	public static boolean validateCreateChat(Chat insertChat, Chat insertChatParticipant, Chat insertMessage)
			throws InvalidUserException {

		if (insertChat != null && insertChatParticipant != null && insertMessage != null
				&& validateChat(insertMessage.getChat_message())) {
			return true;
		} else {
			throw new InvalidUserException("chat details is not valid");
		}

	}

	// read chat
	public static boolean validateReadChat(Chat chat) throws InvalidUserException {

		if (chat != null) {
			return true;
		} else {
			throw new InvalidUserException("chat details is not valid");
		}

	}

	// update chat

	public static boolean validateUpdateChat(Chat chat) throws InvalidUserException {

		if (chat != null) {
			return true;
		} else {
			throw new InvalidUserException("chat details is not valid");
		}

	}

	// Delete chat

	public static boolean validateDeleteChat(Chat chat) throws InvalidUserException {

		if (chat != null) {
			return true;
		} else {
			throw new InvalidUserException("chat details is not valid");
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

}
