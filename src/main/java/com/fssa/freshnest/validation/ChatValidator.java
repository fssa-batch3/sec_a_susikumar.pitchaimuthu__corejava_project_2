package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

/**
 * This class provides methods to validate chat-related data and operations.
 *
 * @author SusikumarPitchaimuth
 */

public class ChatValidator {

  

    /**
     * Validates the data for creating a chat, adding participants, and sending a
     * message.
     *
     * @param insertMessage The Chat object for sending a message.
     * @return True if the chat data is valid, otherwise throws
     * InvalidUserException.
     * @throws InvalidUserException If the chat data is invalid.
     */

    // create chat
    public static boolean validateChatSendMessage(Chat insertMessage) throws InvalidUserException {

        if (insertMessage != null && validateChat(insertMessage.getChatMessage())) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatSendMessage());
        }

    }

    /**
     * Validates the data for reading chat messages.
     *
     * @param chat The Chat object for reading chat messages.
     * @return True if the chat data is valid, otherwise throws
     * InvalidUserException.
     * @throws InvalidUserException If the chat data is invalid.
     */

    // read chat
    public static boolean validateReadChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatReadMessage());
        }

    }

    /**
     * Validates the data for updating chat messages.
     *
     * @param chat The Chat object for updating chat messages.
     * @return True if the chat data is valid, otherwise throws
     * InvalidUserException.
     * @throws InvalidUserException If the chat data is invalid.
     */
    // update chat
    public static boolean validateUpdateChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatUpdateMessage());
        }

    }


    /**
     * Validates the chat message content.
     *
     * @param chat The chat message to be validated.
     * @return True if the chat message is valid, otherwise throws
     * InvalidUserException.
     * @throws InvalidUserException If the chat message is invalid.
     */
    public static boolean validateChat(String chat) throws InvalidUserException {

        if (chat == null)
            return false;

        if (chat.trim().isEmpty()) {
            throw new InvalidUserException(ChatConstants.getInvalidChatTextMessage());

        }
        String regex = "^.+$";

        String chatMessage = "...";
        if (chatMessage.matches(regex)) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatTextMessage());
        }

    }

    /**
     * Validates the chat type.
     *
     * @param type The chat type to be validated.
     * @return True if the chat type is valid, otherwise throws
     * InvalidUserException.
     * @throws InvalidUserException If the chat type is invalid.
     */

    // validate chat type
    public static boolean validateChatType(String type) throws InvalidUserException {
        if (type == null) {
            return false;
        }

        if (type.trim().isEmpty())
            throw new InvalidUserException(ChatConstants.getNullChatType());

        if (type.equals("direct") || type.equals("group")) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatTypeMessage());
        }
    }

}
