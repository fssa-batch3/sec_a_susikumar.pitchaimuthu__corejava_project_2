package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.FollowConnectionConstants;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class FollowConnectionValidator {
    public static boolean validateUserFollowRequest(RequestAndResponse followConnection) throws InvalidUserException {

        if (validateUserId(followConnection.getRequestSenderId())
                && validateUserId(followConnection.getRequestReceiverId())
                && validateFollowRequestType(followConnection.getRequestType())) {
            return true;
        } else {
            throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowRequest());
        }

    }

    public static boolean validateUserFollowAccept(RequestAndResponse followConnection) throws InvalidUserException {
        if (validateUserId(followConnection.getRequestSenderId())
                && validateUserId(followConnection.getRequestReceiverId())
                && validateFollowAcceptType(followConnection.getRequestType())) {
            return true;
        } else {
            throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowBackRequest());
        }

    }

    public static boolean validateUserFollowCheck(RequestAndResponse followConnection) throws InvalidUserException {

        if (validateUserId(followConnection.getRequestSenderId())
                && validateUserId(followConnection.getRequestReceiverId())) {
            return true;
        } else {
            throw new InvalidUserException(FollowConnectionConstants.getInvalidFollowBackRequest());
        }
    }

    public static boolean validateUserId(int userId) throws InvalidUserException {
        if (userId <= 0) {
            throw new InvalidUserException(FollowConnectionConstants.getInvalidUserId());
        }
        return true;
    }

    public static boolean validateFollowRequestType(String followRequestType) throws InvalidUserException {
        if (followRequestType == null) {
            return false;
        }

        if (followRequestType.trim().isEmpty()) {
            throw new InvalidUserException("Invalid follow request type");
        }

        if (!followRequestType.equals("follow_request")) {
            throw new InvalidUserException("Invalid follow request type");
        }
        return true;
    }

    public static boolean validateFollowAcceptType(String followAcceptType) throws InvalidUserException {
        if (followAcceptType == null) {
            return false;
        }

        if (followAcceptType.trim().isEmpty()) {
            throw new InvalidUserException("Invalid follow request type");
        }

        if (!followAcceptType.equals("follow_accept")) {
            throw new InvalidUserException("Invalid follow request type");
        }
        return true;
    }

}
