package com.fssa.freshnest.constants;

/**
 * This class contains constant messages related to still (possibly an image or media content)
 * validation, creation, update, deletion, and other still-related operations.
 *
 * @author SusikumarPitchaimuth
 */

public class StillConstants {

    private static final String COMMON_DAO_ERROR_MESSAGE = "com.fssa.freshnest.dao.exceptions.DAOException: ";
    private static final String COMMON_SERVICE_ERROR_MESSAGE = "com.fssa.freshnest.validation.exceptions.InvalidUserException: ";


    private static final String INVALID_STILL_TAKE_MESSAGE = "still create details are not valid";
    private static final String INVALID_STILL_FAVOURITE_MESSAGE = "still favourite details are not valid";
    private static final String INVALID_STILL_UPDATE_MESSAGE = "still update details are not valid";
    private static final String INVALID_STILL_DELETE_MESSAGE = "still delete details are not valid";
    private static final String INVALID_STILL_READ_MESSAGE = "still read details are not valid";

    // Each validator message

    private static final String INVALID_STILL_URL_MESSAGE = "still url is not valid";
    private static final String INVALID_STILL_NAME_MESSAGE = "still name is not valid";
    private static final String INVALID_STILL_ID_MESSAGE = "still id is not valid";
    private static final String INVALID_STILL_DATE_MESSAGE = "still date is not valid";
    private static final String INVALID_STILL_TIME_MESSAGE = "still time is not valid";
    private static final String INVALID_STILL_USERID_MESSAGE = "still user id not valid";


    /**
     * Get the message for invalid details during still creation.
     *
     * @return The invalid still creation message.
     */
    public static String getInvalidStillTakeMessage() {
        return INVALID_STILL_TAKE_MESSAGE;
    }

    /**
     * Get the message for invalid details during marking still as a favorite.
     *
     * @return The invalid still favorite message.
     */
    public static String getInvalidStillFavouriteMessage() {
        return INVALID_STILL_FAVOURITE_MESSAGE;
    }

    /**
     * Get the message for invalid details during still update.
     *
     * @return The message indicating that the details for updating a still are not valid.
     */
    public static String getInvalidStillUpdateMessage() {
        return INVALID_STILL_UPDATE_MESSAGE;
    }

    /**
     * Get the message for invalid details during still deletion.
     *
     * @return The message indicating that the details for deleting a still are not valid.
     */
    public static String getInvalidStillDeleteMessage() {
        return INVALID_STILL_DELETE_MESSAGE;
    }

    /**
     * Get the message for invalid details during still reading.
     *
     * @return The message indicating that the details for reading a still are not valid.
     */
    public static String getInvalidStillReadMessage() {
        return INVALID_STILL_READ_MESSAGE;
    }

    /**
     * Get the message for an invalid still URL.
     *
     * @return The message indicating that the provided still URL is not valid.
     */
    public static String getInvalidStillUrlMessage() {
        return INVALID_STILL_URL_MESSAGE;
    }

    /**
     * Get the message for an invalid still name.
     *
     * @return The message indicating that the provided still name is not valid.
     */
    public static String getInvalidStillNameMessage() {
        return INVALID_STILL_NAME_MESSAGE;
    }

    /**
     * Get the message for an invalid still ID.
     *
     * @return The message indicating that the provided still ID is not valid.
     */
    public static String getInvalidStillIdMessage() {
        return INVALID_STILL_ID_MESSAGE;
    }

    /**
     * Get the message for an invalid still date.
     *
     * @return The message indicating that the provided still date is not valid.
     */
    public static String getInvalidStillDateMessage() {
        return INVALID_STILL_DATE_MESSAGE;
    }

    /**
     * Get the message for an invalid still time.
     *
     * @return The message indicating that the provided still time is not valid.
     */
    public static String getInvalidStillTimeMessage() {
        return INVALID_STILL_TIME_MESSAGE;
    }

    /**
     * Get the message for an invalid still user ID.
     *
     * @return The message indicating that the provided still user ID is not valid.
     */
    public static String getInvalidStillUseridMessage() {
        return INVALID_STILL_USERID_MESSAGE;
    }

    /**
     * Get the common DAO error message.
     *
     * @return The common DAO error message.
     */
    public static String getCommonDaoErrorMessage() {
        return COMMON_DAO_ERROR_MESSAGE;
    }

    /**
     * Get the common service error message.
     *
     * @return The common service error message.
     */
    public static String getCommonServiceErrorMessage() {
        return COMMON_SERVICE_ERROR_MESSAGE;
    }


}
