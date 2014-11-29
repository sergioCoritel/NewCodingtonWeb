package com.newcodingtoncity.model.interfaces.services;

import java.sql.SQLException;

import com.newcodingtoncity.model.domain.users.User;



public interface IUserService {

	/**
	 * 
	 * @return true if login was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int login(User u) throws SQLException, ClassNotFoundException;
	
	
	/**
	 * 
	 * @param new_pass
	 * @return number of row affected if password was modificated F
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updatePassword(User u, String new_pass) throws SQLException, ClassNotFoundException;
		
	
	/**
	 * 
	 * @return number of row affected if info of user was modificated successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updateInfo(User u) throws SQLException, ClassNotFoundException;
	
	/**
	 * 
	 * @param u
	 * @return true if user could register successfully
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean registerNewVisitor(User u) throws SQLException, ClassNotFoundException;
	
}
