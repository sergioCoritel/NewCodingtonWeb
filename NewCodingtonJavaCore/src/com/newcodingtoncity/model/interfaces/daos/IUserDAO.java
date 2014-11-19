package com.newcodingtoncity.model.interfaces.daos;

import java.sql.SQLException;
import com.newcodingtoncity.model.domain.users.User;

public interface IUserDAO {

	/**
	 * 
	 * @param u
	 * @return true if validation is correct
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int loginDAO(User u) throws SQLException, ClassNotFoundException;
	
	/**
	 * 
	 * @param u
	 * @param new_pass
	 * @return number of row affected if password was modificated 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updatePasswordDAO(User u, String new_pass) throws SQLException, ClassNotFoundException;
	
	/**
	 * 
	 * @param u
	 * @return number of row affected if info was modificated 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateInfoDAO(User u) throws SQLException, ClassNotFoundException;
	
	/**
	 * 
	 * @param u
	 * @return true if user could register
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean registerNewVisitorDAO(User u) throws SQLException, ClassNotFoundException;
}
