package com.fssa.freshnest.validation;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class StillValidator {

    private static final String INVALID_STILL_MESSAGE = "still details are not valid";

    public static boolean validateTakeStill(Still still) throws InvalidUserException {

        if (still != null && validateStillUrl(still.getStillUrl()) && validateStillName(still.getStillName())
                && validateStillDate(still.getStillDate()) && validateStillTime(still.getStillTime())) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    // validate favourite image

    public static boolean validateFavouriteStill(Still still) throws InvalidUserException {

        if (still != null && validateStillId(still.getStillId())) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    // validate Update Image

    public static boolean validateUpdateStill(Still still) throws InvalidUserException {

        if (still != null && validateStillName(still.getStillName())) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    // validate Delete image

    public static boolean validateDeleteStill(Still still) throws InvalidUserException {

        if (still != null && validateStillId(still.getStillId())) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    public static boolean validateReadStill(Still still) throws InvalidUserException {
        if (still != null && validateStillUserId(still.getUserId())) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    // validator for the still

    public static boolean validateStillUrl(String url) throws InvalidUserException {

        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    public static boolean validateStillName(String name) throws InvalidUserException {

        if (!name.isEmpty()) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    public static boolean validateStillId(int stillId) throws InvalidUserException {

        if (stillId > 0) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }

    public static boolean validateStillDate(LocalDate date) throws InvalidUserException {
        try {
            LocalDate.parse(date.toString());
            return true;
        } catch (Exception e) {
            throw new InvalidUserException("Still date is not valid");
        }
    }

    public static boolean validateStillTime(LocalTime time) throws InvalidUserException {
        try {
            LocalTime.parse(time.toString());
            return true;
        } catch (Exception e) {
            throw new InvalidUserException("Still time is not valid");
        }
    }

    // Validate still user id
    public static boolean validateStillUserId(int stillId) throws InvalidUserException {

        if (stillId > 0) {
            return true;
        } else {
            throw new InvalidUserException(INVALID_STILL_MESSAGE);
        }

    }
}
