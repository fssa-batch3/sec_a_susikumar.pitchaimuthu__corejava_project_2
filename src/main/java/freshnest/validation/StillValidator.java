package freshnest.validation;

import java.net.MalformedURLException;
import java.net.URL;

import freshnest.model.Still;
import freshnest.validation.exceptions.InvalidUserException;

public class StillValidator {

	public static boolean validateTakeStill(Still still) throws InvalidUserException {

		if (still != null && validateImageUrl(still.getStill_url())) {
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

	public static boolean validateImageUrl(String url) {

		try {
			URL value = new URL(url);
			System.out.println(value + " Image url is valid");
			return true;
		} catch (MalformedURLException e) {
			return false;
		}

	}

}
