package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class TestInvitationDeleteFeature {



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

    // test delete the invite with null details
    @Test
    void testInvalidDeleteNull() {
        Invite invite = null;

        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.updateInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
