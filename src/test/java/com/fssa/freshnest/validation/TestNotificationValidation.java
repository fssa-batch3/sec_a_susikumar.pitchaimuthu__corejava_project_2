package com.fssa.freshnest.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

class TestNotificationValidation {

	@Test
	void testValidateNotIsReadCountValidUserId() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(1);
		try {
			boolean result = NotificationValidator.validateNotIsReadCount(requestAndResponse);
			assertTrue(result);
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testValidateNotIsReadCountInvalidUserId() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(-1);
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> NotificationValidator.validateNotIsReadCount(requestAndResponse));
		assertEquals(result.getMessage(), "Invalid user notification checking");
	}
	
	@Test
	void testValidateNotIsReadCountInvalidUserIdTwo() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(-1);
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> NotificationValidator.validateNotIsReadCount(requestAndResponse));
		assertEquals(result.getMessage(), "Invalid user notification checking");
	}

	@Test
	void testValidateNotificationReadUserIdValidUserId() {
		int userId = 2;
		try {
			boolean result = NotificationValidator.validateNotificationReadUserId(userId);
			assertTrue(result);
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testValidateNotificationReadUserIdInvalidUserId() {
		int userId = -1;
		InvalidUserException result = assertThrows(InvalidUserException.class, () -> NotificationValidator.validateNotificationReadUserId(userId));
		assertEquals("Invalid user notification checking", result.getMessage() );
	}
	
	@Test
	void testValidateNotificationReadUserIdInvalidUserIdTwo() {
		int userId = -1;
		InvalidUserException result = assertThrows(InvalidUserException.class, () -> NotificationValidator.validateNotificationReadUserId(userId));
		assertEquals("Invalid user notification checking",result.getMessage() );
	}


	@Test
	void testValidateNotificationIdValidNotificationId() {
		int notificationId = 3;
		try {
			boolean result = NotificationValidator.validateNotificationId(notificationId);
			assertTrue(result);
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testValidateNotificationIdInvalidNotificationId() {
		int notificationId = 0;
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> NotificationValidator.validateNotificationId(notificationId));
		assertEquals( "Invalid notificaiton id", result.getMessage());
	}
	
	@Test
	void testValidateNotificationIdInvalidNotificationIdTwo() {
		int notificationId = 0;
		InvalidUserException result = 	assertThrows(InvalidUserException.class, () -> NotificationValidator.validateNotificationId(notificationId));
		assertEquals( "Invalid notificaiton id", result.getMessage());
	}
}
