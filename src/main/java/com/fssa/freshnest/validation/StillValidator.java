package com.fssa.freshnest.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

/**
 * This class provides methods to validate still-related data and operations.
 *
 * @author SusikumarPitchaimuth
 */
public class StillValidator {

	/**
	 * Validates the data for taking a still image.
	 *
	 * @param still The Still object for taking the image.
	 * @return True if the still data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the still data is invalid.
	 */
	public static boolean validateTakeStill(Still still) throws InvalidUserException {

		if (still != null && validateStillUrl(still.getStillUrl()) && validateStillName(still.getStillName())
				&& validateStillDate(still.getStillDate()) && validateStillTime(still.getStillTime())) {
			return true;
		} else {
			throw new InvalidUserException(StillConstants.getInvalidStillTakeMessage());
		}

	}

	/**
	 * Validates the data for marking an image as a favorite.
	 *
	 * @param still The Still object for marking as a favorite.
	 * @return True if the still data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the still data is invalid.
	 */
	// validate favourite image
	public static boolean validateFavouriteStill(Still still) throws InvalidUserException {

		if (still != null) {
			return true;
		} else {
			throw new InvalidUserException(StillConstants.getInvalidStillFavouriteMessage());
		}

	}

	/**
	 * Validates the data for updating an image.
	 *
	 * @param still The Still object for updating the image.
	 * @return True if the still data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the still data is invalid.
	 */
	// validate Update Image
	public static boolean validateUpdateStill(Still still) throws InvalidUserException {
		if (still == null)
			return false;

		if (validateStillUrl(still.getStillUrl()) && validateStillName(still.getStillName())
				&& validateStillDate(still.getStillDate()) && validateStillTime(still.getStillTime())) {
			return true;
		} else {
			throw new InvalidUserException(StillConstants.getInvalidStillUpdateMessage());
		}

	}

	/**
	 * Validates the data for deleting an image.
	 *
	 * @param still The Still object for deleting the image.
	 * @return True if the still data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the still data is invalid.
	 */

	// validate Delete image
	
	public static boolean validateDeleteStill(Still still) throws InvalidUserException {
	    if (still == null) {
	        return false;
	    }
	    
	    if (!validateStillDate(still.getStillDate())) {
	        throw new InvalidUserException(StillConstants.getInvalidStillDeleteMessage());
	    } 
	    return true; 
	}


	/**
	 * Validates the data for reading an image.
	 *
	 * @param still The Still object for reading the image.
	 * @return True if the still data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the still data is invalid.
	 */
	public static boolean validateReadStill(Still still) throws InvalidUserException {
		if (still != null) {
			return true;
		} else {
			throw new InvalidUserException(StillConstants.getInvalidStillReadMessage());
		}

	}

	/**
	 * Validates the URL of a still image.
	 *
	 * @param url The URL to be validated.
	 * @return True if the URL is valid, otherwise throws InvalidUserException.
	 * @throws InvalidUserException If the URL is invalid.
	 */
	// validator for the still
	public static boolean validateStillUrl(String url) throws InvalidUserException {
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
			throw new InvalidUserException(StillConstants.getInvalidStillUrlMessage());
		}

	}

	/**
	 * Validates the name of a still image.
	 *
	 * @param name The name to be validated.
	 * @return True if the name is valid, otherwise throws InvalidUserException.
	 * @throws InvalidUserException If the name is invalid.
	 */
	// Validate the still name
	public static boolean validateStillName(String name) throws InvalidUserException {

		if (name == null) {
			throw new InvalidUserException(StillConstants.getInvalidStillNameMessage());
		} else if (name.trim().isEmpty()) {
			throw new InvalidUserException(StillConstants.getInvalidStillNameMessage());
		} else {
			return true;
		}
	}

	/**
	 * Validates the date of a still image.
	 *
	 * @param date The date to be validated.
	 * @return True if the date is valid, otherwise throws InvalidUserException.
	 * @throws InvalidUserException If the date is invalid.
	 */
	public static boolean validateStillDate(LocalDate date) throws InvalidUserException {

		if (date == null) {
			throw new InvalidUserException(StillConstants.getInvalidStillDateMessage());
		}

		LocalDate today = LocalDate.now();
		LocalDate earliestValidDate = LocalDate.of(1900, 1, 1);
		LocalDate latestValidDate = today.plus(10, ChronoUnit.YEARS);

		if (date.isBefore(earliestValidDate) || date.isAfter(latestValidDate)) {
			throw new InvalidUserException(StillConstants.getInvalidStillDateMessage());
		}

		return true;
	}

	/**
	 * Validates the time of a still image.
	 *
	 * @param time The time to be validated.
	 * @return True if the time is valid, otherwise throws InvalidUserException.
	 * @throws InvalidUserException If the time is invalid.
	 */

	// Validate the still time
	public static boolean validateStillTime(LocalTime time) throws InvalidUserException {
		if (time == null) {
			return false;
		}

		LocalTime minTime = LocalTime.of(0, 0);
		LocalTime maxTime = LocalTime.of(23, 59);

		if (time.isBefore(minTime) || time.isAfter(maxTime)) {
			throw new InvalidUserException(StillConstants.getInvalidStillTimeMessage());
		}
		return true;
	}

}
