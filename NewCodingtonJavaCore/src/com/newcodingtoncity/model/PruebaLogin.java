package com.newcodingtoncity.model;

import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;

public class PruebaLogin {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		UserDAO user_dao = new UserDAO();
		User user = new Visitor();
		boolean reg=false;

		user.setUserName("Mark");
		user.setPassword("5678");
		
		reg = user_dao.login(user);
		
		System.out.println(reg);
	}

}
