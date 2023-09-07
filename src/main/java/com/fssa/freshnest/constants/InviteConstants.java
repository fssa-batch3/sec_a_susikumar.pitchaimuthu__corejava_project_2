package com.fssa.freshnest.constants;

/**
 * This class contains constant error messages related to invite validation scenarios.
 * These error messages are used to provide standardized error descriptions for various
 * invite-related operations and validation checks.
 *
 * @author SusikumarPitchaimuth
 */
public class InviteConstants {
    private static final String INVALID_INVITE_CREATE_MESSAGE = "invite create details are not valid";
    private static final String INVALID_INVITE_UPDATE_MESSAGE = "invite update details are not valid";
    private static final String INVALID_INVITE_DELETE_MESSAGE = "invite delete details are not valid";
    private static final String INVALID_INVITE_READ_MESSAGE = "invite react details are not valid";


    // Each invite details validator message
    private static final String INVALID_INVITE_TYPE_MESSAGE = "invite type is not valid. The invite name should not be empty or length is less than 3. The name should be like this /Birthday/ or/Lovers day/ ";
    private static final String NULL_INVITE_DATE_MESSAGE = "invite date is not valid. The invite date should not be null";
    private static final String INVALID_INVITE_DATE_MESSAGE = "invite date is not valid. The invite date should be in future";
    private static final String INVALID_INVITE_TIME_MESSAGE = "invite time is not valid. The invite time should be in future";
    private static final String INVALID_INVITE_EXPLANATION_MESSAGE = "invite explanation is not valid.";


    public static String getNullInviteDateMessage() {
        return NULL_INVITE_DATE_MESSAGE;
    }

    /**
     * Gets the error message for invalid invite creation details.
     *
     * @return The error message for invalid invite creation details.
     */
    public static String getInvalidInviteCreateMessage() {
        return INVALID_INVITE_CREATE_MESSAGE;
    }

    /**
     * Gets the error message for invalid invite update details.
     *
     * @return The error message for invalid invite update details.
     */
    public static String getInvalidInviteUpdateMessage() {
        return INVALID_INVITE_UPDATE_MESSAGE;
    }

    /**
     * Gets the error message for invalid invite deletion details.
     *
     * @return The error message for invalid invite deletion details.
     */
    public static String getInvalidInviteDeleteMessage() {
        return INVALID_INVITE_DELETE_MESSAGE;
    }


    

    /**
     * Gets the error message for invalid invite type.
     *
     * @return The error message for invalid invite type.
     */
    public static String getInvalidInviteTypeMessage() {
        return INVALID_INVITE_TYPE_MESSAGE;
    }

    /**
     * Gets the error message for invalid invite date.
     *
     * @return The error message for invalid invite date.
     */
    public static String getInvalidInviteDateMessage() {
        return INVALID_INVITE_DATE_MESSAGE;
    }

    /**
     * Gets the error message for invalid invite time.
     *
     * @return The error message for invalid invite time.
     */
    public static String getInvalidInviteTimeMessage() {
        return INVALID_INVITE_TIME_MESSAGE;
    }

    /**
     * Gets the error message for invalid invite explanation.
     *
     * @return The error message for invalid invite explanation.
     */
    public static String getInvalidInviteExplanationMessage() {
        return INVALID_INVITE_EXPLANATION_MESSAGE;
    }


    /**
     * Gets the error message for invalid invite read message;
     *
     * @return The error message for the invalid invite read details.
     */
    public static String getInvalidInviteReadMessage() {
        return INVALID_INVITE_READ_MESSAGE;
    }

}
