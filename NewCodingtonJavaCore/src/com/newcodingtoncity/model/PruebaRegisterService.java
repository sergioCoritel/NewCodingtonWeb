package com.newcodingtoncity.model;

import java.sql.SQLException;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.UserService;

public class PruebaRegisterService {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		UserService user_service = new UserService();
		User user = new Visitor();
		
		boolean reg=false;
		boolean inf=false;

		user.setUserName("Laurasaa");
		user.setPassword("1234567890");
		user.setFirstName("Marcos");
		user.setLastName("Munioz");
		user.setDni("70.082.648-S");
		user.setEmail("lau@gmail.com");
		user.setPhoneNumber("0034665871333");
		user.setAddress("C/ Los Morales");
		user.setIsAdmin(false);
		
		reg = user_service.registerNewVisitor(user);
		
		if(reg){
			System.out.println("Nuevo Visitor Registrated");
			System.out.println(user.getAddress());
			System.out.println(user.getUserId());
		}		

		System.out.println("-------------------");
		user.setUserId(24);
		user.setAddress("C/ Soria");
		
		inf = user_service.updateInfo(user);
		
		if(inf){
			System.out.print("Info changed!");
			System.out.println(user.getAddress());
		}
		

	}

}
