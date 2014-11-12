package com.newcodingtoncity.model.interfaces.daos;

import java.sql.SQLException;

public interface IUserDAO {
	
	public boolean ValidationLogin(String user, String pass) throws SQLException;

}
