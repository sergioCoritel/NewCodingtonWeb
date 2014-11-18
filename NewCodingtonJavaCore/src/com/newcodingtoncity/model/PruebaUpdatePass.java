package com.newcodingtoncity.model;

import java.sql.Connection;
import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;

public class PruebaUpdatePass {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection  = CodingtonConnectToDB.createConnection();
		UserDAO user_dao = new UserDAO(connection);
		User user = new Visitor();
		
		int reg = 0;
		String new_pass="1234";
		
		user.setUserName("admin1");
		user.setPassword("password1");
		user.setUserId(2);
		
		reg = user_dao.updatePasswordDAO(user, new_pass);
		
		if(reg!=0){
			System.out.print("Password changed!");
		}
	}

}
