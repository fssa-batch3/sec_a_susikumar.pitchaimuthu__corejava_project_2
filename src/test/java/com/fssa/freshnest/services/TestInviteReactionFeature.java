package com.fssa.freshnest.services;

import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.InviteService;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestInviteReactionFeature {
	
	public static void  main(String[] args)  {
		
		Invite invite = new Invite(4, 1, true, false, false, "Hello buddy I will come.");
		InviteService inviteService = new InviteService();
		
		try {
			inviteService.reactionInvite(invite);
		}catch(ServiceException e) {
			e.printStackTrace();
			
		}
	}

}
