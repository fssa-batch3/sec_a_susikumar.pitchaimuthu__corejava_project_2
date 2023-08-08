package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.StillService;

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
