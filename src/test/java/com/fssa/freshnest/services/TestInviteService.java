package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test cases for the InviteService class, which handles various still-related operations.
 *
 * @author SusikumarPitchaimuth
 */
class TestInviteService {
    // Test invitation create feature
    // test the invite creation success
    @Test
    void testInvitationCreateSuccess() {
        User user = new User();
        user.setUserId(1);
        LocalDate date = LocalDate.of(2023, 9, 23);
        LocalTime time = LocalTime.of(23, 34);

        Invite invite = new Invite(user, "Birthday party", date, time, "Manjal veeran", "Thangam",
                "Ticket block the vangathinga thangam");
        InviteService inviteService = new InviteService();
        try {
            assertTrue(inviteService.createInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    // test the invite create with invalid invite type
    @Test
    void testInvalidInvitationType() {
        User user = new User();
        user.setUserId(1);
        LocalDate date = LocalDate.of(2023, 9, 23);
        LocalTime time = LocalTime.of(23, 34);


        Invite invite = new Invite(user, "", date, time, "Manjal veeran", "Thangam",
                "Ticket block the vangathinga thangam");

        InviteService inviteService = new InviteService();

        ServiceException result = assertThrows(ServiceException.class, () -> inviteService.createInvite(invite));
        assertEquals(InviteConstants.getInvalidInviteTypeMessage(), result.getMessage());


    }

    // Test invitation read feature

    @Test
    void testInviteListWithValidInputs() {

        User user = new User();
        user.setUserId(1);
        Invite invite = new Invite(user);
        InviteService inviteService = new InviteService();

        try {
            List<Invite> result = inviteService.listInvites(invite);
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    void testListUserInvitesWithValidInputs() {
        User user = new User();
        user.setUserId(1);
        Invite invite = new Invite(user);
        InviteService stillService = new InviteService();
        try {
            List<Invite> result = stillService.listInvites(invite);
            for (Invite i : result) {
                System.out.println(i);
            }
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }


    // User friends invite list feature
    @Test
    void testListUserFriendsInvitesWithValidInputs() {
        User user = new User();
        user.setUserId(1);
        Invite invite = new Invite(user);
        InviteService stillService = new InviteService();
        try {
            List<Invite> result = stillService.listFriendsInvite(invite);
            for (Invite i : result) {
                System.out.println(i);
            }
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    // User invite details showing test feature
    @Test
    void testListInviteDetailsShowingSuccess() {
        User user = new User();
        user.setUserId(1);
        Invite invite = new Invite(user, 4);
        InviteService stillService = new InviteService();
        try {
            List<Invite> result = stillService.listInviteDetails(invite);
            for (Invite i : result) {
                System.out.println(i);
            }
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }


    // Test invitation update feature
    // test the invitation with correct values
    @Test
    void testInviteDetailsUpdateSuccess() {
        LocalDate date = LocalDate.of(2023, 9, 23);
        LocalTime time = LocalTime.of(23, 34);

        Invite invite = new Invite("Love party", date, time, "Manjal veeran", "Thangam",
                "Ticket block ah vangathinga thangam", 4);

        InviteService inviteService = new InviteService();

        try {
            assertTrue(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test the invite update feature with invalid user id
    @Test
    void testUpdateInviteDetailsWithInvalidUserId() {
        LocalDate date = LocalDate.of(2023, 9, 23);
        LocalTime time = LocalTime.of(23, 34);

        Invite invite = new Invite("Love party", date, time, "Manjal veeran", "Thangam",
                "Ticket block ah vangathinga thangam", 3);

        InviteService inviteService = new InviteService();
        ServiceException result = assertThrows(ServiceException.class, () -> inviteService.updateInvite(invite));
        assertEquals(InviteConstants.getInvalidInviteUpdateMessage(), result.getMessage());


    }

    // test the invite update with invalid invite id
    @Test
    void testUpdateInviteDetailsWithInvalidInviteId() {
        LocalDate date = LocalDate.of(2023, 9, 23);
        LocalTime time = LocalTime.of(23, 34);

        Invite invite = new Invite("Love party", date, time, "Manjal veeran", "Thangam",
                "Ticket block ah vangathinga thangam", -3);

        InviteService inviteService = new InviteService();

        ServiceException result = assertThrows(ServiceException.class, () -> inviteService.updateInvite(invite));
        assertEquals(InviteConstants.getInvalidInviteUpdateMessage(), result.getMessage());
    }


    // Test invitation delete feature
    // test the invitation test success
    @Test
    void testInvitationDeleteSuccess() {
        Invite invite = new Invite(4);
        InviteService inviteService = new InviteService();
        try {
            assertTrue(inviteService.deleteInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    // test delete invite with invalid details
    @Test
    void testInvalidIdDelete() {
        Invite invite = new Invite(1);
        InviteService inviteService = new InviteService();

        ServiceException result = assertThrows(ServiceException.class, () -> inviteService.deleteInvite(invite));
        assertEquals(InviteConstants.getInvalidInviteDeleteMessage(), result.getMessage());

    }

}
