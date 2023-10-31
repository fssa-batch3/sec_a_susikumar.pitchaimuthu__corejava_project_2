package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.services.exceptions.ServiceException;

class TestNotificationService {

	@Test
	void testFollowRequestSend() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(6);
		requestAndResponse.setRequestReceiverId(7);
		requestAndResponse.setRequestType("follow_request");

		NotificationService notificationService = new NotificationService();

		try {
			assertTrue(notificationService.followRequestSendService(requestAndResponse));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testCountNotIsReadNotificationCounts() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(2);

		NotificationService notificationService = new NotificationService();

		try {
			notificationService.countNotIsReadNotificationCounts(requestAndResponse);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testGetAllUserNotifications() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(1);

		NotificationService notificationService = new NotificationService();

		try {
			List<RequestAndResponse> notifications = notificationService.getAllUserNotifications(requestAndResponse);
			assertNotNull(notifications);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testReadFollowRequestNotificationDetails() {
		NotificationService notificationService = new NotificationService();

		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setNotificationId(1);

		try {
			RequestAndResponse details = notificationService.readFollowRequestNotificationDetails(requestAndResponse);
			assertNotNull(details);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testSendInviteRequestNotification() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(1);
		requestAndResponse.setRequestReceiverId(2);
		requestAndResponse.setRequestType("invite_request");
		requestAndResponse.setInviteId(1);
		NotificationService notificationService = new NotificationService();
		try {
			assertTrue(notificationService.sendInviteRequestNotification(requestAndResponse));

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testReadInvteSendRequestNotificationDetails() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setNotificationId(1);

		NotificationService notificationService = new NotificationService();
		try {
			assertNotNull(notificationService.readInvteSendRequestNotificationDetails(requestAndResponse));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testSendTimeTaleNotification() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		requestAndResponse.setRequestSenderId(1);
		requestAndResponse.setRequestReceiverId(2);
		requestAndResponse.setRequestType("tale_reaction");
		requestAndResponse.setRequestText("Hello Machi");
		NotificationService notificationService = new NotificationService();

		try {
			assertTrue(notificationService.sendTimeTaleMessage(requestAndResponse));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	
	
	
	
	@Test
	void testMakeNotificationAsRead() {
		RequestAndResponse requestAndResponse = new RequestAndResponse();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		requestAndResponse.setRequestSenderId(1);
		requestAndResponse.setNotifyAt(timestamp);
		NotificationService notificationService = new NotificationService();

		try {
			assertTrue(notificationService.makeNoticationAsRead(requestAndResponse));

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
