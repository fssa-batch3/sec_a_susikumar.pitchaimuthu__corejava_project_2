package com.fssa.freshnest.services;

import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestFollowConnectionService {

	@Test
	void testFollowRequestSuccess() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(3);
		requestAndResponse.setRequestReceiverId(2);
		requestAndResponse.setRequestType("follow_request");

		FollowConnectionService followConnectionService = new FollowConnectionService();

		try {

			assertTrue(followConnectionService.followRequestSendService(requestAndResponse));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testFollowAcceptSuccess() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(2);
		requestAndResponse.setRequestReceiverId(3);
		requestAndResponse.setRequestType("follow_accept");

		FollowConnectionService followConnectionService = new FollowConnectionService();

		try {
			assertTrue(followConnectionService.followRequestAcceptService(requestAndResponse));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testUserUnfollow() {

		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(2);
		requestAndResponse.setRequestReceiverId(3);

		FollowConnectionService followConnectionService = new FollowConnectionService();

		try {
			assertTrue(followConnectionService.userUnFollow(requestAndResponse));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testTheUserFollowingTheUserNot() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(1);
		requestAndResponse.setRequestReceiverId(2);

		FollowConnectionService followConnectionService = new FollowConnectionService();

		try {
			assertTrue(followConnectionService.checkWhetherUserFollowingOrNot(requestAndResponse));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

}
