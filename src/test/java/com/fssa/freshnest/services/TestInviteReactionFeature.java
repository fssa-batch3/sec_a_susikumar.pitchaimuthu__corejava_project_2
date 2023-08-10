package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestInviteReactionFeature {

    public static void main(String[] args) {

        Invite invite = new Invite(1, 1, true, false, false, "Hello buddy I will come.");
        InviteService inviteService = new InviteService();

        try {
            inviteService.reactionInvite(invite);
        } catch (ServiceException e) {
            e.printStackTrace();
 
        }
    } 
    
    // test invite 
    
    @Test
    public void testInviteReactionSuccess() {
    	Invite invite = new Invite(4, 1, true, false, false, "Hello buddy I will come.");
        InviteService inviteService = new InviteService();

        try {
            assertTrue(inviteService.reactionInvite(invite));
        } catch (ServiceException e) {
            e.printStackTrace();
 
        }
    }

}
