package com.fssa.freshnest.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.TimeTales;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

 class TestTimeTaleValidation {
	@Test
	void testValidateCreateTimeTalesValid() {
	    TimeTales timeTales = new TimeTales();
	    timeTales.setMediaUrl("https://example.com/image.jpg");

	    try {
	        boolean result = TimeTalesValidator.validateCreateTimeTales(timeTales);
	        assertTrue(result);
	    } catch (InvalidUserException e) {
	        fail();
	    }
	}

	@Test
	void testValidateCreateTimeTalesInvalid() {
	    TimeTales timeTales = new TimeTales();
	    timeTales.setMediaUrl("invalid-url");

	    InvalidUserException result = assertThrows(InvalidUserException.class,
	            () -> TimeTalesValidator.validateCreateTimeTales(timeTales));
	    assertEquals(result.getMessage(), "Invalid media url");
	}
	@Test
	void testValidateCreateTimeTalesInvalidTwo() {
	    TimeTales timeTales = new TimeTales();
	    timeTales.setMediaUrl("invalid-url");

	    InvalidUserException result = assertThrows(InvalidUserException.class,
	            () -> TimeTalesValidator.validateCreateTimeTales(timeTales));
	    assertEquals(result.getMessage(), "Invalid media url");
	}
	@Test
	void testValidateCreateTimeTalesInvalidThree() {
	    TimeTales timeTales = new TimeTales();
	    timeTales.setMediaUrl("invalid-url");

	    InvalidUserException result = assertThrows(InvalidUserException.class,
	            () -> TimeTalesValidator.validateCreateTimeTales(timeTales));
	    assertEquals(result.getMessage(), "Invalid media url");
	}
	
	@Test
	void testValidateMediaUrlValidHttp() {
	    String validUrl = "https://example.com/image.jpg";
	    try {
	        boolean result = TimeTalesValidator.validateMediaUrl(validUrl);
	        assertTrue(result);
	    } catch (InvalidUserException e) {
	        fail();
	    }
	}

	@Test
	void testValidateMediaUrlValidDataImage() {
	    String validDataUrl = "data:image/png;base64,base64data";
	    try {
	        boolean result = TimeTalesValidator.validateMediaUrl(validDataUrl);
	        assertTrue(result);
	    } catch (InvalidUserException e) {
	        fail();
	    }
	}

	@Test
	void testValidateMediaUrlValidDataVideo() {
	    String validDataUrl = "data:video/mp4;base64,base64data";
	    try {
	        boolean result = TimeTalesValidator.validateMediaUrl(validDataUrl);
	        assertTrue(result);
	    } catch (InvalidUserException e) {
	        fail();
	    }
	}

	

	@Test
	void testValidateMediaUrlInvalidMalformed() {
	    String invalidUrl = "invalid-url";
	    InvalidUserException result = assertThrows(InvalidUserException.class,
	            () -> TimeTalesValidator.validateMediaUrl(invalidUrl));
	    assertEquals(result.getMessage(), "Invalid media url");
	}
	@Test
	void testValidateMediaUrlInvalidMalformedTwo() {
	    String invalidUrl = "invalid-url";
	    InvalidUserException result = assertThrows(InvalidUserException.class,
	            () -> TimeTalesValidator.validateMediaUrl(invalidUrl));
	    assertEquals(result.getMessage(), "Invalid media url");
	}
	@Test
	void testValidateMediaUrlInvalidMalformedThree() {
	    String invalidUrl = "invalid-url";
	    InvalidUserException result = assertThrows(InvalidUserException.class,
	            () -> TimeTalesValidator.validateMediaUrl(invalidUrl));
	    assertEquals(result.getMessage(), "Invalid media url");
	}



}
