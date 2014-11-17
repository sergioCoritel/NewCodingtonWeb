package com.newcodingtoncity.model.interfaces.services;

import java.sql.SQLException;

public interface IVisitorService {

	/* falta devovler generar y devovler una sesion en lugar de un boolean*/
	/**
	 * 
	 * @return true if login was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean login() throws SQLException, ClassNotFoundException;
	
	
	/*Seguimos devolviendo la sesion*/
	/**
	 * 
	 * @param new_pass
	 * @return number of row affected if info was modificated
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updatePassword(String new_pass) throws SQLException, ClassNotFoundException;
		
	
	/**
	 * 
	 * @return number of row affected if password was modificated 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updateInfo() throws SQLException, ClassNotFoundException;

}
	
