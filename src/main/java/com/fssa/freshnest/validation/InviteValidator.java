package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InviteValidator {

    private static final String INVALID_INVITE_MESSAGE = "invite details are not valid";

    // Invite create details validator
    public static boolean validateInviteCreate(Invite invite) throws InvalidUserException {

        if (invite != null && validateInviteType(invite.getInviteType())) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_INVITE_MESSAGE);
        }

    }

    // Invite update details
    public static boolean validateInviteUpdate(Invite invite) throws InvalidUserException {
        if (invite != null && validateInviteType(invite.getInviteType())) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_INVITE_MESSAGE);
        }

    }

    // validate delete invite details
    public static boolean validateDeleteInvite(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_INVITE_MESSAGE);
        }
    }

    // validate invite reaction
    public static boolean validateInviteReact(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_INVITE_MESSAGE);
        }
    }

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
            throw new InvalidUserException("The username is not valid");
        }


    }

    // validate the invite date
    public static boolean validateInviteDate(String date) throws InvalidUserException {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            throw new InvalidUserException("Still date is not valid");

        }
    }

    // validate the invite time
    public static boolean validateInviteTime(String time) throws InvalidUserException {
        try {
            LocalTime.parse(time);
            return true;
        } catch (Exception e) {
            throw new InvalidUserException("Still time is not valid");
        }
    }


    // validate the invite Explanation
    public static boolean validateInviteExplanation(String explanation) throws InvalidUserException {
        if (explanation != null) {
            return true;
        } else {
            throw new InvalidUserException("Invite explanation detail is not valid");
        }
    }

    // validate the invite message
    public static boolean validateInviteMessage(String message) throws InvalidUserException {
        if (message != null) {
            return true;
        } else {
            throw new InvalidUserException("Invite message detail is not valid");
        }
    }


}
