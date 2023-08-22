package com.fssa.freshnest.constants;

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

    public static String getInvalidStillTakeMessage() {
        return INVALID_STILL_TAKE_MESSAGE;
    }

    public static String getInvalidStillFavouriteMessage() {
        return INVALID_STILL_FAVOURITE_MESSAGE;
    }

    public static String getInvalidStillUpdateMessage() {
        return INVALID_STILL_UPDATE_MESSAGE;
    }

    public static String getInvalidStillDeleteMessage() {
        return INVALID_STILL_DELETE_MESSAGE;
    }

    public static String getInvalidStillReadMessage() {
        return INVALID_STILL_READ_MESSAGE;
    }

    public static String getInvalidStillUrlMessage() {
        return INVALID_STILL_URL_MESSAGE;
    }

    public static String getInvalidStillNameMessage() {
        return INVALID_STILL_NAME_MESSAGE;
    }

    public static String getInvalidStillIdMessage() {
        return INVALID_STILL_ID_MESSAGE;
    }

    public static String getInvalidStillDateMessage() {
        return INVALID_STILL_DATE_MESSAGE;
    }

    public static String getInvalidStillTimeMessage() {
        return INVALID_STILL_TIME_MESSAGE;
    }

    public static String getInvalidStillUseridMessage() {
        return INVALID_STILL_USERID_MESSAGE;
    }

    public static String getCommonDaoErrorMessage() {
        return COMMON_DAO_ERROR_MESSAGE;
    }

    public static String getCommonServiceErrorMessage() {
        return COMMON_SERVICE_ERROR_MESSAGE;
    }


}
