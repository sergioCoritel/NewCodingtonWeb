package com.newcodingtoncity.model;

import java.sql.Connection;
import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;

public class PruebaUpdateInfo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection  = CodingtonConnectToDB.createConnection();
		User user = new Visitor();
		UserDAO user_dao = new UserDAO(connection);
		int reg=0;
		
		user.setUserId(4);
		/*user.setUserName("EstherGS");
		user.setPassword("1234567890");
		user.setFirstName("Esther");
		user.setLastName("Guerrero");
		user.setDni("70.082.648-S");
		user.setEmail("esther.guerrero@gmail.com");
		user.setPhoneNumber("0034665871333");
		
		user.setEsAdmin(false);*/
		user.setAddress("C/ Soria");
		
		reg = user_dao.updateInfoDAO(user);
		
		if(reg!=0){
			System.out.print("Info changed!");
		}
	}

}
