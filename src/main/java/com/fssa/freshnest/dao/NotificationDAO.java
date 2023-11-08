package com.fssa.freshnest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.model.InviteReaction;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.utils.ConnectionUtils;

public class NotificationDAO {

	private static final String USER_ID = "user_id";

	/**
	 * Sends a follow request notification to a user.
	 * 
	 * @param followConnection The RequestAndResponse object containing sender,
	 *                         receiver, and notification type.
	 * @return True if the notification was successfully sent, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean sendFollowRequestNotification(RequestAndResponse followConnection) throws DAOException {
		// SQL query to insert a notification
		String insertQuery = "INSERT INTO notifications (sender_id, receiver_id, notification_type) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			statement.setInt(1, followConnection.getRequestSenderId());
			statement.setInt(2, followConnection.getRequestReceiverId());
			statement.setString(3, followConnection.getRequestType());

			int rows = statement.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Counts the number of unread notifications for a user.
	 * 
	 * @param receiverUserId The ID of the user whose unread notifications are
	 *                       counted.
	 * @return The count of unread notifications.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public int countNotIsReadNotificationCounts(int receiverUserId) throws DAOException {
		int count = 0;
		// SQL query to count the unread notifications
		String countQuery = "SELECT COUNT(*) FROM notifications WHERE receiver_id = ? AND is_read = 0";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(countQuery)) {
			statement.setInt(1, receiverUserId);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					count = resultSet.getInt(1);
				}
			}
			return count;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves all notifications for a user, including sender and user details.
	 * 
	 * @param requestAndResponse The RequestAndResponse object containing the user
	 *                           ID.
	 * @return A list of RequestAndResponse objects representing notifications.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public List<RequestAndResponse> getAllUserNotifications(RequestAndResponse requestAndResponse) throws DAOException {
		List<RequestAndResponse> notificationList = new ArrayList<>();
		// SQL query to retrieve notifications with sender details
		String selectQuery = "SELECT u.*, n.* FROM notifications n JOIN users u ON n.sender_id = u.user_id WHERE n.receiver_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, requestAndResponse.getRequestSenderId());

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					RequestAndResponse requestAndResponse1 = new RequestAndResponse();

					requestAndResponse1.setNotificationId(resultSet.getInt("notification_id"));
					requestAndResponse1.setRequestSenderId(resultSet.getInt("sender_id"));
					requestAndResponse1.setRequestType(resultSet.getString("notification_type"));
					requestAndResponse1.setNotifyAt(resultSet.getTimestamp("notify_at"));
					requestAndResponse1.setUserId(resultSet.getInt(USER_ID));
					requestAndResponse1.setUsername(resultSet.getString("username"));
					requestAndResponse1.setUserTheme(resultSet.getString("user_theme"));
					requestAndResponse1.setProfileImage(resultSet.getString("profile_image"));
					notificationList.add(requestAndResponse1);
				}
			}
			return notificationList;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Reads notification details by notification ID and retrieves sender and user
	 * information.
	 * 
	 * @param requestAndResponse The RequestAndResponse object containing the
	 *                           notification ID.
	 * @return A RequestAndResponse object representing the notification details.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public RequestAndResponse readNotificationDetails(RequestAndResponse requestAndResponse) throws DAOException {
		List<RequestAndResponse> notificationList = new ArrayList<>();
		// SQL query to retrieve notification details with sender and user information
		String selectQuery = "SELECT u.*, n.* FROM notifications n JOIN users u ON n.sender_id = u.user_id WHERE n.notification_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, requestAndResponse.getNotificationId());

			try (ResultSet resultSet = statement.executeQuery()) {
				RequestAndResponse requestAndResponse1 = new RequestAndResponse();
				while (resultSet.next()) {
					requestAndResponse1.setRequestSenderId(resultSet.getInt("sender_id"));
					requestAndResponse1.setRequestType(resultSet.getString("notification_type"));
					requestAndResponse1.setNotifyAt(resultSet.getTimestamp("notify_at"));
					requestAndResponse1.setUserId(resultSet.getInt(USER_ID));
					requestAndResponse1.setUsername(resultSet.getString("username"));
					requestAndResponse1.setUserTheme(resultSet.getString("user_theme"));
					requestAndResponse1.setProfileImage(resultSet.getString("profile_image"));
					notificationList.add(requestAndResponse1);
				}
			}
			return notificationList.get(0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Checks whether an invite request notification is present for a specific
	 * sender and invite.
	 * 
	 * @param requestAndResponse The RequestAndResponse object containing sender and
	 *                           invite details.
	 * @return True if an invite request notification is present, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean checkWhetherTheInviteRequestPresentOrNot(RequestAndResponse requestAndResponse) throws DAOException {
		Invite invite = new Invite();
		// SQL query to count invite request notifications
		String selectQuery = "SELECT COUNT(*) FROM notifications WHERE sender_id = ? AND invite_id = ?  AND notification_type = 'invite_request'";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, requestAndResponse.getRequestSenderId());
			statement.setInt(2, invite.getInviteId());
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0;
			}

			return false;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Sends an invite request notification to a user.
	 * 
	 * @param followConnection The RequestAndResponse object containing sender,
	 *                         receiver, notification type, and invite ID.
	 * @return True if the invite request notification was successfully sent, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean sendInviteRequestNotification(RequestAndResponse followConnection) throws DAOException {
		// SQL query to insert an invite request notification
		String insertQuery = "INSERT INTO notifications (sender_id, receiver_id, notification_type, invite_id) VALUES (?, ?, ?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			statement.setInt(1, followConnection.getRequestSenderId());
			statement.setInt(2, followConnection.getRequestReceiverId());
			statement.setString(3, followConnection.getRequestType());
			statement.setInt(4, followConnection.getInviteId());

			int rows = statement.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Reads invite send request notification details, including user, invite, and
	 * reaction information.
	 * 
	 * @param requestAndResponse The RequestAndResponse object containing the
	 *                           notification ID.
	 * @return A RequestAndResponse object representing the notification details.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public RequestAndResponse readInviteSendRequestNotificationDetails(RequestAndResponse requestAndResponse)
			throws DAOException {
		UserDAO userDAO = new UserDAO();
		InviteDAO inviteDAO = new InviteDAO();
		InviteReactionDAO inviteReactionDAO = new InviteReactionDAO();
		// SQL query to retrieve invite send request notification details with related
		// data
		String insertQuery = "SELECT n.*, u.user_id, i.* " + "FROM notifications n "
				+ "JOIN users u ON n.receiver_id = u.user_id "
				+ "LEFT JOIN invite_react_details i ON n.invite_id = i.invite_id " + "WHERE n.notification_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, requestAndResponse.getNotificationId());
			RequestAndResponse requestAndResponse1 = new RequestAndResponse();
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					int userId = resultSet.getInt(USER_ID);
					int inviteId = resultSet.getInt("invite_id");
					int reactId = resultSet.getInt("react_id");
					User user = userDAO.readUserFrinedsDetailsByUserId(userId);
					Invite invite = inviteDAO.readUserInviteDetailsByInviteId(inviteId);
					InviteReaction inviteReaction = inviteReactionDAO.getUserUserReactionDetailsByReactId(reactId);
					requestAndResponse1.setUser(user);
					requestAndResponse1.setInvite(invite);
					requestAndResponse1.setInviteReaction(inviteReaction);
					requestAndResponse1.setInviteRequestReaction(resultSet.getString("invite_request_reaction"));
				}
			}
			return requestAndResponse1;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Sends a time-tale message notification to a user.
	 * 
	 * @param requestAndResponse The RequestAndResponse object containing sender,
	 *                           receiver, notification type, and message text.
	 * @return True if the message notification was successfully sent, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean sendTimeTaleMessage(RequestAndResponse requestAndResponse) throws DAOException {
		// SQL query to insert a message notification
		String insertQuery = "INSERT INTO notifications (sender_id, receiver_id, notification_type, notification_text) VALUES (?, ?, ?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, requestAndResponse.getRequestSenderId());
			statement.setInt(2, requestAndResponse.getRequestReceiverId());
			statement.setString(3, requestAndResponse.getRequestType());
			statement.setString(4, requestAndResponse.getRequestText());
			int rows = statement.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Marks notifications as read for a user with a specific timestamp.
	 * 
	 * @param requestAndResponse The RequestAndResponse object containing the user
	 *                           ID and timestamp.
	 * @return True if the notifications were successfully marked as read, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean makeNotificationAsRead(RequestAndResponse requestAndResponse) throws DAOException {
		// SQL query to update notifications as read
		String query = "UPDATE notifications SET is_read = 1 WHERE receiver_id = ? AND notify_at < ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, requestAndResponse.getRequestSenderId());
			statement.setTimestamp(2, requestAndResponse.getNotifyAt());
			int rowsUpdated = statement.executeUpdate();
			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
