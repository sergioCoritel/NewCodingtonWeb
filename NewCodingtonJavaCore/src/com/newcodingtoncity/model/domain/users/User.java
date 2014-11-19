package com.newcodingtoncity.model.domain.users;

import com.newcodingtoncity.model.test.ValidateUser;
import com.newcodingtoncity.model.exceptions.DomainException;


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
		User.esAdmin = esAdmin;
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
		User.esAdmin = false;
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
		if(ValidateUser.validateSetUserName(userName))
			this.userName = userName;
		else
			throw new DomainException("UserName NO VALID: username can't have spaces and it lengh must be betwee 6 and 12");
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
		if(ValidateUser.validatePassword(password))
			this.password = password;
		else
			throw new DomainException("Format Password incorrect (digits between 6 to 15)");
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
		if(ValidateUser.validateString(firstName))
			this.firstName = firstName;
		else
			throw new DomainException("Format FirstName incorrect (digits between 1 to 30)");
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
		if(ValidateUser.validateString(lastName))
			this.lastName = lastName;
		else
			throw new DomainException("Format LastName incorrect (digits between 1 to 30)");
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
		if(ValidateUser.validateSetDNI(dni))
			this.dni = dni;
		else
			throw new DomainException("DNI NO VALID (must be in the form XX.XXX.XXX-X, or DNI badly inserted)");
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
		if(ValidateUser.validateSetEmail(email))
			this.email = email;
		else
			throw new DomainException("Email NO VALID: email must have leters, numbers, and specials characters ('.' and ' _')");
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
		if(ValidateUser.validateSetPhoneNumber(phoneNumber))
			this.phoneNumber = phoneNumber;
		else
			throw new DomainException("Phone Number NO VALID:" +
					"\n must be in the form internacional (eg. in Spain 0034 + your number)" +
					"\n and min 10digits or max 20digits");
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
		if(ValidateUser.validateString(address))
			this.address = address;
		else
			throw new DomainException("Format Address incorrect (digits between 1 to 30)");
	}
	
	
	/* falta devovler generar y devovler una sesion en lugar de un boolean*/
	
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
