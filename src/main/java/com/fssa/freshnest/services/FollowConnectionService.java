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
			chatService.insertChatGroup(chat);
			chatService.insertChatParticipants(chat);

			return followConnectionDAO.sendFollowRequestResponse(requestAndResponse);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean checkWhetherUserFollowingOrNot(RequestAndResponse requestAndResponse) throws ServiceException {
		FollowConnectionDAO followConnectionDAO = new FollowConnectionDAO();

		try {
			FollowConnectionValidator.validateUserFollowCheck(requestAndResponse);
			return followConnectionDAO.checkTheFollowRequestExistOrNot(requestAndResponse);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public boolean userUnFollow(RequestAndResponse requestAndResponse) throws ServiceException {

		FollowConnectionDAO followConnectionDAO = new FollowConnectionDAO();

		try {
			return followConnectionDAO.userUnFollow(requestAndResponse);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
