package freshnest.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import freshnest.model.User;
import freshnest.validation.exceptions.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {

		if (user != null && validateFirstName(user.getFirstName()) && validateLastName(user.getLastName())
				&& validatePassword(user.getPassword()) && validateEmail(user.getEmail())
				&& validateUserName(user.getUsername())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// Checking the loginUser present or not

	public static boolean validateLogIn(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");

		}
	}

	// Checking the validate update details

	public static boolean validateUpdateUser(User user) throws InvalidUserException {
		if (user != null && validateFirstName(user.getUsername()) && validatePassword(user.getPassword())
				&& validateEmail(user.getEmail()) && validateGender(user.getGender())
				&& validateNationality(user.getNationality()) && validateDob(user.getDob())
				&& validateMobileNumber(user.getMobile_number())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");

		}
	}

	public static boolean validateDeleteUser(User user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail()) ) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");

		}
	}

	// check the first name and last name details
	public static boolean validateFirstName(String name) {
		boolean match = false;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{1,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The user firstname is valid.");
		} else {
			System.out.println("The user firstname is not valid");
		}

		return match;
	}

	public static boolean validateLastName(String name) {
		boolean match = false;

		if (name == null)
			return false;

		String regex = "^[A-Za-z]\\w{1,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The user lastname is valid.");
		} else {
			System.out.println("The user lastname is not valid");
		}

		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;

		if (password == null)
			return false;

		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;

		if (email == null)
			return false;
		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;

	}

	public static boolean validateUserName(String name) {
		boolean match = false;

		if (name == null)
			return false;

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The username is valid.");
		} else {
			System.out.println("The username is not valid");
		}

		return match;
	}

	public static boolean validateDob(Date date) {
		if (date == null)
			return false;

		LocalDate dob = date.toLocalDate();

		// Perform your date of birth validation here
		LocalDate currentDate = LocalDate.now();
		LocalDate minDob = currentDate.minusYears(120);
		LocalDate maxDob = currentDate.minusYears(5);

		boolean isValidDob = (dob.isAfter(minDob) && dob.isBefore(maxDob));

		if (isValidDob) {
			System.out.println("The user date of birth is valid.");
		} else {
			System.out.println("The user date of birth is not valid");
		}

		return isValidDob;
	}

	public static boolean validateNationality(String dob) {
		boolean match = false;

		if (dob == null)
			return false;

		String regex = "^[a-zA-Z]{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(dob);
		match = m.matches();
		if (match) {
			System.out.println("The user nationality is valid.");
		} else {
			System.out.println("The user nationality is not valid");
		}

		return match;
	}

	public static boolean validateMobileNumber(long number) {
		boolean match = false;

		if (number != 0) {
			String numberStr = Long.toString(number);
			String regex = "^(1[89]|[2-9][0-9]|[1-9][0-9]{2,})$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(numberStr);
			match = m.matches();

			if (match) {
				System.out.println("The user mobile number is valid.");
			} else {
				System.out.println("The user mobile number is not valid");
			}
		} else {
			System.out.println("Invalid mobile number: 0");
		}

		return match;
	}

	public static boolean validateGender(String dob) {
		boolean match = false;

		if (dob == null)
			return false;

		String regex = "^[a-zA-Z]{3,15}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(dob);
		match = m.matches();
		if (match) {
			System.out.println("The user gender is valid.");
		} else {
			System.out.println("The user gender is not valid");
		}

		return match;
	}

}
