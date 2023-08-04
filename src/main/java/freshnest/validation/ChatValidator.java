package freshnest.validation;

import freshnest.model.Chat;
import freshnest.validation.exceptions.InvalidUserException;

public class ChatValidator {

	// create chat
	public static boolean validateCreateChat(Chat chat) throws InvalidUserException {

		if (chat != null && validateChat(chat.getChat())) {
			return true;
		} else {
			throw new InvalidUserException("chat details is not valid");
		}

	}
	
	// read chat
		public static boolean validateReadChat(Chat chat) throws InvalidUserException {

			if (chat != null && validateChat(chat.getChat())) {
				return true;
			} else {
				throw new InvalidUserException("chat details is not valid");
			}

		}

	// update chat

	public static boolean validateUpdateChat(Chat chat) throws InvalidUserException {

		if (chat != null && validateChat(chat.getChat())) {
			return true;
		} else {
			throw new InvalidUserException("chat details is not valid");
		}

	}

	// Delete chat

	public static boolean validateDeleteChat(Chat chat) throws InvalidUserException {

		if (chat != null && validateChat(chat.getChat())) {
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
