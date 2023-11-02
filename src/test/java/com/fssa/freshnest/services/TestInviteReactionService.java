package com.fssa.freshnest.services;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.InviteReaction;
import com.fssa.freshnest.services.exceptions.ServiceException;

 class TestInviteReactionService {
	@Test
	void testGetUserInviteReactionNotFound() {
	    InviteReaction inviteReaction = new InviteReaction();
	    inviteReaction.setUserId(1);
	    inviteReaction.setInviteId(2);

	    InviteReactionService inviteReactionService = new InviteReactionService();
	    try {
	        InviteReaction result = inviteReactionService.getUserInviteReaction(inviteReaction);
	        assertNull(result);
	    } catch (ServiceException e) {
	        fail();
	    }
	}

	@Test
	void testGetUserInviteReactionInvalidUser() {
	    InviteReaction inviteReaction = new InviteReaction();
	    inviteReaction.setUserId(-1); 
	    inviteReaction.setInviteId(2);

	    InviteReactionService inviteReactionService = new InviteReactionService();
	    try {
	        InviteReaction result = inviteReactionService.getUserInviteReaction(inviteReaction);
	        assertNull(result);
	    } catch (ServiceException e) {
	        fail();
	    }
	}

	

}
