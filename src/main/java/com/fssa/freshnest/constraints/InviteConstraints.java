package com.fssa.freshnest.constraints;

public class InviteConstraints {
    private static final String INVALID_INVITE_CREATE_MESSAGE = "invite create details are not valid";
    private static final String INVALID_INVITE_UPDATE_MESSAGE = "invite update details are not valid";
    private static final String INVALID_INVITE_DELETE_MESSAGE = "invite delete details are not valid";
    private static final String INVALID_INVITE_REACT_MESSAGE = "invite react details are not valid";

    // Each invite details validator message
    private static final String INVALID_INVITE_TYPE_MESSAGE = "invite type is not valid";
    private static final String INVALID_INVITE_DATE_MESSAGE = "invite date is not valid";
    private static final String INVALID_INVITE_TIME_MESSAGE = "invite time is not valid";
    private static final String INVALID_INVITE_EXPLANATION_MESSAGE = "invite explanation is not valid";
    private static final String INVALID_INVITE_CHAT_MESSAGE = "invite chat message is not valid";

    public static String getInvalidInviteCreateMessage() {
        return INVALID_INVITE_CREATE_MESSAGE;
    }

    public static String getInvalidInviteUpdateMessage() {
        return INVALID_INVITE_UPDATE_MESSAGE;
    }

    public static String getInvalidInviteDeleteMessage() {
        return INVALID_INVITE_DELETE_MESSAGE;
    }

    public static String getInvalidInviteReactMessage() {
        return INVALID_INVITE_REACT_MESSAGE;
    }

    public static String getInvalidInviteTypeMessage() {
        return INVALID_INVITE_TYPE_MESSAGE;
    }

    public static String getInvalidInviteDateMessage() {
        return INVALID_INVITE_DATE_MESSAGE;
    }

    public static String getInvalidInviteTimeMessage() {
        return INVALID_INVITE_TIME_MESSAGE;
    }

    public static String getInvalidInviteExplanationMessage() {
        return INVALID_INVITE_EXPLANATION_MESSAGE;
    }

    public static String getInvalidInviteChatMessage() {
        return INVALID_INVITE_CHAT_MESSAGE;
    }

}
