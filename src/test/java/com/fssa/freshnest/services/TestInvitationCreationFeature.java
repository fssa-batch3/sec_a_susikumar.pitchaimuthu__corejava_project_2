package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.InviteService;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestInvitationCreationFeature {

	public static void main(String[] args) {

		Invite invite = new Invite(44, "Birthday party", "2023-08-24", "19:36:11", "Manjal veeran", "Thangam",
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

		Invite invite = new Invite(44, "Birthday party", "2023-08-24", "12:34", "Manjal veeran", "Thangam",
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
	public void testInvitaionNullDetails() {

		Invite invite = null;

		InviteService inviteService = new InviteService();

		try {
			assertFalse(inviteService.createInvite(invite));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
