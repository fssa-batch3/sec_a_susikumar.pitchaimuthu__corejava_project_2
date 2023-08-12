package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestInvitationUpdateFeature {


    // test the invitation with correct values
    @Test
    void testInviteUpdateSuccess() {
        Invite invite = new Invite(1, "Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
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
        Invite invite = new Invite(44, "Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
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
        Invite invite = new Invite(44, "Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
                "Ticket block ah vangathinga thangam", 3);

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test update invite details with null details
    @Test
    void testInvalidNullDetails() {
        Invite invite = null;

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
