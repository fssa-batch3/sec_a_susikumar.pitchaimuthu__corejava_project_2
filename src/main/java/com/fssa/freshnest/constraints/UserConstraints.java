package com.fssa.freshnest.constraints;

public class UserConstraints {

    // Total validator message
    private static final String INVALID_USER_REGISTRATION_MESSAGE = "User registration details are not valid";
    private static final String INVALID_USER_LOGIN_MESSAGE = "User log in details are not valid";
    private static final String INVALID_USER_SECOND_PAGE_REGISTRATION_MESSAGE = "User second page registration details are not valid";
    private static final String INVALID_USER_UPDATE_MESSAGE = "User profile update details are not valid";
    private static final String INVALID_USER_PROFILE_IMAGE_UPDATE_MESSAGE = "User user profile image update details are not valid";
    private static final String INVALID_USER_DELETE_MESSAGE = "User account delete details are not valid";

    // Each validator message

    // first name validator message
    private static final String INVALID_USER_FIRST_NAME_MESSAGE = "User first name is not valid";
    private static final String INVALID_USER_LAST_NAME_MESSAGE = "User last name is not valid";
    private static final String INVALID_USER_PASSWORD_MESSAGE = "User password is not valid";
    private static final String INVALID_USER_EMAIL_MESSAGE = "User email is not valid";
    private static final String INVALID_USER_USER_NAME_MESSAGE = "User user name is  not valid";
    private static final String INVALID_USER_DOB_MESSAGE = "User date of birth is not valid";
    private static final String INVALID_USER_NATIONALITY_MESSAGE = "User nationality is not valid";
    private static final String INVALID_USER_MOBILE_NUMBER_MESSAGE = "User mobile number is not valid";
    private static final String INVALID_USER_GENDER_MESSAGE = "User gender is not valid";
    private static final String INVALID_USER_PROFILE_IMAGE_URL_MESSAGE = "User profile image url is not valid";
    private static final String NULL_USER_PROFILE_IMAGE_URL_MESSAGE = "User profile image url is not valid";

    // creating the getters and setter to get the message

    public static String getInvalidUserRegistrationMessage() {
        return INVALID_USER_REGISTRATION_MESSAGE;
    }

    public static String getInvalidUserLoginMessage() {
        return INVALID_USER_LOGIN_MESSAGE;
    }

    public static String getInvalidUserSecondPageRegistrationMessage() {
        return INVALID_USER_SECOND_PAGE_REGISTRATION_MESSAGE;
    }

    public static String getInvalidUserUpdateMessage() {
        return INVALID_USER_UPDATE_MESSAGE;
    }

    public static String getInvalidUserProfileImageUpdateMessage() {
        return INVALID_USER_PROFILE_IMAGE_UPDATE_MESSAGE;
    }

    public static String getInvalidUserDeleteMessage() {
        return INVALID_USER_DELETE_MESSAGE;
    }

    public static String getInvalidUserFirstNameMessage() {
        return INVALID_USER_FIRST_NAME_MESSAGE;
    }

    public static String getInvalidUserLastNameMessage() {
        return INVALID_USER_LAST_NAME_MESSAGE;
    }

    public static String getInvalidUserPasswordMessage() {
        return INVALID_USER_PASSWORD_MESSAGE;
    }

    public static String getInvalidUserEmailMessage() {
        return INVALID_USER_EMAIL_MESSAGE;
    }


    public static String getInvalidUserUserNameMessage() {
        return INVALID_USER_USER_NAME_MESSAGE;
    }

    public static String getInvalidUserDobMessage() {
        return INVALID_USER_DOB_MESSAGE;
    }

    public static String getInvalidUserNationalityMessage() {
        return INVALID_USER_NATIONALITY_MESSAGE;
    }

    public static String getInvalidUserMobileNumberMessage() {
        return INVALID_USER_MOBILE_NUMBER_MESSAGE;
    }

    public static String getInvalidUserGenderMessage() {
        return INVALID_USER_GENDER_MESSAGE;
    }

    public static String getInvalidUserProfileImageUrlMessage() {
        return INVALID_USER_PROFILE_IMAGE_URL_MESSAGE;
    }

    public static String getInvalidNullUserProfileImageUrlMessage() {
        return NULL_USER_PROFILE_IMAGE_URL_MESSAGE;
    }

}
