package com.newcodingtoncity.model;

import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;

public class PruebaUpdatePass {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		User user = new Visitor();
		UserDAO user_dao = new UserDAO();
		int reg = 0;
		String new_pass="1234";
		
		user.setUserName("Mark");
		user.setPassword("1234");
		user.setUserId(2);
		
		reg = user_dao.updatePassword(user, new_pass);
		
		System.out.print(reg);
	}

}
