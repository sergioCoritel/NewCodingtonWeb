package com.newcodingtoncity.model.domain.users;

import java.sql.SQLException;

import com.newcodingtoncity.model.daos.UserDAO;

public abstract class User {
	
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String dni;
	private String email;
	private String phoneNumber;
	private String address;
	
	private UserDAO user_dao;
	
	
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param dni
	 * @param email
	 * @param phoneNumber
	 * @param address
	 */
	public User(int userId, String userName, String password, String firstName,
			String lastName, String dni, String email, String phoneNumber,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public User() {
		
		
	}

	public void setUserId(int id) {
		this.userId = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean login(String user, String pass) throws SQLException{
		
		return user_dao.ValidationLogin(user, pass);
	
	}
	
	public abstract void viewEvents();
	
	public abstract void searchEvent();
	
	public boolean updatePassword(){
		return false;	
	}
	
	public boolean updateInfo(){
		return false;	
	}


}
