package com.newcodingtoncity.model;

import java.sql.Connection;
import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;

public class PruebaLogin {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection connection  = CodingtonConnectToDB.createConnection();
		UserDAO user_dao = new UserDAO(connection);
		User user = new Visitor();
		int reg=0;

		user.setUserName("admin1");
		user.setPassword("password1");
		
		reg = user_dao.loginDAO(user);
		
		if(reg!=0){
			System.out.println("lOGIN GUAY!!");
		}
	}

}
