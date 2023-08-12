package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.ChatConstraints;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class ChatValidator {


    // create chat
    public static boolean validateCreateChat(Chat insertChat, Chat insertChatParticipant, Chat insertMessage)
            throws InvalidUserException {

        if (insertChat != null && insertChatParticipant != null && insertMessage != null
                && validateChat(insertMessage.getChatMessage()) && validateChatType(insertChat.getChatType())
                && validateChatGroupName(insertChat.getChatName())) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstraints.getInvalidChatSendMessage());
        }

    }

    // read chat
    public static boolean validateReadChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstraints.getInvalidChatReadMessage());
        }

    }

    // update chat

    public static boolean validateUpdateChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstraints.getInvalidChatUpdateMessage());
        }

    }

    // Delete chat

    public static boolean validateDeleteChat(Chat chat) throws InvalidUserException {

        if (chat != null) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstraints.getInvalidChatDeleteMessage());
        }

    }

    public static boolean validateChat(String chat) throws InvalidUserException {

        boolean match;
        if (chat == null ||chat.isEmpty())
            return false;
        String regex = "^.+$";

        String chatMessage = "...";
        if (chatMessage.matches(regex)) {
            match = true;
        } else {
            throw new InvalidUserException(ChatConstraints.getInvalidChatTextMessage());
        }

        return match;
    }

    // validate chat type
    public static boolean validateChatType(String type) throws InvalidUserException {

        if (type.equals("direct") || type.equals("group")) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstraints.getInvalidChatTypeMessage());
        }

    }

    // validate chat group name
    public static boolean validateChatGroupName(int name) throws InvalidUserException {
        if (name > 0) {
            return true;
        } else {
            throw new InvalidUserException(ChatConstraints.getInvalidChatGroupNameMessage());
        }

    }

}
