package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.FollowConnectionConstants;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class FollowConnectionValidator {
	/**
	 * Validates a user follow request by checking if the sender and receiver user
	 * IDs are valid and if the follow request type is valid.
	 *
	 * @param followConnection The request and response object containing user
	 *                         follow request details.
	 * @return true if the request is valid, false otherwise.
	 * @throws InvalidUserException If the request is invalid, this exception is
	 *                              thrown with an appropriate message.
	 */
	public static boolean validateUserFollowRequest(RequestAndResponse followConnection) throws InvalidUserException {

		if (validateUserId(followConnection.getRequestSenderId())
				&& validateUserId(followConnection.getRequestReceiverId())
				&& validateFollowRequestType(followConnection.getRequestType())) {
			return true;
		} else {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowRequest());
		}

	}

	/**
	 * Validates a user follow accept by checking if the sender and receiver user
	 * IDs are valid and if the follow accept type is valid.
	 *
	 * @param followConnection The request and response object containing user
	 *                         follow accept details.
	 * @return true if the accept is valid, false otherwise.
	 * @throws InvalidUserException If the accept is invalid, this exception is
	 *                              thrown with an appropriate message.
	 */

	public static boolean validateUserFollowAccept(RequestAndResponse followConnection) throws InvalidUserException {
		if (validateUserId(followConnection.getRequestSenderId())
				&& validateUserId(followConnection.getRequestReceiverId())
				&& validateFollowAcceptType(followConnection.getRequestType())) {
			return true;
		} else {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowBackRequest());
		}

	}

	/**
	 * Validates a user follow check by checking if the sender and receiver user IDs
	 * are valid.
	 *
	 * @param followConnection The request and response object containing user
	 *                         follow check details.
	 * @return true if the check is valid, false otherwise.
	 * @throws InvalidUserException If the check is invalid, this exception is
	 *                              thrown with an appropriate message.
	 */

	public static boolean validateUserFollowCheck(RequestAndResponse followConnection) throws InvalidUserException {

		if (validateUserId(followConnection.getRequestSenderId())
				&& validateUserId(followConnection.getRequestReceiverId())) {
			return true;
		} else {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowBackRequest());
		}
	}

	/**
	 * Validates a user ID by checking if it is a positive integer.
	 *
	 * @param userId The user ID to be validated.
	 * @return true if the user ID is valid, false otherwise.
	 * @throws InvalidUserException If the user ID is invalid (not a positive
	 *                              integer), this exception is thrown with an
	 *                              appropriate message.
	 */

	public static boolean validateUserId(int userId) throws InvalidUserException {
		if (userId <= 0) {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidUserId());
		}
		return true;
	}

	/**
	 * Validates a follow request type by checking if it is not null, not empty
	 * after trimming, and equal to "follow_request".
	 *
	 * @param followRequestType The follow request type to be validated.
	 * @return true if the follow request type is valid, false otherwise.
	 * @throws InvalidUserException If the follow request type is invalid, this
	 *                              exception is thrown with an appropriate message.
	 */

	public static boolean validateFollowRequestType(String followRequestType) throws InvalidUserException {
		if (followRequestType == null) {
			return false;
		}

		if (followRequestType.trim().equals("") || !followRequestType.equals("follow_request")) {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowRequest());
		}

		return true;
	}

	/**
	 * Validates a follow accept type by checking if it is not null, not empty after
	 * trimming, and equal to "follow_accept".
	 *
	 * @param followAcceptType The follow accept type to be validated.
	 * @return true if the follow accept type is valid, false otherwise.
	 * @throws InvalidUserException If the follow accept type is invalid, this
	 *                              exception is thrown with an appropriate message.
	 */
	public static boolean validateFollowAcceptType(String followAcceptType) throws InvalidUserException {
		if (followAcceptType == null) {
			return false;
		}

		if (followAcceptType.trim().isEmpty() || !followAcceptType.equals("follow_accept")) {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowRequestType());
		}

		return true;
	}

	public static boolean validatedFollowrequestId(int userId) throws InvalidUserException {
		if (userId <= 0) {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowRequestId());
		}
		return true;
	}

	public static boolean validateFollowReciverId(int userId) throws InvalidUserException {
		if (userId <= 0) {
			throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowReceiverId());
		}
		return true;
	}

}
