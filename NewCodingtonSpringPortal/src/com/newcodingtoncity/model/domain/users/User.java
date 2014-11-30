package com.newcodingtoncity.model.domain.users;


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
	private boolean isAdmin;


	/**
	 * Class User constructor
	 * 
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
		this.userId = userId++;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isAdmin = esAdmin;
	}


	/**
	 * Class User constructor
	 */
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
		this.isAdmin = false;
	}


	/**
	 * Return the userId associated with this instance of User.
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * Sets the id of the specified instance of User
	 * @param the new id
	 */
	public void setUserId(int id) {
		this.userId = id;
	}


	/**
	 * Return the userName associated with this instance of User.
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * Sets the userName of the specified instance of User, check the
	 * userName correct.
	 * @param the new userName
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}


	/**
	 * Return the password associated with this instance of User.
	 * @return the password

	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Sets the password of the specified instance of User, check the
	 * password correct.
	 * @param the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * Return the firstName associated with this instance of User.
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Sets the firstName of the specified instance of User, check the
	 * firstName correct.
	 * @param the new firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Return the lastName associated with this instance of User.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Sets the lastName of the specified instance of User, check the
	 * lastName correct.
	 * @param the new lastName
	 */
	public void setLastName(String lastName) {
			this.lastName = lastName;
	}


	/**
	 * Return the dni associated with this instance of User.
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}


	/**
	 * Sets the dni of the specified instance of User, check the
	 * dni correct.
	 * @param the new dni
	 */
	public void setDni(String dni){
		this.dni = dni;
	}


	/**
	 * Return the email associated with this instance of User.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Sets the email of the specified instance of User, check the
	 * email correct.
	 * @param the new email
	 */
	public void setEmail(String email) {
			this.email = email;
	}


	/**
	 * Return the phoneNumber associated with this instance of User.
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * Sets the phoneNumber of the specified instance of User, check the
	 * phoneNumber correct.
	 * @param the new phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			}


	/**
	 * Return the address associated with this instance of User.
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * Sets the address of the specified instance of User, check the
	 * address correct.
	 * @param the new address
	 */
	public void setAddress(String address) {
			this.address = address;
			}

	public boolean getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
