package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InviteValidator {

    private static final String invalidInvalidMessage = "invite details are not valid";

    // Invite create details validator
    public static boolean validateInviteCreate(Invite invite) throws InvalidUserException {

        if (invite != null && validateInviteType(invite.getInviteType())) {
            return true;
        } else {
            throw new InvalidUserException(invalidInvalidMessage);
        }

    }

    // Invite update details
    public static boolean validateInviteUpdate(Invite invite) throws InvalidUserException {
        if (invite != null && validateInviteType(invite.getInviteType())) {
            return true;
        } else {
            throw new InvalidUserException(invalidInvalidMessage);
        }

    }

    // validate delete invite details
    public static boolean validateDeleteInvite(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(invalidInvalidMessage);
        }
    }

    // validate invite reaction
    public static boolean validateInviteReact(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(invalidInvalidMessage);
        }
    }

    // Invite type validator
    public static boolean validateInviteType(String inviteType) {

        if (inviteType == null)
            return false;

        String regex = "^[a-zA-Z\\s]{3,49}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inviteType);
        boolean match = m.matches();
        if (match) {
            System.out.println("The username is valid.");
        } else {
            System.out.println("The username is not valid");
        }

        return match;
    }

    // validate the invite date
    public static boolean validateInviteDate(String date) {
        try {
            LocalDate.parse(date);
            System.out.println("Still date is valid");
            return true;
        } catch (Exception e) {
            System.out.println("Still date is not valid");

            return false;
        }
    }

    // validate the invite time
    public static boolean validateInviteTime(String time) {
        try {
            LocalTime.parse(time);
            System.out.println("Still time is valid");
            return true;
        } catch (Exception e) {
            System.out.println("Still time is not valid");

            return false;
        }
    }


    // validate the invite Explanation
    public static boolean validateInviteExplanation(String explanation) throws InvalidUserException {
        if (explanation != null) {
            System.out.println("Invite explanation detail is valid.");
            return true;
        } else {
            throw new InvalidUserException("Invite explanation detail is not valid");
        }
    }

    // validate the invite message
    public static boolean validateInviteMessage(String message) throws InvalidUserException {
        if (message != null) {
            System.out.println("Invite message detail is valid.");
            return true;
        } else {
            throw new InvalidUserException("Invite message detail is not valid");
        }
    }


}
