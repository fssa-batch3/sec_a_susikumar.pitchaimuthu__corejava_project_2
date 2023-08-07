package freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import freshnest.model.Still;

public class TestStillFavouriteFeature {

	public static void main(String[] args) {

		Still still = new Still(true, 1);
		StillService stillService = new StillService();

		try {
			stillService.FavouriteStill(still);

		} catch (Exception e) {
			e.printStackTrace();

		}
 
	}

	@Test
	public void testImageFavouriteSuccess() {
		Still still = new Still(true, 1);
		StillService stillService = new StillService();

		try {
			assertTrue(stillService.FavouriteStill(still));

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
	@Test
	public void testImageFavouriteNullDetails() {
		Still still = null;
		StillService stillService = new StillService();

		try {
			assertFalse(stillService.FavouriteStill(still));

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
