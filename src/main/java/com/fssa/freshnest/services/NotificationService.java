package com.fssa.freshnest.services;

import java.util.List;

import com.fssa.freshnest.dao.NotificationDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.NotificationValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class NotificationService {
	/**
	 * Sends a follow request notification to a user.
	 *
	 * @param followConnection The RequestAndResponse object containing follow
	 *                         request details.
	 * @return True if the notification was sent successfully, false otherwise.
	 * @throws ServiceException If there is an issue while sending the notification.
	 */
	public boolean followRequestSendService(RequestAndResponse followConnection) throws ServiceException {
		NotificationDAO notificationDAO = new NotificationDAO();

		try {
			return notificationDAO.sendFollowRequestNotification(followConnection);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Counts the number of unread notifications for a user.
	 *
	 * @param requestAndResponse The RequestAndResponse object containing the user
	 *                           ID.
	 * @return The count of unread notifications.
	 * @throws ServiceException If there is an issue while counting the
	 *                          notifications.
	 */

	public int countNotIsReadNotificationCounts(RequestAndResponse requestAndResponse) throws ServiceException {
		NotificationDAO notificationDAO = new NotificationDAO();

		try {
			NotificationValidator.validateNotIsReadCount(requestAndResponse);
			int counts = notificationDAO.countNotIsReadNotificationCounts(requestAndResponse.getRequestSenderId());

			if (counts == 0) {
				throw new ServiceException("No notification available");
			}

			return counts;

		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves all notifications for a specific user.
	 *
	 * @param requestAndResponse The RequestAndResponse object containing the user's
	 *                           ID.
	 * @return A list of notifications.
	 * @throws ServiceException If there is an issue while retrieving the
	 *                          notifications.
	 */

	public List<RequestAndResponse> getAllUserNotifications(RequestAndResponse requestAndResponse)
			throws ServiceException {

		NotificationDAO notificationDAO = new NotificationDAO();

		try {
			NotificationValidator.validateNotIsReadCount(requestAndResponse);

			List<RequestAndResponse> notification = notificationDAO.getAllUserNotifications(requestAndResponse);

			if (notification.isEmpty()) {
				throw new ServiceException("No Notificaitons available");
			}

			return notification;
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Retrieves details of a specific follow request notification.
	 *
	 * @param requestAndResponse The RequestAndResponse object containing the
	 *                           notification ID.
	 * @return The details of the follow request notification.
	 * @throws ServiceException If there is an issue while retrieving the
	 *                          notification details.
	 */

	public RequestAndResponse readFollowRequestNotificationDetails(RequestAndResponse requestAndResponse)
			throws ServiceException {

		NotificationDAO notificationDAO = new NotificationDAO();
		try {
			NotificationValidator.validateNotificationId(requestAndResponse.getNotificationId());

			return notificationDAO.readNotificationDetails(requestAndResponse);
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Sends an invite request notification to a user. If a request with the same
	 * sender, receiver, and type already exists, it will not be sent.
	 *
	 * @param requestAndResponse The RequestAndResponse object containing details of
	 *                           the notification.
	 * @return true if the notification was sent successfully, false otherwise.
	 * @throws ServiceException If there is an issue while sending the notification.
	 */

	public boolean sendInviteRequestNotification(RequestAndResponse requestAndResponse) throws ServiceException {
		NotificationDAO notificationDAO = new NotificationDAO();
 
		try {
			notificationDAO.checkWhetherTheInviteRequestPresentOrNot(requestAndResponse);
			
			return notificationDAO.sendInviteRequestNotification(requestAndResponse);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves details of an invite send request notification.
	 *
	 * @param requestAndResponse The RequestAndResponse object containing the
	 *                           notification ID.
	 * @return The details of the invite send request notification.
	 * @throws ServiceException If there is an issue while retrieving the
	 *                          notification details.
	 */

	public RequestAndResponse readInvteSendRequestNotificationDetails(RequestAndResponse requestAndResponse)
			throws ServiceException {
		NotificationDAO notificationDAO = new NotificationDAO();

		try {
			return notificationDAO.readInviteSendRequestNotificationDetails(requestAndResponse);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public RequestAndResponse readFollowAcceptNotificationDetails(RequestAndResponse requestAndResponse)
			throws ServiceException {
		return null;
	}

	public RequestAndResponse readInviteRequestAcceptNotificationDetails(RequestAndResponse requestAndResponse)
			throws ServiceException {
		return null;
	}

	public RequestAndResponse readOtherNotificationDetails(RequestAndResponse requestAndResponse)
			throws ServiceException {
		return null;
	}

	/**
	 * Sends a time-tale message as a notification to a user.
	 *
	 * @param requestAndResponse The RequestAndResponse object containing the
	 *                           time-tale message.
	 * @return true if the notification was sent successfully, false otherwise.
	 * @throws ServiceException If there is an issue while sending the notification.
	 */
	public boolean sendTimeTaleMessage(RequestAndResponse requestAndResponse) throws ServiceException {
		NotificationDAO notificationDAO = new NotificationDAO();

		try {
			return notificationDAO.sendTimeTaleMessage(requestAndResponse);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Marks a notification as read for the user.
	 *
	 * @param requestAndResponse The RequestAndResponse object containing details of
	 *                           the notification to be marked as read.
	 * @return true if the notification was successfully marked as read, false
	 *         otherwise.
	 * @throws ServiceException If there is an issue while marking the notification
	 *                          as read.
	 */

	public boolean makeNoticationAsRead(RequestAndResponse requestAndResponse) throws ServiceException {

		NotificationDAO notificationDAO = new NotificationDAO();

		try {
			return notificationDAO.makeNotificationAsRead(requestAndResponse);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
