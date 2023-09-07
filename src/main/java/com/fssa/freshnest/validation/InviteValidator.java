package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides methods to validate invite-related data and operations.
 *
 * @author SusikumarPitchaimuth
 */

public class InviteValidator {

	/**
	 * Validates the data for creating an invite.
	 *
	 * @param invite The Invite object for creating the invite.
	 * @return True if the invite data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite data is invalid.
	 */
	// Invite create details validator
	public static boolean validateInviteCreate(Invite invite) throws InvalidUserException {

		if (invite != null && validateInviteType(invite.getInviteType()) && validateInviteDate(invite.getInviteDate())
				&& validateInviteTime(invite.getInviteTime(), invite.getInviteDate())) {
			return true;
		} else {
			throw new InvalidUserException(InviteConstants.getInvalidInviteCreateMessage());
		}

	}

	/**
	 * @param invite The invite object containing the user id to read their
	 *               invitation.
	 * @return True if the invite data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite data is invalid.
	 */

	public static boolean validateInviteRead(Invite invite) throws InvalidUserException {
		if (invite != null) {
			return true;
		} else {
			throw new InvalidUserException(InviteConstants.getInvalidInviteReadMessage());
		}
	}

	/**
	 * Validates the data for updating an invite.
	 *
	 * @param invite The Invite object for updating the invite.
	 * @return True if the invite data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite data is invalid.
	 */
	// Invite update details
	public static boolean validateInviteUpdate(Invite invite) throws InvalidUserException {
		if (invite != null && validateInviteType(invite.getInviteType())) {
			return true;
		} else {
			throw new InvalidUserException(InviteConstants.getInvalidInviteUpdateMessage());
		}

	}

	/**
	 * Validates the data for deleting an invite.
	 *
	 * @param invite The Invite object for deleting the invite.
	 * @return True if the invite data is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite data is invalid.
	 */

	// validate delete invite details
	public static boolean validateDeleteInvite(Invite invite) throws InvalidUserException {
		if (invite != null) {
			return true;
		} else {
			throw new InvalidUserException(InviteConstants.getInvalidInviteDeleteMessage());
		}
	}

	/**
	 * Validates the invite type.
	 *
	 * @param inviteType The invite type to be validated.
	 * @return True if the invite type is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite type is invalid.
	 */
	// Invite type validator
	public static boolean validateInviteType(String inviteType) throws InvalidUserException {

		if (inviteType == null)
			return false;

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inviteType);
		boolean match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException(InviteConstants.getInvalidInviteTypeMessage());
		}

	}

	/**
	 * Validates the invite date.
	 *
	 * @param date The invite date to be validated.
	 * @return True if the invite date is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite date is invalid.
	 */

	// validate the invite date
	public static boolean validateInviteDate(LocalDate date) throws InvalidUserException {

		if (date == null) {
			throw new InvalidUserException(InviteConstants.getInvalidInviteDateMessage());
		}
		try {
			LocalDate currentDate = LocalDate.now();
			if (date.isBefore(currentDate)) {
				throw new InvalidUserException(InviteConstants.getInvalidInviteDateMessage());
			} else {
				return true;
			}
		} catch (Exception e) {
			throw new InvalidUserException(InviteConstants.getInvalidInviteDateMessage());

		}
	}

	/**
	 * Validates the invite time.
	 *
	 * @param time The invite time to be validated.
	 * @param date The invite date for which the time is validated.
	 * @return True if the invite time is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite time is invalid.
	 */
	// validate the invite time
	public static boolean validateInviteTime(LocalTime time, LocalDate date) throws InvalidUserException {

		if (date == null)
			throw new InvalidUserException(InviteConstants.getNullInviteDateMessage());

		try {

			LocalDateTime dateTime = LocalDateTime.of(date, time);
			LocalDateTime currentDateTime = LocalDateTime.now();
			if( dateTime.isAfter(currentDateTime) || dateTime.isEqual(currentDateTime)) {
				return true;
			}else {
				throw new InvalidUserException(InviteConstants.getInvalidInviteTimeMessage());

			}
		} catch (Exception e) {
			throw new InvalidUserException(InviteConstants.getInvalidInviteTimeMessage());
		}
	}

	/**
	 * Validates the invite explanation.
	 *
	 * @param explanation The invite explanation to be validated.
	 * @return True if the invite explanation is valid, otherwise throws
	 *         InvalidUserException.
	 * @throws InvalidUserException If the invite explanation is invalid.
	 */
	// validate the invite Explanation
	public static boolean validateInviteExplanation(String explanation) throws InvalidUserException {
		explanation = explanation.trim();
		if (explanation.isEmpty()) {
			throw new InvalidUserException(InviteConstants.getInvalidInviteExplanationMessage());
		} else {
			return true;
		}
	}

}
