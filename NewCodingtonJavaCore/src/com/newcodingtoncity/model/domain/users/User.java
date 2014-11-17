package com.newcodingtoncity.model.domain.users;

/**
 * 
 * @author Esther Guerrero Santana
 *
 */
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
	protected static boolean esAdmin;

	
	
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
			String address, boolean esAdmin) {
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
		User.esAdmin = esAdmin;
	}
	
	public User() {	
		this.userId = 0;
		this.userName ="";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.dni = "";
		this.email = "";
		this.phoneNumber = "";
		this.address = "";
		User.esAdmin = false;
	}

	/**
	 * 
	 * @return id
	 */
	public int getUserId() {
		return userId;
	}
	
	
	/**
	 * 
	 * @param id
	 */
	public void setUserId(int id) {
		this.userId = id;
	}
	
	/**
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 
	 * @return esAdmin
	 */
	public boolean isEsAdmin() {
		return esAdmin;
	}

	/**
	 * 
	 * @param esAdmin
	 */
	public void setEsAdmin(boolean esAdmin) {
		User.esAdmin = esAdmin;
	}
	
	
	public abstract void viewEvents();
	
	public abstract void searchEvent();


}
