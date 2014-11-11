package com.newcodingtoncity.model;

import java.sql.SQLException;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;

public class Prueba {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		User user = new Visitor();
		boolean reg;
		String u = "Mark";
		String p = "5678";
		
		reg = user.login(u, p);
		
		System.out.print(reg);
	}

}
