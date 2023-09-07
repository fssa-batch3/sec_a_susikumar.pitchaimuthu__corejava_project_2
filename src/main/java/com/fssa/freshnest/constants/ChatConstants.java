package com.fssa.freshnest.constants;

/**
 * This class contains constant error messages related to chat validation scenarios.
 * These error messages are used to provide standardized error descriptions for various
 * chat-related operations and validation checks.
 *
 * @author SusikumarPitchaimuth
 */
public class ChatConstants {
    private static final String INVALID_CHAT_SEND_MESSAGE = "chat sending details are not valid";
    private static final String INVALID_CHAT_READ_MESSAGE = "chat read details are not valid";
    private static final String INVALID_CHAT_UPDATE_MESSAGE = "chat update details are not valid";
    private static final String INVALID_CHAT_DELETE_MESSAGE = "chat delete details are not valid";

    // Each chat details validator
    private static final String INVALID_CHAT_TEXT_MESSAGE = "chat text is not valid";
    private static final String INVALID_CHAT_TYPE_MESSAGE = "chat type is not valid";
    private static final String NULL_CHAT_TYPE = "chat type is null";


   
	/**
     * Gets the error message for invalid chat sending details.
     *
     * @return The error message for invalid chat sending details.
     */
    public static String getInvalidChatSendMessage() {
        return INVALID_CHAT_SEND_MESSAGE;
    }

    /**
     * Gets the error message for invalid chat read details.
     *
     * @return The error message for invalid chat read details.
     */
    public static String getInvalidChatReadMessage() {
        return INVALID_CHAT_READ_MESSAGE;
    }

    /**
     * Gets the error message for invalid chat update details.
     *
     * @return The error message for invalid chat update details.
     */
    public static String getInvalidChatUpdateMessage() {
        return INVALID_CHAT_UPDATE_MESSAGE;
    }

    /**
     * Gets the error message for invalid chat delete details.
     *
     * @return The error message for invalid chat delete details.
     */
    public static String getInvalidChatDeleteMessage() {
        return INVALID_CHAT_DELETE_MESSAGE;
    }

    /**
     * Gets the error message for invalid chat text.
     *
     * @return The error message for invalid chat text.
     */
    public static String getInvalidChatTextMessage() {
        return INVALID_CHAT_TEXT_MESSAGE;
    }

    /**
     * Gets the error message for invalid chat type.
     *
     * @return The error message for invalid chat type.
     */
    public static String getInvalidChatTypeMessage() {
        return INVALID_CHAT_TYPE_MESSAGE;
    }

    public static String getNullChatType() {
		return NULL_CHAT_TYPE;
	}


}
