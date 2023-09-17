package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.TimeTales;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.net.MalformedURLException;
import java.net.URL;

public class TimeTalesValidator {
	public static boolean validateCreateTimeTales(TimeTales timeTales) throws InvalidUserException {
		if (timeTales != null && validateMediaUrl(timeTales.getMedia_url())) {
			return true;
		} else {
			throw new InvalidUserException("Invalid time tales creation details");
		}
	}

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
