package com.newcodingtoncity.model;

import java.sql.SQLException;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;

public class PruebaUpdateInfo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		User user = new Visitor();
		boolean reg;
		
		user.setUserId(2);
		user.setFirstName("Mark");
		user.setLastName("David");
		user.setDni("77554422B");
		user.setEmail("Markdavidgmail.com");
		user.setPhoneNumber("555666777");
		user.setAddress("Av/ Arturo Soria");
		
		reg = user.updateInfo();
		
		System.out.print(reg);
	}

}
