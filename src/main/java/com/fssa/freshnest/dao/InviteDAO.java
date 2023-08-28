package com.fssa.freshnest.dao;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 * This class provides data access methods to interact with the invite database table.
 *
 * @author SusikumarPitchaimuth
 */
public class InviteDAO {

    /**
     * Creates a new invite record in the database.
     *
     * @param invite The Invite object containing invite information to be created.
     * @return True if the invite is successfully created, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */

    // create invite data
    public boolean createInvite(Invite invite) throws DAOException {
        String insertQuery = "INSERT INTO fresh_invite (user_id, invite_type, invite_date, invite_time, special_person, invite_slogan, invite_explanation) VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            LocalDate inviteDate = LocalDate.parse(invite.getInviteDate());
            LocalTime inviteTime = LocalTime.parse(invite.getInviteTime());
            // Prepare SQL statement
            statement.setInt(1, invite.getUser().getUserId());
            statement.setString(2, invite.getInviteType());
            statement.setDate(3, Date.valueOf(inviteDate));
            statement.setTime(4, Time.valueOf(inviteTime));
            statement.setString(5, invite.getSpecialPerson());
            statement.setString(6, invite.getInviteSlogan());
            statement.setString(7, invite.getInviteExplanation());
            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    /**
     * Updates an existing invite record in the database.
     *
     * @param invite The Invite object containing updated invite information.
     * @return True if the invite information is successfully updated, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */

    public boolean updateInvite(Invite invite) throws DAOException {
        String updateQuery = "UPDATE fresh_invite SET  invite_type = ?, invite_date = ?, invite_time = ?, special_person = ?, invite_slogan = ?, invite_explanation = ? WHERE invite_id = ?";

        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            LocalDate inviteDate = LocalDate.parse(invite.getInviteDate());
            LocalTime inviteTime = LocalTime.parse(invite.getInviteTime());
            // Prepare SQL statement
            statement.setString(1, invite.getInviteType());
            statement.setDate(2, Date.valueOf(inviteDate));
            statement.setTime(3, Time.valueOf(inviteTime));
            statement.setString(4, invite.getSpecialPerson());
            statement.setString(5, invite.getInviteSlogan());
            statement.setString(6, invite.getInviteExplanation());
            statement.setInt(7, invite.getInviteId());
            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Marks an invite as deleted in the database.
     *
     * @param invite The Invite object containing invite information to be deleted.
     * @return True if the invite is successfully marked as deleted, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
    public boolean deleteInvite(Invite invite) throws DAOException {

        String updateQuery = "UPDATE fresh_invite SET is_delete = TRUE  WHERE invite_id = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setInt(1, invite.getInviteId());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows > 0);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Records a reaction to an invite in the database.
     *
     * @param invite The Invite object containing the reaction details.
     * @return True if the reaction is successfully recorded, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
    public boolean reactInvite(Invite invite) throws DAOException {
        String updateQuery = "INSERT INTO invite_react_details ( invite_id, reactor_id , is_accept, is_like  , is_dislike, invite_message) VALUES (?,?,?,?,?,?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setInt(1, invite.getInviteId());
            statement.setInt(2, invite.getReactorId());
            statement.setInt(3, invite.getIsAccept() ? 1 : 0);
            statement.setInt(4, invite.getIsLike() ? 1 : 0);
            statement.setInt(5, invite.getIsDislike() ? 1 : 0);
            statement.setString(6, invite.getInviteMessage());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Retrieves a List of stills belonging to a specific user from the database.
     *
     * @param invite The invite object containing the user id for which to retrieve invitation.
     * @return A list of invitation objects associated with user.
     * @throws DAOException If there is an issue with the database operation.
     */

    public List<Invite> readInvite(Invite invite) throws DAOException {
        List<Invite> inviteList = new ArrayList<>();
        String insertQuery = "SELECT * FROM fresh_invite WHERE user_id = ? AND is_delete = FALSE";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            statement.setInt(1, invite.getUser().getUserId());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Invite inviteResult = new Invite();
                    inviteResult.setInviteId(resultSet.getInt("invite_id"));
                    inviteResult.setInviteType(resultSet.getString("invite_type"));
                    inviteResult.setInviteDate(String.valueOf(resultSet.getDate("invite_date")));
                    inviteResult.setInviteTime(String.valueOf(resultSet.getTime("invite_time")));
                    inviteResult.setInviteSlogan(resultSet.getString("invite_slogan"));
                    inviteResult.setInviteExplanation(resultSet.getString("invite_explanation"));
                    inviteList.add(inviteResult);

                }
                return inviteList;

            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

}
