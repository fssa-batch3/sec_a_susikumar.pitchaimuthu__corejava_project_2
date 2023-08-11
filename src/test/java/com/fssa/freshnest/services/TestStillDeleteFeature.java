package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;

 class TestStillDeleteFeature {

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
