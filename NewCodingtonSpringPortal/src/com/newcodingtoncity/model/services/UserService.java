package com.newcodingtoncity.model.services;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.exceptions.DAOException;
import com.newcodingtoncity.model.exceptions.ServiceException;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;
import com.newcodingtoncity.model.interfaces.services.IUserService;

public class UserService implements IUserService{


	private IUserDAO userDAO;

	public UserService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(  "beans.xml");  
		DAOManager daoManager = (DAOManager) ctx.getBean("daoManager");
		this.userDAO = daoManager.getUserDAO();
	}
	
	
	public User login(User user) throws SQLException, ClassNotFoundException{	
	 return userDAO.loginDAO(user);
	}

	/**
	 * 
	 * @param new_pass
	 * @return number of row affected if password was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updatePassword(User user, String new_pass) throws SQLException, ClassNotFoundException{
		return userDAO.updatePasswordDAO(user, new_pass);
	}


	/**
	 * 
	 * @return number of row affected if info of user was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updateInfo(User user) throws SQLException, ClassNotFoundException{
		return userDAO.updateInfoDAO(user) == 1;
	}

	/**
	 * 
	 * @param u
	 * @return true if user could register successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean registerNewVisitor(User user) throws SQLException, ClassNotFoundException{	
		return  userDAO.registerNewVisitorDAO(user);
	}

}


