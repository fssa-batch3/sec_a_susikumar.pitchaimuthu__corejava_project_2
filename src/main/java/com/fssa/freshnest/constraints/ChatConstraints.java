package com.fssa.freshnest.constraints;

public class ChatConstraints {
    private static final String INVALID_CHAT_SEND_MESSAGE = "chat sending details are not valid";
    private static final String INVALID_CHAT_READ_MESSAGE = "chat read details are not valid";
    private static final String INVALID_CHAT_UPDATE_MESSAGE = "chat update details are not valid";
    private static final String INVALID_CHAT_DELETE_MESSAGE = "chat delete details are not valid";

    // Each chat details validator
    private static final String INVALID_CHAT_TEXT_MESSAGE = "chat text is not valid";
    private static final String INVALID_CHAT_TYPE_MESSAGE = "chat type is not valid";
    private static final String INVALID_CHAT_GROUP_NAME_MESSAGE = "chat group is not valid";

    public static String getInvalidChatSendMessage() {
        return INVALID_CHAT_SEND_MESSAGE;
    }

    public static String getInvalidChatReadMessage() {
        return INVALID_CHAT_READ_MESSAGE;
    }

    public static String getInvalidChatUpdateMessage() {
        return INVALID_CHAT_UPDATE_MESSAGE;
    }

    public static String getInvalidChatDeleteMessage() {
        return INVALID_CHAT_DELETE_MESSAGE;
    }

    public static String getInvalidChatTextMessage() {
        return INVALID_CHAT_TEXT_MESSAGE;
    }

    public static String getInvalidChatTypeMessage() {
        return INVALID_CHAT_TYPE_MESSAGE;
    }

    public static String getInvalidChatGroupNameMessage() {
        return INVALID_CHAT_GROUP_NAME_MESSAGE;
    }

}
