package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestStillReadFeature {


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


}
