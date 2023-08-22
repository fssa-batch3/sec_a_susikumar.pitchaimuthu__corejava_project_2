package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InviteValidator {


    // Invite create details validator
    public static boolean validateInviteCreate(Invite invite) throws InvalidUserException {

        if (invite != null && validateInviteType(invite.getInviteType()) && validateInviteDate(invite.getInviteDate()) && validateInviteTime(invite.getInviteTime(), invite.getInviteDate())) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstants.getInvalidInviteCreateMessage());
        }

    }

    // Invite update details
    public static boolean validateInviteUpdate(Invite invite) throws InvalidUserException {
        if (invite != null && validateInviteType(invite.getInviteType())) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstants.getInvalidInviteUpdateMessage());
        }

    }

    // validate delete invite details
    public static boolean validateDeleteInvite(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstants.getInvalidInviteDeleteMessage());
        }
    }

    // validate invite reaction
    public static boolean validateInviteReact(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstants.getInvalidInviteReactMessage());
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
            throw new InvalidUserException(InviteConstants.getInvalidInviteTypeMessage());
        }

    }


    // validate the invite date
    public static boolean validateInviteDate(String stringDate) throws InvalidUserException {

        if (stringDate == null) {
            return false;
        }
        try {
            LocalDate date = LocalDate.parse(stringDate);
            LocalDate currentDate = LocalDate.now();
            return date.isAfter(currentDate) || date.isEqual(currentDate);
        } catch (Exception e) {
            throw new InvalidUserException(InviteConstants.getInvalidInviteDateMessage());

        }
    }

    // validate the invite time
    public static boolean validateInviteTime(String stringTime, String stringDate) throws InvalidUserException {

        if (stringDate.isEmpty() || stringTime.isEmpty())
            return false;

        try {

            LocalDate date = LocalDate.parse(stringDate);
            LocalTime time = LocalTime.parse(stringTime);

            LocalDateTime dateTime = LocalDateTime.of(date, time);
            LocalDateTime currentDateTime = LocalDateTime.now();
            return dateTime.isAfter(currentDateTime) || dateTime.isEqual(currentDateTime);
        } catch (Exception e) {
            throw new InvalidUserException(InviteConstants.getInvalidInviteTimeMessage());
        }
    }


    // validate the invite Explanation
    public static boolean validateInviteExplanation(String explanation) throws InvalidUserException {
        if (explanation.isEmpty()) {
            throw new InvalidUserException(InviteConstants.getInvalidInviteExplanationMessage());
        } else {
            return true;
        }
    }

    // validate the invite message
    public static boolean validateInviteMessage(String message) throws InvalidUserException {
        if (message.isEmpty()) {
            throw new InvalidUserException(InviteConstants.getInvalidInviteChatMessage());
        } else {
            return true;
        }
    }


}
