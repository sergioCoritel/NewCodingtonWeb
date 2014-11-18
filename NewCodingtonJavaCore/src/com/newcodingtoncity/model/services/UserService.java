package com.newcodingtoncity.model.services;

import java.sql.SQLException;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.exceptions.DAOException;
import com.newcodingtoncity.model.exceptions.ServiceException;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;
import com.newcodingtoncity.model.interfaces.services.IUserService;

public class UserService implements IUserService{


	/**
	 * 
	 * @return true if login was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int login(User user) throws SQLException, ClassNotFoundException{
		DAOManager manager = null;
		IUserDAO userDAO = null;
		int userId = 0;

		try {
			manager = new DAOManager();
			userDAO = manager.getUserDAO();

			userId = userDAO.loginDAO(user);

			if(userId==0) {
				throw new ServiceException("Username or Password incorrect");
			}

			manager.closeOK();

		} catch(DAOException e) {
			if(manager != null) {
				manager.closeError();

			}

			throw new ServiceException("Error in data base.", e);

		}

		return userId;
	}


	/**
	 * 
	 * @param new_pass
	 * @return number of row affected if password was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updatePassword(User user, String new_pass) throws SQLException, ClassNotFoundException{

		DAOManager manager = null;
		IUserDAO userDAO = null;
		int affectedRows = 0;	

		try {
			manager = new DAOManager();
			userDAO = manager.getUserDAO();

			affectedRows = userDAO.updatePasswordDAO(user, new_pass);

		}catch (Exception ee) {
			System.out.println("updatePassword: "+ ee.getMessage());
			return false;

		} finally {
			if(manager != null) {
				if(affectedRows == 1) {
					manager.closeOK();

				} else {
					manager.closeError();

				}
			}

		}

		if(affectedRows == 1){
			return true;
		}
		else{
			return false;
		}

	}


	/**
	 * 
	 * @return number of row affected if info of user was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updateInfo(User user) throws SQLException, ClassNotFoundException{

		DAOManager manager = null;
		IUserDAO userDAO = null;
		int affectedRows = 0;	

		try {

			manager = new DAOManager();
			userDAO = manager.getUserDAO();    
			affectedRows = userDAO.updateInfoDAO(user);

		}catch (Exception ee) {
			System.out.println("updateInfo: "+ ee.getMessage());
			return false;

		} finally {
			if(manager != null) {
				if(affectedRows == 1) {
					manager.closeOK();
					return true;
				} else {
					manager.closeError();
					return false;
				}		
			}
		}

		if(affectedRows == 1){
			return true;
		}
		else{
			return false;
		}

	}

	/**
	 * 
	 * @param u
	 * @return true if user could register successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean registerNewVisitor(User user) throws SQLException, ClassNotFoundException{
		boolean reg = false;
		DAOManager manager = null;		
		IUserDAO userDAO = null;
		//IIdentifiersDAO sequenceDAO = null;

		try {
			manager = new DAOManager();	    
			userDAO = manager.getUserDAO();
			//sequenceDAO = manager.getIdentifiersDAO();

			reg = userDAO.registerNewVisitorDAO(user);

			if(!reg) {
				throw new ServiceException("Acount Exists: Choose new username (nickname) or email.");
				//userId = sequenceDAO.getNextId(IIdentifiersDAO.CLASS_USERS_NAME);		    
				//user.setUserId(userId);
				//reg = userDAO.registerNewVisitorDAO(user);
			}

			manager.closeOK();

		} catch(DAOException e) {
			if(manager != null) {
				manager.closeError();

			}

			throw new ServiceException("Error in data base.", e);

		}

		return reg;
	}




}


