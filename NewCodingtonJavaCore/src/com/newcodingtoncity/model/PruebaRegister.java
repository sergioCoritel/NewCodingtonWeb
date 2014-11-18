package com.newcodingtoncity.model;

import java.sql.Connection;
import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;

public class PruebaRegister {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection  = CodingtonConnectToDB.createConnection();
		UserDAO user_dao = new UserDAO(connection);
		User user = new Visitor();
		boolean reg=false;
		int inf=0;

		user.setUserName("EstherGsdhsfgh");
		user.setPassword("1234567890");
		user.setFirstName("Esther");
		user.setLastName("Guerrero");
		user.setDni("70.082.648-S");
		user.setEmail("estherguerr@gmail.com");
		user.setPhoneNumber("0034665871333");
		user.setAddress("C/ Los Morales");
		user.setEsAdmin(false);
		
		reg = user_dao.registerNewVisitorDAO(user);
		if(reg){
			System.out.print("Nuevo Visitor Registrated");
		}		
		
		user.setUserId(6);
		user.setAddress("C/ Soria");
		inf = user_dao.updateInfoDAO(user);
		
		if(inf!=0){
			System.out.print("Info changed!");
		}
		
	}
}
