package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.InviteConstraints;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InviteValidator {


    // Invite create details validator
    public static boolean validateInviteCreate(Invite invite) throws InvalidUserException {

        if (invite != null && validateInviteType(invite.getInviteType())) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteCreateMessage());
        }

    }

    // Invite update details
    public static boolean validateInviteUpdate(Invite invite) throws InvalidUserException {
        if (invite != null && validateInviteType(invite.getInviteType())) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteUpdateMessage());
        }

    }

    // validate delete invite details
    public static boolean validateDeleteInvite(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteDeleteMessage());
        }
    }

    // validate invite reaction
    public static boolean validateInviteReact(Invite invite) throws InvalidUserException {
        if (invite != null) {
            return true;
        } else {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteReactMessage());
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
            throw new InvalidUserException(InviteConstraints.getInvalidInviteTypeMessage());
        }


    }

    // validate the invite date
    public static boolean validateInviteDate(String date) throws InvalidUserException {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteDateMessage());

        }
    }

    // validate the invite time
    public static boolean validateInviteTime(String time) throws InvalidUserException {
        try {
            LocalTime.parse(time);
            return true;
        } catch (Exception e) {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteTimeMessage());
        }
    }


    // validate the invite Explanation
    public static boolean validateInviteExplanation(String explanation) throws InvalidUserException {
        if (explanation.isEmpty()) {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteExplanationMessage());
        } else {
            return true;
        }
    }

    // validate the invite message
    public static boolean validateInviteMessage(String message) throws InvalidUserException {
        if (message.isEmpty()) {
            throw new InvalidUserException(InviteConstraints.getInvalidInviteChatMessage());
        } else {
            return true;
        }
    }


}
