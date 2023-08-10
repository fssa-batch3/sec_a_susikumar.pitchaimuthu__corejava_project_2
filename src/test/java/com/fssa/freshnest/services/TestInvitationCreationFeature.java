package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInvitationCreationFeature {

    public static void main(String[] args) {

        Invite invite = new Invite(1, "Birthday party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
                "Ticket block the vangathinga thangam");

        InviteService inviteService = new InviteService();

        try {
            inviteService.createInvite(invite);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInvitationSuccess() {

        Invite invite = new Invite(1, "Birthday party", "2023-08-24", "12:34", "Manjal veeran", "Thangam",
                "Ticket block the vangathinga thangam");

        InviteService inviteService = new InviteService();

        try {
            assertTrue(inviteService.createInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidInvitationType() {

        Invite invite = new Invite(44, "Birthday party", "2023-08-24", "12:34", "Manjal veeran", "Thangam",
                "Ticket block the vangathinga thangam");

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.createInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvitationNullDetails() {
        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.createInvite(null));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
