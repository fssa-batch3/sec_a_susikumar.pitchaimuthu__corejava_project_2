package freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import freshnest.model.Still;

public class TestStillUpdateFeature {

	public static void main(String[] args) {

		int still_id = 2;

		// Adding that image is updated
		Still still = new Still(still_id, true);

		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		// Adding the new image to the database
		Still still2 = new Still("https://www.example.com", 2, "Supreme", currentDate, currentTime, false, false);

		StillService stillService = new StillService();

		try {
			stillService.UpdateStill(still);
			stillService.TakeStill(still2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testImageUpdateSuccess() {
		int still_id = 2;

		// Adding that image is updated
		Still still = new Still(still_id, true);

		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		// Adding the new image to the database
		Still still2 = new Still("https://www.example.com", 2, "Supreme", currentDate, currentTime, false, false);

		StillService stillService = new StillService();
		try {
			assertTrue(stillService.UpdateStill(still));
			assertTrue(stillService.TakeStill(still2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testImageUpdateFailure() {
		int still_id = 2;

		// Adding that image is updated
		Still still = new Still(still_id, true);

		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		// Adding the new image to the database
		Still still2 = new Still("www..example.png", 2, "Supreme", currentDate, currentTime, false, false);

		StillService stillService = new StillService();
		try {
			assertTrue(stillService.UpdateStill(still));
			assertFalse(stillService.TakeStill(still2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testImageNullDetails() {
		// Adding that image is updated
		Still still = null;

		// Adding the new image to the database
		Still still2 = null;

		StillService stillService = new StillService();
		try {
			assertFalse(stillService.UpdateStill(still));
			assertFalse(stillService.TakeStill(still2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
