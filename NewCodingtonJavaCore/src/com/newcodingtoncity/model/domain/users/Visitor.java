package com.newcodingtoncity.model.domain.users;

public class Visitor extends User {

	public Visitor(int userId, String userName, String password,
			String firstName, String lastName, String dni, String email,
			String phoneNumber, String address) {
		super(userId, userName, password, firstName, lastName, dni, email, phoneNumber,
				address, esAdmin);
	}

	public Visitor() {
		
	}

	public boolean registerNewVisitor(){
		return true;
	}
	
	public boolean registerForNewEvent(){
		return true;
	}
	
	public boolean unregistreForEvent(){
		return true;
	}
	
	
	@Override
	public void viewEvents() {
		
	}

	@Override
	public void searchEvent() {
		
		
	}

}
