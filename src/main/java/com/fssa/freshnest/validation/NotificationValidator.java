package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class NotificationValidator {

    public static boolean validateNotIsReadCount(RequestAndResponse requestAndResponse) throws InvalidUserException {
        if (validateNotificationReadUserId(requestAndResponse.getRequestSenderId())) {
            return true;
        } else {
            throw new InvalidUserException("Invalid user notification checking");
        }
    }

    public static boolean validateNotificationReadUserId(int userId) throws InvalidUserException {
        if (userId > 0) {
            return true;
        } else {
            throw new InvalidUserException("Invalid user notification checking");
        }
    }

    public static boolean validateNotificationId(int notificationId) throws InvalidUserException {
        if (notificationId > 0) {
            return true;
        } else {
            throw new InvalidUserException("Invalid notificaiton id");

        }

    }

}
