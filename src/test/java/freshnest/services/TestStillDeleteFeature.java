package freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import freshnest.model.Still;

public class TestStillDeleteFeature {

	public static void main(String[] args) {

		int still_id = 2;

		Still still = new Still(true, still_id, 2);

		StillService stillService = new StillService();

		try {
			stillService.DeleteStill(still);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStillDeleteSuccess() {
		int still_id = 2;

		Still still = new Still(true, still_id, 2);

		StillService stillService = new StillService();

		try {
			assertTrue(stillService.DeleteStill(still));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStillDetailsNull() {

		Still still = null;

		StillService stillService = new StillService();

		try {
			assertFalse(stillService.DeleteStill(still));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
