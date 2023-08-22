package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestStillService {

    // Test still Creation feature

    @Test
    void testStillCreateSuccess() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        Still still = new Still("https://www.example.com", 1, "Supreme", currentDate, currentTime, false, false);
        StillService stillService = new StillService();

        try {
            assertTrue(stillService.takeStill(still));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();

        }
    }

    @Test
    void testStillCreateWithInvalidStillUrl() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        Still still = new Still("www.sampleImage.com", 2, "Supreme", currentDate, currentTime, false, false);
        StillService stillService = new StillService();

        ServiceException result = assertThrows(ServiceException.class, () -> stillService.takeStill(still));

        String expectedMessage = StillConstants.getCommonServiceErrorMessage() + StillConstants.getInvalidStillUrlMessage();
        assertEquals(expectedMessage, result.getMessage());

    }

    @Test
    void testStillCreateWithInvalidStillName() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        Still still = new Still("https://www.example.com", 2, " ", currentDate, currentTime, false, false);
        StillService stillService = new StillService();

        ServiceException result = assertThrows(ServiceException.class, () -> stillService.takeStill(still));
        String expectedMessage = StillConstants.getCommonServiceErrorMessage() + StillConstants.getInvalidStillNameMessage();

        assertEquals(expectedMessage, result.getMessage());
    }


    // Test still read feature

    // test the still read success
    @Test
    void testStillReadSuccess() {

        Still still = new Still(1);
        StillService stillService = new StillService();
        try {
            List<Still> result = stillService.readStill(still);
            for (Still s : result) {
                System.out.println(s);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    // test the still invalid still id read
    @Test
    void testInvalidStillIdRead() {
        Still still = new Still(-1);
        StillService stillService = new StillService();

        InvalidUserException result = assertThrows(InvalidUserException.class, () -> stillService.readStill(still));
        assertEquals(StillConstants.getInvalidStillReadMessage(), result.getMessage());
    }


    // Test still update feature

    // test image update details
    @Test
    void testStillUpdateSuccess() {

        int parent_id = 1;
        // Adding that image is updated
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        new Still(parent_id);
        // Adding the new image to the database
        Still still2 = new Still("https://www.example.com", 2, "Supreme", currentDate, currentTime, false, false);

        StillService stillService = new StillService();
        try {
            assertTrue(stillService.updateStill(still2));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testImageUpdateWithInvalidImageUrlFailure() {
        int parent_id = 2;

        // Adding that image is updated

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        // Adding the new image to the database
        new Still(parent_id);
        Still still2 = new Still("www.example.png", 2, "Supreme", currentDate, currentTime, false, false);

        StillService stillService = new StillService();

        ServiceException result = assertThrows(ServiceException.class, () -> stillService.updateStill(still2));

        String expectedMessage = StillConstants.getCommonServiceErrorMessage() + StillConstants.getInvalidStillUrlMessage();
        assertEquals(expectedMessage, result.getMessage());
    }


    // Test still delete feature

    @Test
    void testStillDeleteSuccess() {
        int still_id = 1;

        Still still = new Still(true, still_id, 1);

        StillService stillService = new StillService();

        try {
            assertTrue(stillService.deleteStill(still));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }


    // test still delete with invalid details
    @Test
    void testStillDeleteDetailsWithInvalidStillId() {

        int still_id = -1;

        StillService stillService = new StillService();
        Still still = new Still(true, still_id, 1);
        ServiceException result = assertThrows(ServiceException.class, () -> stillService.deleteStill(still));
        String expectedMessage = StillConstants.getCommonDaoErrorMessage() + StillConstants.getInvalidStillIdMessage();
        assertEquals(expectedMessage, result.getMessage());
    }


    // Test still favourite feature

    @Test
    void testImageFavouriteSuccess() {
        Still still = new Still(true, 1);
        StillService stillService = new StillService();

        try {
            assertTrue(stillService.favouriteStill(still));

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }


    @Test
    void testImageFavouriteNullDetails() {
        Still still = null;
        StillService stillService = new StillService();

        InvalidUserException result = assertThrows(InvalidUserException.class, () -> stillService.favouriteStill(still));
        assertEquals(StillConstants.getInvalidStillFavouriteMessage(), result.getMessage());
    }

}
