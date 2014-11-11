package com.newcodingtoncity.model;

import java.sql.SQLException;

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
		boolean reg;
		String new_pass="1234";
		
		user.setUserName("Mark");
		user.setPassword("5678");
		
		reg = user.updatePassword(new_pass);
		
		System.out.print(reg);
	}

}
