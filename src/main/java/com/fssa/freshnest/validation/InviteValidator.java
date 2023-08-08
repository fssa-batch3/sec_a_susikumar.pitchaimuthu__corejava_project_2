package com.fssa.freshnest.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class InviteValidator {

	// Invite create details validator
	public static boolean validateInviteCreate(Invite invite) throws InvalidUserException {

		if (invite != null && validateInviteType(invite.getInvite_type())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// Invite update details
	public static boolean validateInviteUpdate(Invite invite) throws InvalidUserException {
		if (invite != null && validateInviteType(invite.getInvite_type())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	// validate delete invite details
	public static boolean validateDeleteInvite(Invite invite) throws InvalidUserException {
		if (invite != null) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	// validate invite reaction
	public static boolean validateInviteReact(Invite invite) throws InvalidUserException {
		if (invite != null) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	// Invite type validator
	public static boolean validateInviteType(String inviteType) {
		boolean match = false;

		if (inviteType == null)
			return false;

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inviteType);
		match = m.matches();
		if (match) {
			System.out.println("The username is valid.");
		} else {
			System.out.println("The username is not valid");
		}

		return match;
	}

}
