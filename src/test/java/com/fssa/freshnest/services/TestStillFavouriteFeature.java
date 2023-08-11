package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class TestStillFavouriteFeature {

   
 
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

        try {
            assertFalse(stillService.favouriteStill(still));

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
