package com.fssa.freshnest.dao;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {

    public boolean sendFollowRequestNotification(RequestAndResponse followConnection) throws DAOException {

        String insertQuery = "INSERT INTO notifications (sender_id, receiver_id, notification_type) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            statement.setInt(1, followConnection.getRequestSenderId());
            statement.setInt(2, followConnection.getRequestReceiverId());
            statement.setString(3, followConnection.getRequestType());
            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public int countNotIsReadNotificationCounts(int receiverUserId) throws DAOException {
        int count = 0;
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

    public List<RequestAndResponse> getAllUserNotifications(RequestAndResponse requestAndResponse) throws DAOException {

        List<RequestAndResponse> notificaitonList = new ArrayList<>();

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
                    requestAndResponse1.setUserId(resultSet.getInt("user_id"));
                    requestAndResponse1.setUsername(resultSet.getString("username"));
                    requestAndResponse1.setUserTheme(resultSet.getString("user_theme"));
                    requestAndResponse1.setProfileImage(resultSet.getString("profile_image"));
                    notificaitonList.add(requestAndResponse1);
                    System.out.println(requestAndResponse1);
                }
            }
            return notificaitonList;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public RequestAndResponse readNotificationDetails(RequestAndResponse requestAndResponse) throws DAOException {

        List<RequestAndResponse> notificaitonList = new ArrayList<>();

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
                    requestAndResponse1.setUserId(resultSet.getInt("user_id"));
                    requestAndResponse1.setUsername(resultSet.getString("username"));
                    requestAndResponse1.setUserTheme(resultSet.getString("user_theme"));
                    requestAndResponse1.setProfileImage(resultSet.getString("profile_image"));
                    notificaitonList.add(requestAndResponse1);
                    System.out.println(requestAndResponse1);
                }
            }
            return notificaitonList.get(0);

        } catch (SQLException e) {
            throw new DAOException(e);

        }
    }

}
