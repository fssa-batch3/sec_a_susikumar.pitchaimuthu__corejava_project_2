package com.fssa.freshnest.constants;

public class UserConstants {

    // Total validator message
    private static final String COMMON_SERVICE_ERROR_MESSAGE = "com.fssa.freshnest.validation.exceptions.InvalidUserException: ";
    private static final String COMMON_DAO_ERROR_MESSAGE = "com.fssa.freshnest.dao.exceptions.DAOException: ";


    private static final String INVALID_USER_REGISTRATION_MESSAGE = "User registration details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_LOGIN_MESSAGE = "User log in details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_SECOND_PAGE_REGISTRATION_MESSAGE = "User second page registration details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_UPDATE_MESSAGE = "User profile update details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_PROFILE_IMAGE_UPDATE_MESSAGE = "User user profile image update details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_DELETE_MESSAGE = "User account delete details are not valid. Please enter the valid information using the error message.";
    private static final String EMAIL_ID_NOT_EXISTS_MESSAGE = "User account delete details are not valid. Please enter the valid information using the error message.";


    // Each validator message

    // first name validator message
    private static final String INVALID_USER_FIRST_NAME_MESSAGE = "User first name is not valid. The expected first name should be like this / Rizwan /";
    private static final String INVALID_USER_LAST_NAME_MESSAGE = "User last name is not valid. The expected last name should be like this / Pitchaimani / ";
    private static final String INVALID_USER_PASSWORD_MESSAGE = "User password is not valid. The expected password should be like this / Susi123@SM /";
    private static final String INVALID_USER_EMAIL_MESSAGE = "User email is not valid. The excepted email should be like this / susi123@gmail.com /";
    private static final String INVALID_USER_USER_NAME_MESSAGE = "User user name is  not valid. The expected user should be like / I am susi/ OR / @Iamsusi / ";
    private static final String INVALID_USER_DOB_MESSAGE = "User date of birth is not valid. The age of date of birth should be more than / 18 /";
    private static final String INVALID_USER_NATIONALITY_MESSAGE = "User nationality is not valid. The excepted nationality should be like this / India /";
    private static final String INVALID_USER_MOBILE_NUMBER_MESSAGE = "User mobile number is not valid. The excepted mobile number should be like this / 8870707010 /";
    private static final String INVALID_USER_GENDER_MESSAGE = "User gender is not valid. The expected gender should be like this / Male / OR / Female / OR / Others /";
    private static final String INVALID_USER_PROFILE_IMAGE_URL_MESSAGE = "User profile image url is not valid. The expected image url details should be like this / https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV0eSVHdi6kySfEoKSX-Og4sdngryH2BygPQ&usqp=CAU /";
    private static final String NULL_USER_PROFILE_IMAGE_URL_MESSAGE = "User profile image url is not valid. The expected profile image url details should be like this / https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV0eSVHdi6kySfEoKSX-Og4sdngryH2BygPQ&usqp=CAU / ";

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

    public static String getCommonServiceErrorMessage() {
        return COMMON_SERVICE_ERROR_MESSAGE;
    }

    public static String getNullUserProfileImageUrlMessage() {
        return NULL_USER_PROFILE_IMAGE_URL_MESSAGE;
    }

    public static String getEmailIdNotExistsMessage() {
        return EMAIL_ID_NOT_EXISTS_MESSAGE;
    }

    public static String getCommonDaoErrorMessage() {
        return COMMON_DAO_ERROR_MESSAGE;
    }

}
