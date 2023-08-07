package freshnest.services;

import freshnest.model.Invite;
import freshnest.services.exceptions.ServiceException;

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
