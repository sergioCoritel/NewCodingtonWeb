package es.codington.model.services;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.exceptions.DAOException;
import com.newcodingtoncity.model.exceptions.ServiceException;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;
import com.newcodingtoncity.model.interfaces.services.IUserService;

public class UserService implements IUserService{


	//private Connection connection = null;
	private ServletContext context = null;
	
	
	/**
	 * 
	 * @return true if login was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	
	
	
	public int login(User user) throws SQLException, ClassNotFoundException{
		
		int userId = 0;
		DAOManager manager = null;
		IUserDAO userDAO = null;
		
		try {
			
			manager = new DAOManager(context);
			userDAO = manager.getUserDAO();
			userId = userDAO.loginDAO(user);

			manager.closeConnectionWithCommit();
			
		} catch(DAOException e) {
			if(manager != null) {
				manager.closeConnectionWithRollback();

			}

			throw new ServiceException("Error in data base.", e);

		}
		
		user.setUserId(userId);
		return userId;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	/**
	 * 
	 * @param new_pass
	 * @return number of row affected if password was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updatePassword(User user, String new_pass) throws SQLException, ClassNotFoundException{

		boolean pass = false;
		DAOManager manager = null;
		IUserDAO userDAO = null;

		try {
			
			manager = new DAOManager(context);
			userDAO = manager.getUserDAO();
			pass = userDAO.updatePasswordDAO(user, new_pass);

		}catch (Exception ee) {
			System.out.println("updatePassword: "+ ee.getMessage());
			return false;

		} finally {
			if(manager != null) {
				if(pass) {
					manager.closeConnectionWithCommit();

				} else {
					manager.closeConnectionWithRollback();

				}
			}

		}

		if(pass){
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

		int affectedRows = 0;
		DAOManager manager = null;
		IUserDAO userDAO = null;

		try {

			manager = new DAOManager(context);
			userDAO = manager.getUserDAO();    
			affectedRows = userDAO.updateInfoDAO(user);

		}catch (Exception ee) {
			System.out.println("updateInfo: "+ ee.getMessage());
			return false;

		} finally {
			if(manager != null) {
				if(affectedRows == 1) {
					manager.closeConnectionWithCommit();
			
				} else {
					manager.closeConnectionWithRollback();
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


		try {
			manager = new DAOManager(context);	    
			userDAO = manager.getUserDAO();

			reg = userDAO.registerNewVisitorDAO(user);

			if(reg) {
				manager.closeConnectionWithCommit();
			}
			else{
				throw new ServiceException("Acount Exists: Choose new username (nickname) or email.");
			}	

		} catch(DAOException e) {
			if(manager != null) {
				manager.closeConnectionWithRollback();

			}

			throw new ServiceException("Error in data base.", e);

		}

		return reg;
	}




}


