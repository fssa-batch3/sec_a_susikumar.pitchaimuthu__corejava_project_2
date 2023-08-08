package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestStillCreateFeature {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		Still still = new Still("https://www.example.com", 1, "Supreme", currentDate, currentTime, false, false);
		StillService stillService = new StillService();

		try {
			stillService.TakeStill(still);

		} catch (ServiceException e) {
			e.printStackTrace();

		}
 
	}

	@Test
	public void testStillCreateSuccess() {
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		Still still = new Still("www.sampleImage.png", 2, "Supreme", currentDate, currentTime, false, false);
		StillService stillService = new StillService();

		try {
			assertTrue(stillService.TakeStill(still));

		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidImageUrl() {
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		Still still = new Still("www.sampleImage.com", 2, "Supreme", currentDate, currentTime, false, false);
		StillService stillService = new StillService();

		try {
			assertFalse(stillService.TakeStill(still));

		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testNullImgeDetails() {
		Still still = null;
		StillService stillService = new StillService();

		try {
			assertFalse(stillService.TakeStill(still));

		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
