package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestStillFavouriteFeature {

	public static void main(String[] args) {

		Still still = new Still(true, 1);
		StillService stillService = new StillService();

		try {
			stillService.FavouriteStill(still);

		} catch (ServiceException e) {
			e.printStackTrace();

		}
 
	}

	@Test
	public void testImageFavouriteSuccess() {
		Still still = new Still(true, 1);
		StillService stillService = new StillService();

		try {
			assertTrue(stillService.FavouriteStill(still));

		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	
	@Test
	public void testImageFavouriteNullDetails() {
		Still still = null;
		StillService stillService = new StillService();

		try {
			assertFalse(stillService.FavouriteStill(still));

		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
