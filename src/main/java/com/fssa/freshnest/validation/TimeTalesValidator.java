package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.TimeTales;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.net.MalformedURLException;
import java.net.URL;

public class TimeTalesValidator {

	/**
	 * Validates the creation of a TimeTales object by checking if the provided
	 * TimeTales is not null and if the media URL is valid.
	 *
	 * @param timeTales The TimeTales object to be validated.
	 * @return true if the TimeTales creation is valid, false otherwise.
	 * @throws InvalidUserException If the TimeTales creation is invalid, this
	 *                              exception is thrown with an appropriate message.
	 */
	public static boolean validateCreateTimeTales(TimeTales timeTales) throws InvalidUserException {
		if (timeTales != null && validateMediaUrl(timeTales.getMedia_url())) {
			return true;
		} else {
			throw new InvalidUserException("Invalid time tales creation details");
		}
	}

	/**
	 * Validates a media URL by checking if it is not null or empty, and if it is a
	 * valid URL or data URL (starts with "data:image" or "data:video").
	 *
	 * @param url The media URL to be validated.
	 * @return true if the media URL is valid, false otherwise.
	 * @throws InvalidUserException If the media URL is invalid, this exception is
	 *                              thrown with an appropriate message.
	 */
	public static boolean validateMediaUrl(String url) throws InvalidUserException {
		if (url == null || url.isEmpty()) {
			return false;
		}
		if (url.startsWith("data:image") || url.startsWith("data:video")) {
			return true;
		}
		try {
			new URL(url);
			return true;
		} catch (MalformedURLException e) {
			throw new InvalidUserException("Invalid media url");
		}
	}

}
