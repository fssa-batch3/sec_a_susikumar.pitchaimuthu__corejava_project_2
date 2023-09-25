package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.TimeTalesDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.TimeTales;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.TimeTalesValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.util.List;

public class TimeTalesService {

    public boolean createTimeTale(TimeTales timeTales) throws ServiceException {
        TimeTalesDAO timeTalesDAO = new TimeTalesDAO();

        try {
            TimeTalesValidator.validateCreateTimeTales(timeTales);
            return timeTalesDAO.createTimeTales(timeTales);
        } catch (InvalidUserException | DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public  TimeTales readStillDetails(TimeTales timeTales) throws  ServiceException{
        TimeTalesDAO timeTalesDAO = new TimeTalesDAO();

        try {
            return timeTalesDAO.readTimeTaleDetail(timeTales);
        }catch (DAOException e){
            throw  new ServiceException(e.getMessage());
        }
    }

    public List<TimeTales> listUserTimeTales(TimeTales timeTales) throws  ServiceException{
        TimeTalesDAO timeTalesDAO = new TimeTalesDAO();

        try {
            return timeTalesDAO.listUserTimeTales(timeTales);
        }catch (DAOException e){
            throw  new ServiceException(e.getMessage());
        }
    }

	public boolean deleteTimeTalesByTaleId(TimeTales timeTale) throws ServiceException {

		TimeTalesDAO timeTalesDAO = new TimeTalesDAO();
		
		try {
			return timeTalesDAO.deleteTimeTalesByTaleId(timeTale.getTaleId());
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
