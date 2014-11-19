package com.newcodingtoncity.model;

import java.sql.SQLException;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.UserService;

public class PruebaUpdatePassService {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		UserService user_service = new UserService();
		User user = new Visitor();

		boolean reg = false;
		String new_pass="1234";

		user.setUserId(5);
		user.setUserName("Gominola");
		//user.setPassword("1234567890");

		reg = user_service.updatePassword(user, new_pass);

		if(reg){
			System.out.print("Password changed!");
		}
	}

}
