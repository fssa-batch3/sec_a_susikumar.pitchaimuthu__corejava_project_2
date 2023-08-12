package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.StillConstraints;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class StillValidator {


    public static boolean validateTakeStill(Still still) throws InvalidUserException {

        if (still != null && validateStillUrl(still.getStillUrl()) && validateStillName(still.getStillName())
                && validateStillDate(still.getStillDate()) && validateStillTime(still.getStillTime())) {
            return true;
        } else {
            throw new InvalidUserException(StillConstraints.getInvalidStillTakeMessage());
        }

    }

    // validate favourite image

    public static boolean validateFavouriteStill(Still still) throws InvalidUserException {

        if (still != null && validateStillId(still.getStillId())) {
            return true;
        } else {
            throw new InvalidUserException(StillConstraints.getInvalidStillFavouriteMessage());
        }

    }

    // validate Update Image

    public static boolean validateUpdateStill(Still still) throws InvalidUserException {

        if (still != null && validateStillName(still.getStillName())) {
            return true;
        } else {
            throw new InvalidUserException(StillConstraints.getInvalidStillUpdateMessage());
        }

    }

    // validate Delete image

    public static boolean validateDeleteStill(Still still) throws InvalidUserException {

        if (still != null && validateStillId(still.getStillId()) && validateStillUserId(still.getUserId())) {
            return true;
        } else {
            throw new InvalidUserException(StillConstraints.getInvalidStillDeleteMessage());
        }

    }

    public static boolean validateReadStill(Still still) throws InvalidUserException {
        if (still != null && validateStillUserId(still.getUserId())) {
            return true;
        } else {
            throw new InvalidUserException(StillConstraints.getInvalidStillReadMessage());
        }

    }

    // validator for the still

    public static boolean validateStillUrl(String url) throws InvalidUserException {
        if (url == null || url.isEmpty()) {
            return false;
        }
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            throw new InvalidUserException(StillConstraints.getInvalidStillUrlMessage());
        }
        return true;

    }

    public static boolean validateStillName(String name) throws InvalidUserException {

        if (!name.isEmpty()) {
            return true;
        } else {
            throw new InvalidUserException(StillConstraints.getInvalidStillNameMessage());
        }

    }

    public static boolean validateStillId(int stillId) throws InvalidUserException {

        if (stillId <= 0) {
            throw new InvalidUserException(StillConstraints.getInvalidStillIdMessage());
        }
        return true;
    }

    public static boolean validateStillDate(LocalDate date) throws InvalidUserException {
        try {
            LocalDate.parse(date.toString());
            return true;
        } catch (Exception e) {
            throw new InvalidUserException(StillConstraints.getInvalidStillDateMessage());
        }
    }

    public static boolean validateStillTime(LocalTime time) throws InvalidUserException {
        try {
            LocalTime.parse(time.toString());
            return true;
        } catch (Exception e) {
            throw new InvalidUserException(StillConstraints.getInvalidStillTimeMessage());
        }
    }

    // Validate still user id
    public static boolean validateStillUserId(int userId) throws InvalidUserException {
        if (userId <= 0) {
            throw new InvalidUserException(StillConstraints.getInvalidStillUseridMessage());
        }
        return true;

    }
}
