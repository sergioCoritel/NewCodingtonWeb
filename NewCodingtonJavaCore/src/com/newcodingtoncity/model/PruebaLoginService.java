package com.newcodingtoncity.model;

import java.sql.SQLException;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.UserService;

public class PruebaLoginService {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		UserService user_service = new UserService();
		User user = new Visitor();

		int reg=0;

		user.setUserName("gatubela85");
		user.setPassword("123456");

		reg = user_service.login(user);

		if(reg!=0){
			System.out.println("lOGIN GUAY!!");
		}
	}

}

