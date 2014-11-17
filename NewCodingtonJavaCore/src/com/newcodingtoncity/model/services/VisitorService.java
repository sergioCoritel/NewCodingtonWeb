package com.newcodingtoncity.model.services;

public class VisitorService {

//	private UserDAO user_dao = new UserDAO();
	/* falta devovler generar y devovler una sesion en lugar de un boolean*/
	/**
	 * 
	 * @return true if login was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	/*public boolean login() throws SQLException, ClassNotFoundException{
		user_dao = new UserDAO();
		return user_dao.Login(this);
	
	}*/
	
	
	/*Seguimos devolviendo la sesion*/
	/**
	 * 
	 * @param new_pass
	 * @return number of row affected if info was modificated
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	/*public boolean updatePassword(String new_pass) throws SQLException, ClassNotFoundException{
		user_dao = new UserDAO();
		if(user_dao.updatePassword(this, new_pass)!=0){
			return true;
		}
		
		return false;
	}*/
	
	/**
	 * 
	 * @return number of row affected if password was modificated 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	/*public boolean updateInfo() throws SQLException, ClassNotFoundException{
		user_dao = new UserDAO();
		if(user_dao.updateInfo(this)!=0){
			return true;
		}
		
		return false;	
	}*/
}
