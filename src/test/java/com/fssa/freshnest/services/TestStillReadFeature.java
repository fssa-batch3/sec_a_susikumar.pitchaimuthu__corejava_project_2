package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Still;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStillReadFeature {

    // Still read main feature main method
    public static void main(String[] args) {

        Still still = new Still(1);
        StillService stillService = new StillService();

        try {
            stillService.ReadStill(still);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    // test the still read success
    @Test
    public void testStillReadSuccess(){
        Still still = new Still(1);
        StillService stillService = new StillService();
        try {
            assertTrue(stillService.ReadStill(still));

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    // test the still invalid still id read
    @Test
    public void testInvalidStillIdRead(){
        Still still = new Still(-1);
        StillService stillService = new StillService();
        try {
            assertFalse(stillService.ReadStill(still));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // test the null still details
    @Test
    public void testReadNullStillIdDetails(){
        StillService stillService = new StillService();
        try {
            assertFalse(stillService.ReadStill(null));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}
