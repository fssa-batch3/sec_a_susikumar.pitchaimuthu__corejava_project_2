package com.fssa.freshnest.services;

import java.util.List;

import com.fssa.freshnest.dao.NotificationDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.NotificationValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class NotificationService {

    public boolean followRequestSendService(RequestAndResponse followConnection) throws ServiceException {
        NotificationDAO notificationDAO = new NotificationDAO();

        try {
            return notificationDAO.sendFollowRequestNotification(followConnection);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public int countNotIsReadNotificationCounts(RequestAndResponse requestAndResponse) throws ServiceException {
        NotificationDAO notificationDAO = new NotificationDAO();

        try {
            NotificationValidator.validateNotIsReadCount(requestAndResponse);
            System.out.println("userId " + requestAndResponse.getRequestSenderId());
            System.out.println(notificationDAO.countNotIsReadNotificationCounts(requestAndResponse.getRequestReceiverId()));

            int counts = notificationDAO.countNotIsReadNotificationCounts(requestAndResponse.getRequestSenderId());

            if (counts == 0) {
                throw new ServiceException("No notification available");
            }

            return counts;

        } catch (InvalidUserException | DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<RequestAndResponse> getAllUserNotifications(RequestAndResponse requestAndResponse)
            throws ServiceException {

        NotificationDAO notificationDAO = new NotificationDAO();

        try {
            NotificationValidator.validateNotIsReadCount(requestAndResponse);

            List<RequestAndResponse> notification = notificationDAO.getAllUserNotifications(requestAndResponse);

            if (notification.isEmpty()) {
                throw new ServiceException("No Notificaitons available");
            }

            return notification;
        } catch (InvalidUserException | DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public RequestAndResponse readFollowRequestNotificationDetails(RequestAndResponse requestAndResponse) throws ServiceException {

        NotificationDAO notificationDAO = new NotificationDAO();
        try {
            NotificationValidator.validateNotificationId(requestAndResponse.getNotificationId());

            return notificationDAO.readNotificationDetails(requestAndResponse);
        } catch (InvalidUserException | DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }
    
    public boolean sendInviteRequestNotification(RequestAndResponse requestAndResponse) throws ServiceException{
        NotificationDAO notificationDAO = new NotificationDAO();

    	try {
    		if(notificationDAO.checkWhetherTheInviteRequestPresentOrNot(requestAndResponse)) {
    			
    		}
    		return notificationDAO.sendInviteRequestNotification(requestAndResponse);
    	}catch(DAOException e) {
    		throw new ServiceException(e.getMessage());
    	}
    }
    
    public RequestAndResponse readInvteSendRequestNotificationDetails(RequestAndResponse requestAndResponse) throws ServiceException{
        NotificationDAO notificationDAO = new NotificationDAO();

        try {
        	return notificationDAO.readInvteSendRequestNotificationDetails(requestAndResponse);
        }catch(DAOException e) {
        	throw new ServiceException(e.getMessage());
        }
    }

	public RequestAndResponse readFollowAcceptNotificationDetails(RequestAndResponse requestAndResponse) throws ServiceException{
		return null;
	}

	public RequestAndResponse readInviteRequestAcceptNotificationDetails(RequestAndResponse requestAndResponse) throws ServiceException{
		return null;
	}

	public RequestAndResponse readOtherNotificationDetails(RequestAndResponse requestAndResponse) throws ServiceException {
		return null;
	}

	public boolean sendTimeTaleMessage(RequestAndResponse requestAndResponse) throws ServiceException {
        NotificationDAO notificationDAO = new NotificationDAO();

		try {
			return notificationDAO.sendTimeTaleMessage(requestAndResponse);
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

	public boolean makeNoticationAsRead(RequestAndResponse requestAndResponse) throws ServiceException{

		NotificationDAO notificationDAO = new NotificationDAO();
		
		try {
			return notificationDAO.makeNotificationAsRead(requestAndResponse);
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
    
    
    
}
