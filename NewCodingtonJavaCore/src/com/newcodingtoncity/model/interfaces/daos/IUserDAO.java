package com.newcodingtoncity.model.interfaces.daos;

import java.sql.SQLException;

import com.newcodingtoncity.model.domain.users.User;

public interface IUserDAO {
	
	public boolean ValidationLogin(User u) throws SQLException, ClassNotFoundException;
	public int updateDAOPassword(User u, String new_pass) throws SQLException, ClassNotFoundException;
	public int updateDAOInfo(User u) throws SQLException, ClassNotFoundException;
}
