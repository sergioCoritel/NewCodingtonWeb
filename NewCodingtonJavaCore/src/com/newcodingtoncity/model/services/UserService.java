package com.newcodingtoncity.model.services;

import java.sql.SQLException;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.exceptions.DAOException;
import com.newcodingtoncity.model.exceptions.ServiceException;
import com.newcodingtoncity.model.interfaces.daos.IIdentifiersDAO;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;
import com.newcodingtoncity.model.interfaces.services.IUserService;

public class UserService implements IUserService{


	/**
	 * 
	 * @return true if login was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean login(User u) throws SQLException, ClassNotFoundException{
		return true;
	}


	/**
	 * 
	 * @param new_pass
	 * @return number of row affected if password was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updatePassword(User user, String new_pass) throws SQLException, ClassNotFoundException{

		DAOManager manager = null;
		IUserDAO userDAO = null;
		int affectedRows = 0;	

		try {
			manager = new DAOManager();
			userDAO = manager.getUserDAO();

			affectedRows = userDAO.updatePasswordDAO(user, new_pass);

		}catch (Exception ee) {
			System.out.println("updatePassword: "+ ee.getMessage());
			return affectedRows;

		} finally {
			if(manager != null) {
				if(affectedRows == 1) {
					manager.closeOK();

				} else {
					manager.closeError();

				}
			}

		}

		return affectedRows;
	}


	/**
	 * 
	 * @return number of row affected if info of user was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateInfo(User user) throws SQLException, ClassNotFoundException{

		DAOManager manager = null;
		IUserDAO userDAO = null;
		int affectedRows = 0;	

		try {

			manager = new DAOManager();
			userDAO = manager.getUserDAO();    
			affectedRows = userDAO.updateInfoDAO(user);

		}catch (Exception ee) {
			System.out.println("updateInfo: "+ ee.getMessage());
			return affectedRows;

		} finally {
			if(manager != null) {
				if(affectedRows == 1) {
					manager.closeOK();

				} else {
					manager.closeError();

				}		

			}
		}

		return affectedRows;

	}

	/**
	 * 
	 * @param u
	 * @return true if user could register successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int registerNewVisitor(User user) throws SQLException, ClassNotFoundException{
		int reg = 0;
		DAOManager manager = null;		
		IUserDAO userDAO = null;
		ISequenceDAO sequenceDAO = null;
		int userId = 0;

		try {
			manager = new DAOManager();	    
			userDAO = manager.getUserDAO();
			sequenceDAO = manager.getSequencerDAO();

			reg = userDAO.registerNewVisitorDAO(user)
					
			if(reg!=0) {
				userId = sequenceDAO.getNext(ISequenceDAO.CLASS_VISITOR_NAME);		    
				user.setUserId(userId);

				reg = userDAO.registerNewVisitorDAO(user);

			} else {
				throw new ServiceException("Username is registered.");

			}

			manager.closeOK();

		} catch(DAOException ex) {
			if(manager != null) {
				manager.closeError();

			}

			throw new ServiceException("Error de acceso a la base de datos.", ex);

		}

		return reg;
	}
}


}
