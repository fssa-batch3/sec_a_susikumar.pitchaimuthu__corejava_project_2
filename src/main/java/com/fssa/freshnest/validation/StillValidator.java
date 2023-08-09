package com.fssa.freshnest.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class StillValidator {
	public static boolean validateTakeStill(Still still) throws InvalidUserException {

		if (still != null && validateStillUrl(still.getStillUrl()) && validateStillName(still.getStillName())
				&& validateStillId(still.getStillId()) && validateStillDate(still.getStillDate())
				&& validateStillTime(still.getStillTime())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// validate favourite image

	public static boolean validateFavouriteStill(Still still) throws InvalidUserException {

		if (still != null) {
			System.out.println("Still details valid");
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// validate Update Image

	public static boolean validateUpdateStill(Still still) throws InvalidUserException {

		if (still != null) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// validate Delete image

	public static boolean validateDeleteStill(Still still) throws InvalidUserException {

		if (still != null) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	public static boolean validateReadStill(Still still) throws InvalidUserException {
		if (still != null) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// validator for the still

	public static boolean validateStillUrl(String url) throws InvalidUserException {

		try {
			URL value = new URL(url);
			System.out.println(value + " Image url is valid");
			return true;
		} catch (MalformedURLException e) {
			throw new InvalidUserException("User details not valid");
		}

	}

	public static boolean validateStillName(String name) throws InvalidUserException {

		if (name == null || name.isEmpty()) {
			System.out.println("The still name is not valid");
			return false;
		} else {
			System.out.println("The still name is valid.");
			return true;
		}

	}

	public static boolean validateStillId(int still_id) throws InvalidUserException {

		if (still_id > 0) {
			System.out.println("The still id is valid");
			return false;
		} else {
			System.out.println("The still id is not valid.");
			return true;
		}

	}

	public static boolean validateStillDate(LocalDate date) {
		try {
			LocalDate.parse(date.toString());
			System.out.println("Still date is valid");
			return true;
		} catch (Exception e) {
			System.out.println("Still date is not valid");

			return false;
		}
	}

	public static boolean validateStillTime(LocalTime time) {
		try {
			LocalTime.parse(time.toString());
			System.out.println("Still time is valid");
			return true;
		} catch (Exception e) {
			System.out.println("Still time is not valid");

			return false;
		}
	}

}
