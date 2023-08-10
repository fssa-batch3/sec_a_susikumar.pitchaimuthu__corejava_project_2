package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInvitationDeleteFeature {
    public static void main(String[] args) {
        Invite invite = new Invite(1);

        InviteService inviteService = new InviteService();

        try {
            inviteService.deleteInvite(invite);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvitationDeleteSuccess() {
        Invite invite = new Invite(1);

        InviteService inviteService = new InviteService();

        try {
            assertTrue(inviteService.deleteInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidIdDelete() {
        Invite invite = new Invite(1);

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void testInvalidDeleteNull() {
        Invite invite = null;

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
