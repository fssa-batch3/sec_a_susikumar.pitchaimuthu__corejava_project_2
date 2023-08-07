package freshnest.services;

import freshnest.model.Still;

public class TestStillReadFeature {

	public static void main(String[] args) {

		Still still = new Still( 44);
		StillService stillService = new StillService();

		try {
			stillService.ReadStill(still);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
