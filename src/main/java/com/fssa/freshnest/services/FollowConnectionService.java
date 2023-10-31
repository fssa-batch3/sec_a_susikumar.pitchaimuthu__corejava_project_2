package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.FollowConnectionConstants;
import com.fssa.freshnest.dao.FollowConnectionDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.FollowConnectionValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class FollowConnectionService {

	/**
	 * Sends a follow request from one user to another.
	 *
	 * @param requestAndResponse The request and response object containing follow
	 *                           request details.
	 * @return True if the follow request is successfully sent; otherwise, false.
	 * @throws ServiceException If there's an issue while sending the follow
	 *                          request.
	 */
	public boolean followRequestSendService(RequestAndResponse requestAndResponse) throws ServiceException {
		FollowConnectionDAO followConnectionDAO = new FollowConnectionDAO();
		NotificationService notificationService = new NotificationService();
		try {
			FollowConnectionValidator.validateUserFollowRequest(requestAndResponse);

			if (!followConnectionDAO.checkUserAlreadyExistsOrNotUsingUserId(requestAndResponse.getRequestSenderId())) {
				throw new ServiceException(FollowConnectionConstants.getInvalidFollowRequestId());
			}

			if (!followConnectionDAO
					.checkUserAlreadyExistsOrNotUsingUserId(requestAndResponse.getRequestReceiverId())) {
				throw new ServiceException(FollowConnectionConstants.getInvalidFollowReceiverId());
			}

			notificationService.followRequestSendService(requestAndResponse);

			return followConnectionDAO.sendFollowRequestResponse(requestAndResponse);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Accepts a follow request from one user to another.
	 *
	 * @param requestAndResponse The request and response object containing follow
	 *                           request details.
	 * @return True if the follow request is successfully accepted; otherwise,
	 *         false.
	 * @throws ServiceException If there's an issue while accepting the follow
	 *                          request.
	 */

	public boolean followRequestAcceptService(RequestAndResponse requestAndResponse) throws ServiceException {

		FollowConnectionDAO followConnectionDAO = new FollowConnectionDAO();
		NotificationService notificationService = new NotificationService();
		Chat chat = new Chat();
		ChatService chatService = new ChatService();

		int[] participantArr = { requestAndResponse.getRequestSenderId(), requestAndResponse.getRequestReceiverId() };

		try {
			FollowConnectionValidator.validateUserFollowAccept(requestAndResponse);

			if (!followConnectionDAO.checkTheFollowRequestExistOrNot(requestAndResponse)) {
				throw new ServiceException("The user follow request is not exists");
			}

			notificationService.followRequestSendService(requestAndResponse);
			chat.setChatType("direct");
			chat.setChatName("direct conversation");
			chat.setParticipantsId(participantArr);
			chatService.insertDirectGroup(chat);
			chatService.insertChatParticipants(chat);

			return followConnectionDAO.sendFollowRequestResponse(requestAndResponse);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Checks whether a user is following another user.
	 *
	 * @param requestAndResponse The request and response object containing the user
	 *                           follow details.
	 * @return True if the user is following the other user; otherwise, false.
	 * @throws ServiceException If there's an issue while checking the user follow
	 *                          status.
	 */
	public boolean checkWhetherUserFollowingOrNot(RequestAndResponse requestAndResponse) throws ServiceException {
		FollowConnectionDAO followConnectionDAO = new FollowConnectionDAO();

		try {
			FollowConnectionValidator.validateUserFollowCheck(requestAndResponse);
			return followConnectionDAO.checkTheFollowRequestExistOrNot(requestAndResponse);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Unfollows a user, ending the following relationship.
	 *
	 * @param requestAndResponse The request and response object containing unfollow
	 *                           details.
	 * @return True if the user is successfully unfollowed; otherwise, false.
	 * @throws ServiceException If there's an issue while unfollowing the user.
	 */
	public boolean userUnFollow(RequestAndResponse requestAndResponse) throws ServiceException {
		FollowConnectionDAO followConnectionDAO = new FollowConnectionDAO();

		try {
			return followConnectionDAO.userUnFollow(requestAndResponse);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
