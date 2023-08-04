package freshnest.services;

import freshnest.DAO.ChatDAO;
import freshnest.DAO.exceptions.DAOException;
import freshnest.model.Chat;
import freshnest.services.exceptions.ServiceException;
import freshnest.validation.ChatValidator;
import freshnest.validation.exceptions.InvalidUserException;

public class ChatService {

	public boolean createChat(Chat chat) throws ServiceException {

		ChatDAO chatDAO = new ChatDAO();
		try {

			ChatValidator.validateCreateChat(chat);
			if (chatDAO.createChat(chat)) {
				System.out.println(chat.getChat_receiverId() + " chat send Successfully!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// chat read
	public boolean readChat(Chat chat) throws ServiceException {

		ChatDAO chatDAO = new ChatDAO();
		try {

			ChatValidator.validateReadChat(chat);
			if (chatDAO.readChat(chat)) {
				System.out.println(chat.getChat_receiverId() + " chat readed Successfully!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// chat update
	public boolean updateChat(Chat chat) throws ServiceException {

		ChatDAO chatDAO = new ChatDAO();
		try {

			ChatValidator.validateUpdateChat(chat);
			if (chatDAO.updateChat(chat)) {
				System.out.println(chat.getChat_receiverId() + " chat updated Successfully!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean deleteChat(Chat chat) throws ServiceException {

		ChatDAO chatDAO = new ChatDAO();
		try {

			ChatValidator.validateDeleteChat(chat);
			if (chatDAO.updateChat(chat)) {
				System.out.println(chat.get_chatId() + " chat deleted Successfully!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

}
