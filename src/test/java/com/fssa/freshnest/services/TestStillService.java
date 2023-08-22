package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

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
    void testInvalidImageUrl() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        Still still = new Still("www.sampleImage.com", 2, "Supreme", currentDate, currentTime, false, false);
        StillService stillService = new StillService();

        try {
            assertFalse(stillService.takeStill(still));

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    @Test
    void testInvalidImageName() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        Still still = new Still("www.sampleImage.com", 2, "", currentDate, currentTime, false, false);
        StillService stillService = new StillService();

        try {
            assertFalse(stillService.takeStill(still));

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    @Test
    void testNullImgeDetails() {
        Still still = null;
        StillService stillService = new StillService();

        try {
            assertFalse(stillService.takeStill(still));

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

     // Test still read feature

    // test the still read success
    @Test
    void testStillReadSuccess() {
        Still still = new Still(1);
        StillService stillService = new StillService();
        try {
            assertTrue(stillService.readStill(still));

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
        try {
            assertFalse(stillService.readStill(still));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    // test the null still details
    @Test
    void testReadNullStillIdDetails() {
        StillService stillService = new StillService();
        try {
            assertFalse(stillService.readStill(null));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }


    // Test still update feature

     // test image update details
     @Test
     void testImageUpdateSuccess() {
         int still_id = 2;

         // Adding that image is updated
         Still still = new Still(still_id, true);

         LocalDate currentDate = LocalDate.now();
         LocalTime currentTime = LocalTime.now();

         // Adding the new image to the database
         Still still2 = new Still("https://www.example.com", 2, "Supreme", currentDate, currentTime, false, false);

         StillService stillService = new StillService();
         try {
             assertTrue(stillService.updateStill(still));
             assertTrue(stillService.takeStill(still2));
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

    @Test
    void testImageUpdateFailure() {
        int still_id = 2;

        // Adding that image is updated
        Still still = new Still(still_id, true);

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        // Adding the new image to the database
        Still still2 = new Still("www.example.png", 2, "Supreme", currentDate, currentTime, false, false);

        StillService stillService = new StillService();
        try {
            assertTrue(stillService.updateStill(still));
            assertFalse(stillService.takeStill(still2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testImageNullDetails() {
        // Adding that image is updated
        Still still = null;

        // Adding the new image to the database
        Still still2 = null;

        StillService stillService = new StillService();
        try {
            assertFalse(stillService.updateStill(still));
            assertFalse(stillService.takeStill(still2));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        }
    }

    @Test
    void testStillDetailsNull() {

        Still still = null;

        StillService stillService = new StillService();

        try {
            assertFalse(stillService.deleteStill(still));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


}
