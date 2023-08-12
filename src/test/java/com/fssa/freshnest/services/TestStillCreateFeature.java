package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TestStillCreateFeature {

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
}
