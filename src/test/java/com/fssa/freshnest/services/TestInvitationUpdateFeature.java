 package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.InviteService;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestInvitationUpdateFeature {
	public static void main(String[] args) {
		Invite invite = new Invite(44, "Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
				"Ticket block ah vangathinga thangam", 1);

		InviteService inviteService = new InviteService();

		try {
			inviteService.updateInvite(invite); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInviteUpdateSuccess() {
		Invite invite = new Invite(44, "Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
				"Ticket block ah vangathinga thangam", 1);

		InviteService inviteService = new InviteService();

		try {
			assertTrue(inviteService.updateInvite(invite)); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInvalidInviteId() {
		Invite invite = new Invite(44, "Love party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
				"Ticket block ah vangathinga thangam", 3);

		InviteService inviteService = new InviteService();

		try {
			assertFalse(inviteService.updateInvite(invite)); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidNullDetails() {
		Invite invite = null;

		InviteService inviteService = new InviteService();

		try {
			assertFalse(inviteService.updateInvite(invite)); 
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}