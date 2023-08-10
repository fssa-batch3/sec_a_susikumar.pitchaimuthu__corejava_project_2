package com.fssa.freshnest.services;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.exceptions.ServiceException;

import static org.junit.jupiter.api.Assertions.*;

public class TestInviteReactionFeature {

    public static void main(String[] args) {
        Invite invite = new Invite(25, 1, true, false, false, "Hello buddy I will come.");
        InviteService inviteService = new InviteService();

        try {
            inviteService.reactionInvite(invite);
        } catch (ServiceException e) {
            e.printStackTrace();
 
        }
    } 
    
    // test invite success
    @Test
     void testInviteReactionSuccess() {
    	Invite invite = new Invite(27, 1, true, false, false, "Hello buddy I will come.");
        InviteService inviteService = new InviteService();

        try {
            assertTrue(inviteService.reactionInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
           fail();
        }
    }

    // test the invite not exists invite id
    @Test
    void testNotExistInvalidId() {
        Invite invite = new Invite(1, 1, true, false, false, "Hello buddy I will come.");
        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.reactionInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test the invite invalid chat message reaction
    @Test
    void testInvalidChatReaction() {
        Invite invite = new Invite(27, 1, true, false, false, "");
        InviteService inviteService = new InviteService();

        try {
            assertFalse(inviteService.reactionInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
