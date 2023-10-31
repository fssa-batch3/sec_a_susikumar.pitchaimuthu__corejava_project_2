package com.fssa.freshnest.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.constants.FollowConnectionConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

class TestFollowConnectionValidation {
	@Test
	void testValidateUserIdValid() throws InvalidUserException {
		assertTrue(FollowConnectionValidator.validateUserId(1));
		assertTrue(FollowConnectionValidator.validateUserId(100));
	}

	@Test
	void testValidateUserIdInvalid() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> FollowConnectionValidator.validateUserId(0));

		InvalidUserException result2 = assertThrows(InvalidUserException.class,
				() -> FollowConnectionValidator.validateUserId(-1));

		assertEquals(result.getMessage(), FollowConnectionConstants.getInvalidUserId());
		assertEquals(result2.getMessage(), FollowConnectionConstants.getInvalidUserId());
	}

	@Test
	void testValidateFollowRequestTypeValid() throws InvalidUserException {
		assertTrue(FollowConnectionValidator.validateFollowRequestType("follow_request"));
	}

	@Test
	void testValidateFollowRequestTypeInvalid() {
		try {
			assertNotNull(FollowConnectionValidator.validateFollowRequestType(null));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
		InvalidUserException result2 = assertThrows(InvalidUserException.class,
				() -> FollowConnectionValidator.validateFollowRequestType(""));
		InvalidUserException result3 = assertThrows(InvalidUserException.class,
				() -> FollowConnectionValidator.validateFollowRequestType("invalid"));

		assertEquals(result2.getMessage(), FollowConnectionConstants.getInvalidFollowRequest());
		assertEquals(result3.getMessage(), FollowConnectionConstants.getInvalidFollowRequest());

	}

	@Test
	void testValidateFollowAcceptTypeValid() throws InvalidUserException {
		assertTrue(FollowConnectionValidator.validateFollowAcceptType("follow_accept"));
	}

	@Test
	void testValidateFollowAcceptTypeInvalid() {
		try {
			assertNotNull(FollowConnectionValidator.validateFollowAcceptType(null));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> FollowConnectionValidator.validateFollowAcceptType(""));
		InvalidUserException result2 = assertThrows(InvalidUserException.class,
				() -> FollowConnectionValidator.validateFollowAcceptType("invalid"));

		assertEquals(result.getMessage(), FollowConnectionConstants.getInvalidFollowRequestType());
		assertEquals(result2.getMessage(), FollowConnectionConstants.getInvalidFollowRequestType());
	}
}
