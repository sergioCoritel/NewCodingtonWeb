package com.newcodingtoncity.model;

import java.sql.Connection;
import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;

public class PruebaRegister {

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

		user.setFirstName("Esther");
		user.setLastName("Guerrero");
		user.setDni("70082648S");
		user.setEmail("esther.guerrero@gmail.com");
		user.setPhoneNumber("665871333");
		user.setAddress("C/ Los Morales");
		
		reg = user_dao.registerNewVisitorDAO(user);
		
		System.out.print(reg);
	}
}
