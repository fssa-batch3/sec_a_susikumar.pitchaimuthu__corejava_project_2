package com.fssa.freshnest.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.freshnest.constants.UserConstants;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

/**
 * This class provides methods to validate user-related data and operations.
 *
 * @author SusikumarPitchaimuth
 */
public class UserValidator {
	/**
	 * Validates user registration details.
	 *
	 * @param user The User object for registration.
	 * @return True if the user data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the user data is invalid.
	 */
	public static boolean validateUser(User user) throws InvalidUserException {

		if (user != null && validateFirstName(user.getFirstName()) && validateLastName(user.getLastName())
				&& validatePassword(user.getPassword()) && validateEmail(user.getEmail())
				&& validateUserName(user.getUsername())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserRegistrationMessage());
		}

	}

	/**
	 * Validates second page registration details.
	 *
	 * @param user The User object for the second page of registration.
	 * @return True if the user data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the user data is invalid.
	 */

	// validate user second registration
	public static boolean validateUserSecondRegistration(User user) throws InvalidUserException {

		if (user != null && validateDob(user.getDob()) && validateGender(user.getGender())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserSecondPageRegistrationMessage());
		}
	}

	/**
	 * Validates login details.
	 *
	 * @param user The User object for login.
	 * @return True if the user data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the user data is invalid.
	 */
	// Checking the loginUser present or not
	public static boolean validateLogIn(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserLoginMessage());

		}
	}

	/**
	 * Validates update user details.
	 *
	 * @param user  The User object for updating user details.
	 * @param email The User's email for validation.
	 * @return True if the user data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the user data is invalid.
	 */
	// Checking the validate update details
	public static boolean validateUpdateUser(User user, User email) throws InvalidUserException {
		if (user != null && validateFirstName(user.getFirstName()) && validateLastName(user.getLastName())
				&& validateEmail(email.getEmail()) && validateGender(user.getGender())
				&& validateNationality(user.getNationality()) && validateUserName(user.getUsername())
				&& validateDob(user.getDob())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserUpdateMessage());

		}
	}

	/**
	 * Validates updating a user's profile image URL.
	 *
	 * @param user The User object for updating the profile image URL.
	 * @return True if the profile image URL is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the profile image URL is invalid.
	 */
	// validate the user profile url update
	public static boolean validateProfileImageUpdate(User user) throws InvalidUserException {
		if (user != null && validateProfileImageUrl(user.getProfileImage())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserProfileImageUpdateMessage());

		}
	}

	/**
	 * Validates deleting a user's account.
	 *
	 * @param user The User object for account deletion.
	 * @return True if the user data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the user data is invalid.
	 */
	// validate the user details delete details
	public static boolean validateDeleteUser(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserDeleteMessage());

		}
	}

	/**
	 * Validates a user's details by checking if the provided user object is not
	 * null and if the email is valid.
	 *
	 * @param user The user object whose details are to be validated.
	 * @return true if the user details are valid, false otherwise.
	 * @throws InvalidUserException If the user details are invalid, this exception
	 *                              is thrown with an appropriate message.
	 */

	public static boolean validateListUserDetails(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getUserDetailsNotFound());
		}

	}

	/**
	 * Validates the user detail read feature by checking if the provided user
	 * object is not null and if the email is valid.
	 *
	 * @param user The user object for which the detail read feature is to be
	 *             validated.
	 * @return true if the detail read feature is valid, false otherwise.
	 * @throws InvalidUserException If the detail read feature is invalid, this
	 *                              exception is thrown with an appropriate message.
	 */

	public static boolean validateUserDetailReadFeature(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserProfileImageUpdateMessage());

		}
	}

	/**
	 * Validates the format of a user's first name.
	 *
	 * @param name The first name to be validated.
	 * @return True if the first name format is valid.
	 * @throws InvalidUserException If the first name format is invalid.
	 */
	// check the first name and last name details
	public static boolean validateFirstName(String name) throws InvalidUserException {
		boolean match;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserFirstNameMessage());
		}

	}

	/**
	 * Validates the format of a user's last name.
	 *
	 * @param name The last name to be validated.
	 * @return True if the last name format is valid.
	 * @throws InvalidUserException If the last name format is invalid.
	 */
	public static boolean validateLastName(String name) throws InvalidUserException {
		boolean match;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserLastNameMessage());
		}

	}

	/**
	 * Validates the format of a user's password.
	 *
	 * @param password The password to be validated.
	 * @return True if the password format is valid.
	 * @throws InvalidUserException If the password format is invalid.
	 */
	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match;

		if (password == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(patternString, password);

		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserPasswordMessage());
		}

	}

	/**
	 * Validates the format of a user's email.
	 *
	 * @param email The email to be validated.
	 * @return True if the email format is valid.
	 * @throws InvalidUserException If the email format is invalid.
	 */
	public static boolean validateEmail(String email) throws InvalidUserException {
		if (email.isEmpty())
			return false;

		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		boolean isMatch = Pattern.matches(regex, email);

		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserEmailMessage());
		}
	}

	/**
	 * Validates the format of a user's username.
	 *
	 * @param name The username to be validated.
	 * @return True if the username format is valid.
	 * @throws InvalidUserException If the username format is invalid.
	 */

	public static boolean validateUserName(String name) throws InvalidUserException {
		boolean match;

		if (name.isEmpty())
			return false;

		String regex = "^.{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserUserNameMessage());
		}

	}

	/**
	 * Validates a user's date of birth and age.
	 *
	 * @param dob The date of birth to be validated.
	 * @return True if the date of birth and age are valid.
	 * @throws InvalidUserException If the date of birth or age is invalid.
	 */

	public static boolean validateDob(LocalDate dob) throws InvalidUserException {
		if (dob == null)
			return false;

		LocalDate currentDate = LocalDate.now();

		int age = Period.between(dob, currentDate).getYears();

		if (!dob.isAfter(currentDate) && age >= 18) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserDobMessage());
		}

	}

	/**
	 * Validates the format of a user's nationality.
	 *
	 * @param dob The nationality to be validated.
	 * @return True if the nationality format is valid.
	 * @throws InvalidUserException If the nationality format is invalid.
	 */
	public static boolean validateNationality(String dob) throws InvalidUserException {
		boolean match;

		if (dob.isEmpty())
			return false;

		String regex = "^[a-zA-Z]{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(dob);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserNationalityMessage());
		}

	}

	/**
	 * Validates the format of a user's mobile number.
	 *
	 * @param number The mobile number to be validated.
	 * @return True if the mobile number format is valid.
	 * @throws InvalidUserException If the mobile number format is invalid.
	 */
	public static boolean validateMobileNumber(long number) throws InvalidUserException {

		boolean match;
		if (number != 0) {
			String numberStr = Long.toString(number);
			String regex = "^\\d{10}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(numberStr);
			match = m.matches();
			if (match) {
				return true;
			} else {
				throw new InvalidUserException(UserConstants.getInvalidUserMobileNumberMessage());
			}
		} else {
			return false;
		}
	}

	/**
	 * Validates the format of a user's gender.
	 *
	 * @param dob The gender to be validated.
	 * @return True if the gender format is valid.
	 * @throws InvalidUserException If the gender format is invalid.
	 */
	public static boolean validateGender(String dob) throws InvalidUserException {
		boolean match;

		if (dob == null)
			return false;

		String regex = "^[a-zA-Z]{3,15}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(dob);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstants.getInvalidUserGenderMessage());
		}
	}

	/**
	 * Validates the format of a user's profile image URL.
	 *
	 * @param url The profile image URL to be validated.
	 * @return True if the profile image URL format is valid.
	 * @throws InvalidUserException If the profile image URL format is invalid.
	 */

	public static boolean validateProfileImageUrl(String url) throws InvalidUserException {
		if (url == null || url.isEmpty()) {
			return false;
		}

		if (url.startsWith("data:image")) {
			return true;
		}

		try {
			new URL(url);
			return true;
		} catch (MalformedURLException e) {
			throw new InvalidUserException(UserConstants.getInvalidUserProfileImageUrlMessage());
		}
	}

	/**
	 * Validates a user ID by checking if it is a positive integer (greater than or
	 * equal to 1).
	 *
	 * @param userId The user ID to be validated.
	 * @return true if the user ID is valid, false otherwise.
	 * @throws InvalidUserException If the user ID is invalid (not a positive
	 *                              integer), this exception is thrown with an
	 *                              appropriate message.
	 */

	public static boolean validateUserId(int userId) throws InvalidUserException {
		if (userId < 1) {
			return true;
		} else {
			throw new InvalidUserException("Invalid user id");
		}
	}

}
