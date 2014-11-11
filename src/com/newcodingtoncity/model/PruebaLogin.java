package com.newcodingtoncity.model;

import java.sql.SQLException;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;

public class PruebaLogin {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		User user = new Visitor();
		boolean reg;
		
		user.setUserName("Mark");
		user.setPassword("5678");
		
		reg = user.login();
		
		System.out.print(reg);
	}

}
