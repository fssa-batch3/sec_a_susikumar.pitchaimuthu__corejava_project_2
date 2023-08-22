package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class ChatValidator {

    // create chat
    public static boolean validateCreateChat(Chat insertChat, Chat insertChatParticipant, Chat insertMessage)
            throws InvalidUserException {

        if (insertChat != null && insertChatParticipant != null && insertMessage != null
                && validateChat(insertMessage.getChatMessage()) && validateChatType(insertChat.getChatType())) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatSendMessage());
        }

    }

    // read chat
    public static boolean validateReadChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatReadMessage());
        }

    }

    // update chat

    public static boolean validateUpdateChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatUpdateMessage());
        }

    }

    // Delete chat

    public static boolean validateDeleteChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatDeleteMessage());
        }

    }

    public static boolean validateChat(String chat) throws InvalidUserException {

        if (chat == null || chat.isEmpty())
            return false;

        String regex = "^.+$";

        String chatMessage = "...";
        if (chatMessage.matches(regex)) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatTextMessage());
        }

    }

    // validate chat type
    public static boolean validateChatType(String type) throws InvalidUserException {

        if (type.isEmpty()) {
            return false;
        }

        if (type.equals("direct") || type.equals("group")) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstants.getInvalidChatTypeMessage());
        }
    }

}
