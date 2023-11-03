package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class NotificationValidator {
	/**
	 * Validates that the "isReadCount" in a request and response object is valid by
	 * checking the sender user's ID.
	 *
	 * @param requestAndResponse The request and response object containing
	 *                           notification details.
	 * @return true if the "isReadCount" is valid, false otherwise.
	 * @throws InvalidUserException If the "isReadCount" is invalid, this exception
	 *                              is thrown with an appropriate message.
	 */
	public static boolean validateNotIsReadCount(RequestAndResponse requestAndResponse) throws InvalidUserException {
		if (!validateNotificationReadUserId(requestAndResponse.getRequestSenderId())) {
			throw new InvalidUserException("Invalid user notification checking");
		}
		return true;
	}

	/**
	 * Validates a user's ID for notification purposes by checking if it is a
	 * positive integer.
	 *
	 * @param userId The user ID to be validated for notification purposes.
	 * @return true if the user ID is valid, false otherwise.
	 * @throws InvalidUserException If the user ID is invalid (not a positive
	 *                              integer), this exception is thrown with an
	 *                              appropriate message.
	 */
	public static boolean validateNotificationReadUserId(int userId) throws InvalidUserException {
		if (userId > 0) {
			return true;
		} else {
			throw new InvalidUserException("Invalid user notification checking");
		}
	}

	/**
	 * Validates a notification ID by checking if it is a positive integer.
	 *
	 * @param notificationId The notification ID to be validated.
	 * @return true if the notification ID is valid, false otherwise.
	 * @throws InvalidUserException If the notification ID is invalid (not a
	 *                              positive integer), this exception is thrown with
	 *                              an appropriate message.
	 */

	public static boolean validateNotificationId(int notificationId) throws InvalidUserException {
		if (notificationId > 0) {
			return true;
		} else {
			throw new InvalidUserException("Invalid notificaiton id");

		}

	}

}
