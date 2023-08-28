package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;

/**
 * This class contains test cases for the InviteService class, which handles various still-related operations.
 *
 * @author SusikumarPitchaimuth
 */
class TestInviteService {
    // Test invitation create feature
    // test the invite creation success
    @Test
    void testInvitationSuccess() {

        User user = new User();
        user.setUserId(1);

        Invite invite = new Invite(user, "Birthday party", "2023-08-24", "12:34", "Manjal veeran", "Thangam",
                "Ticket block the vangathinga thangam");

        InviteService inviteService = new InviteService();

        try {
            assertTrue(inviteService.createInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test the invite create with invalid invite type
    @Test
    void testInvalidInvitationType() {
        User user = new User();
        user.setUserId(1);

        Invite invite = new Invite(user, "", "2023-08-24", "12:34", "Manjal veeran", "Thangam",
                "Ticket block the vangathinga thangam");

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.createInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // Test invitation read feature

    @Test
    void testInviteListWithValidInputs() {
        Invite invite = new Invite(1);
        InviteService inviteService = new InviteService();

        try {
            List<Invite> result = inviteService.readInvites(invite);
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    void testInviteReadWithValidInputs() {
        Invite invite = new Invite(1);
        InviteService stillService = new InviteService();
        try {
            List<Invite> result = stillService.readInvites(invite);
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
    void testInviteUpdateSuccess() {
        Invite invite = new Invite("Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
                "Ticket block ah vangathinga thangam", 25);

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
        Invite invite = new Invite("Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
                "Ticket block ah vangathinga thangam", 3);

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test the invite update with invalid invite id
    @Test
    void testUpdateInviteDetailsWithInvalidInviteId() {
        Invite invite = new Invite("Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
                "Ticket block ah vangathinga thangam", 3);

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


    // Test invitation delete feature
    // test the invitation test success
    @Test
    void testInvitationDeleteSuccess() {
        Invite invite = new Invite(25);

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

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
