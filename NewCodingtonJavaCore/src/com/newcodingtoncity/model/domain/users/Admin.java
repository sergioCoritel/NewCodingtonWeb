package com.newcodingtoncity.model.domain.users;

public class Admin extends User {

	public Admin(int userId, String userName, String password,
			String firstName, String lastName, String dni, String email,
			String phoneNumber, String address) {
		super(userId, userName, password, firstName, lastName, dni, email, phoneNumber,
				address, esAdmin);
	}

	public void insertEvent(){
		
	}
	
	public void updateEvent(){
		
	}
	
	public void deleteEvent(){
		
	}
	
	public void refresh(){
		
	}
	
	@Override
	public void viewEvents() {
		
	}

	@Override
	public void searchEvent() {
		
	}


}
