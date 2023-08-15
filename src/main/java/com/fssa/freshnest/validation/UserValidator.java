package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.UserConstraints;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

	private static final String INVALID_USER_MESSAGE = "invite details are not valid";

	public static boolean validateUser(User user) throws InvalidUserException {

		if (user != null && validateFirstName(user.getFirstName()) && validateLastName(user.getLastName())
				&& validatePassword(user.getPassword()) && validateEmail(user.getEmail())
				&& validateUserName(user.getUsername()) && validateProfileImageUrl(user.getProfileImage())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserRegistrationMessage());
		}

	}

	// validate user second registration

	public static boolean validateUserSecondRegistration(User user) throws InvalidUserException {

		if (user != null && validateDob(user.getDob()) && validateGender(user.getGender())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserSecondPageRegistrationMessage());
		}
	}

	// Checking the loginUser present or not

	public static boolean validateLogIn(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserLoginMessage());

		}
	}

	// Checking the validate update details

	public static boolean validateUpdateUser(User user) throws InvalidUserException {
		if (user != null && validateFirstName(user.getFirstName()) && validateLastName(user.getLastName()) && validateEmail(user.getEmail())
				&& validateGender(user.getGender()) && validateNationality(user.getNationality()) && validateUserName(user.getUsername())
				&& validateMobileNumber(user.getMobileNumber()) && validateDob(user.getDob())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserUpdateMessage());

		}
	}

	// validate the user profile url update
	public static boolean validateProfileImageUpdate(User user) throws InvalidUserException {
		if (user != null && validateProfileImageUrl(user.getProfileImage())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserProfileImageUpdateMessage());

		}
	}

	// validate the user details delete details

	public static boolean validateDeleteUser(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail())) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserDeleteMessage());

		}
	}

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
			throw new InvalidUserException(UserConstraints.getInvalidUserFirstNameMessage());
		}

	}

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
			throw new InvalidUserException(UserConstraints.getInvalidUserLastNameMessage());
		}

	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match;

		if (password == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(patternString, password);

		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserPasswordMessage());
		}

	}

	public static boolean validateEmail(String email) throws InvalidUserException {
	    if (email == null)
	        return false;

	    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    boolean isMatch = Pattern.matches(regex, email);

	    if (isMatch) {
	        return true;
	    } else {
	        throw new InvalidUserException(UserConstraints.getInvalidUserEmailMessage());
	    }
	}


	public static boolean validateUserName(String name) throws InvalidUserException {
		boolean match;

		if (name == null)
			throw new InvalidUserException(UserConstraints.getInvalidUserUserNameMessage());

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserUserNameMessage());
		}

	}

	public static boolean validateDob(String dob) throws InvalidUserException {
		if (dob == null)
			throw new InvalidUserException(UserConstraints.getInvalidUserDobMessage());

		LocalDate parsedDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();

		int age = Period.between(parsedDate, currentDate).getYears();

		if (!parsedDate.isAfter(currentDate) && age >= 18) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserDobMessage());
		}

	}

	public static boolean validateNationality(String dob) throws InvalidUserException {
		boolean match;

		if (dob.isEmpty() || dob == null)
			throw new InvalidUserException(UserConstraints.getInvalidUserNationalityMessage());

		String regex = "^[a-zA-Z]{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(dob);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserNationalityMessage());
		}

	}

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
				throw new InvalidUserException(UserConstraints.getInvalidUserMobileNumberMessage());
			}
		} else {
			throw new InvalidUserException("Invalid mobile number: 0");
		}
	}

	public static boolean validateGender(String dob) throws InvalidUserException {
		boolean match;

		if (dob == null)
			throw new InvalidUserException(UserConstraints.getInvalidUserGenderMessage());

		String regex = "^[a-zA-Z]{3,15}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(dob);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(UserConstraints.getInvalidUserGenderMessage());
		}
	}

	public static boolean validateProfileImageUrl(String url) throws InvalidUserException {
		if (url == null || url.isEmpty()) {
			throw new InvalidUserException(UserConstraints.getInvalidNullUserProfileImageUrlMessage());
		}
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			throw new InvalidUserException(UserConstraints.getInvalidUserProfileImageUrlMessage());
		}
		return true;
	}

}
