package com.newcodingtoncity.model;

import java.sql.Connection;
import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;

public class PruebaUpdateInfo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		User user = new Visitor();
		UserDAO user_dao = new UserDAO(connection);
		int reg=0;
		
		user.setUserId(2);
		user.setFirstName("Mark");
		user.setLastName("David");
		user.setDni("77554422B");
		user.setEmail("Markdavidgmail.com");
		user.setPhoneNumber("555666777");
		user.setAddress("Av/ Arturo Soria");
		
		reg = user_dao.updateInfoDAO(user);
		
		System.out.print(reg);
	}

}
