package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class StillValidator {

	private static final String INVALID_STILL_MESSAGE = "still details are not valid";

	public static boolean validateTakeStill(Still still) throws InvalidUserException {

		if (still != null && validateStillUrl(still.getStillUrl()) && validateStillName(still.getStillName())
				&& validateStillDate(still.getStillDate()) && validateStillTime(still.getStillTime())) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	} 

	// validate favourite image

	public static boolean validateFavouriteStill(Still still) throws InvalidUserException {

		if (still != null && validateStillId(still.getStillId())) {
			System.out.println("Still details valid");
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	}

	// validate Update Image

	public static boolean validateUpdateStill(Still still) throws InvalidUserException {

		if (still != null && validateStillName(still.getStillName())) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	}

	// validate Delete image

	public static boolean validateDeleteStill(Still still) throws InvalidUserException {

		if (still != null && validateStillId(still.getStillId())) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	}

	public static boolean validateReadStill(Still still) throws InvalidUserException {
		if (still != null && validateStillUserId(still.getUserId())) {
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	}

	// validator for the still

	public static boolean validateStillUrl(String url) throws InvalidUserException {

		try {
			URL value = new URL(url);
			System.out.println(value + " Image url is valid");
			return true;
		} catch (MalformedURLException e) {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	}

	public static boolean validateStillName(String name) throws InvalidUserException {

		if (!name.isEmpty()) {
			System.out.println("The still name is  valid");
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	}

	public static boolean validateStillId(int stillId) throws InvalidUserException {

		if (stillId > 0) {
			System.out.println("The still id is valid");
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
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

	// Validate still user id
	public static boolean validateStillUserId(int stillId) throws InvalidUserException {

		if (stillId > 0) {
			System.out.println("The still id is valid");
			return true;
		} else {
			throw new InvalidUserException(INVALID_STILL_MESSAGE);
		}

	}
}
