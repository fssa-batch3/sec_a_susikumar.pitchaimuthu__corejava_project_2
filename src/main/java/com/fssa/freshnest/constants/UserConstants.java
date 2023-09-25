package com.fssa.freshnest.constants;

/**
 * This class contains constant messages related to user validation,
 * registration, login, profile updates, and other user-related operations.
 *
 * @author SusikumarPitchaimuth
 */
public class UserConstants {

    // Total validator message

    private static final String INVALID_USER_REGISTRATION_MESSAGE = "User registration details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_LOGIN_MESSAGE = "User log in details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_SECOND_PAGE_REGISTRATION_MESSAGE = "User second page registration details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_UPDATE_MESSAGE = "User profile update details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_PROFILE_IMAGE_UPDATE_MESSAGE = "User user profile image update details are not valid. Please enter the valid information using the error message.";
    private static final String INVALID_USER_DELETE_MESSAGE = "User account delete details are not valid. Please enter the valid information using the error message.";
    private static final String EMAIL_ID_NOT_EXISTS_MESSAGE = "User account delete details are not valid. Please enter the valid information using the error message.";
    private static final String USER_DETAILS_NOT_FOUND = "User Details not exists.";
    private static final String LOGIN_PASSWORD_INVALID = "Invalid Password";

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

    // creating the getters and setter to get the message

    /**
     * Get the message for an invalid user registration.
     *
     * @return The invalid user registration message.
     */
    public static String getInvalidUserRegistrationMessage() {
        return INVALID_USER_REGISTRATION_MESSAGE;
    }

    /**
     * Get the message for an invalid user Login.
     *
     * @return The invalid user login message.
     */

    public static String getInvalidUserLoginMessage() {
        return INVALID_USER_LOGIN_MESSAGE;
    }

    /**
     * Get the message for an invalid user second page registration details.
     *
     * @return The invalid user second page registration details.
     */

    public static String getInvalidUserSecondPageRegistrationMessage() {
        return INVALID_USER_SECOND_PAGE_REGISTRATION_MESSAGE;
    }

    /**
     * Get the message for an invalid user update.
     *
     * @return The invalid user update message.
     */
    public static String getInvalidUserUpdateMessage() {
        return INVALID_USER_UPDATE_MESSAGE;
    }

    /**
     * Get the message for an invalid user profile image update.
     *
     * @return The invalid user profile image update message.
     */
    public static String getInvalidUserProfileImageUpdateMessage() {
        return INVALID_USER_PROFILE_IMAGE_UPDATE_MESSAGE;
    }

    /**
     * Get the message for an invalid user account delete.
     *
     * @return The invalid user update details.
     */

    public static String getInvalidUserDeleteMessage() {
        return INVALID_USER_DELETE_MESSAGE;
    }

    /**
     * Get the message for an invalid first name.
     *
     * @return The invalid user first name message.
     */

    public static String getInvalidUserFirstNameMessage() {
        return INVALID_USER_FIRST_NAME_MESSAGE;
    }

    /**
     * Get the message for an invalid last name.
     *
     * @return The invalid user last name message.
     */

    public static String getInvalidUserLastNameMessage() {
        return INVALID_USER_LAST_NAME_MESSAGE;
    }

    /**
     * Get the message for an invalid password.
     *
     * @return The invalid password message.
     */

    public static String getInvalidUserPasswordMessage() {
        return INVALID_USER_PASSWORD_MESSAGE;
    }

    /**
     * Get the message for an invalid email.
     *
     * @return The invalid user email message.
     */

    public static String getInvalidUserEmailMessage() {
        return INVALID_USER_EMAIL_MESSAGE;
    }

    /**
     * Get the message for an invalid username.
     *
     * @return The invalid username message.
     */
    public static String getInvalidUserUserNameMessage() {
        return INVALID_USER_USER_NAME_MESSAGE;
    }

    /**
     * Get the message for an invalid date of birth.
     *
     * @return The invalid user date of birth message.
     */
    public static String getInvalidUserDobMessage() {
        return INVALID_USER_DOB_MESSAGE;
    }

    /**
     * Get the message for an invalid nationality.
     *
     * @return The invalid user nationality message.
     */
    public static String getInvalidUserNationalityMessage() {
        return INVALID_USER_NATIONALITY_MESSAGE;
    }

    /**
     * Get the message for an invalid mobile number.
     *
     * @return The invalid User mobile number message.
     */

    public static String getInvalidUserMobileNumberMessage() {
        return INVALID_USER_MOBILE_NUMBER_MESSAGE;
    }

    /**
     * Get the message for an invalid gender.
     *
     * @return The invalid user gender message.
     */

    public static String getInvalidUserGenderMessage() {
        return INVALID_USER_GENDER_MESSAGE;
    }

    /**
     * Get the message for an invalid profile image.
     *
     * @return The invalid user user name message.
     */

    public static String getInvalidUserProfileImageUrlMessage() {
        return INVALID_USER_PROFILE_IMAGE_URL_MESSAGE;
    }

    /**
     * Get the message for an email not exist.
     *
     * @return The invalid email not exists message.
     */
    public static String getEmailIdNotExistsMessage() {
        return EMAIL_ID_NOT_EXISTS_MESSAGE;
    }

    public static String getUserDetailsNotFound() {
        return USER_DETAILS_NOT_FOUND;
    }

    public static String getLoginPasswordInvalid() {
        return LOGIN_PASSWORD_INVALID;
    }
}
