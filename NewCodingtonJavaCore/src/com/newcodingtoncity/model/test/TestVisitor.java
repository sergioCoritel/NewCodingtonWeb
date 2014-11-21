package com.newcodingtoncity.model.test;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.exceptions.DomainException;
import com.newcodingtoncity.model.services.UserService;


public class TestVisitor extends TestCase {
	
	private static final int USER_ID = 123;
	private static final String USERNAME = "juan.c10";
	private static final String PASWORD = "abcd1234";
	private static final String FIRST_NAME = "Juan";
	private static final String LASTNAME = "Garcia";
	private static final String DNI = "12.345.678-X";
	private static final String EMAIL = "juan.c10@gmail.com";
	private static final String PHONE_NUMBER = "00344321987";
	private static final String ADDRESS = "Calle Falsa 123";
	
	private Visitor visitor;
	

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		visitor = new Visitor(USER_ID, USERNAME, PASWORD, FIRST_NAME, LASTNAME,
				DNI, EMAIL, PHONE_NUMBER, ADDRESS);
	}
	
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testVisitor() {
		visitor = new Visitor();
	}
	
	
	@Test
	public void testGetAtributos(){

	}
	
	
	@Test
	public void testGetUserId() {
		assertEquals(USER_ID, visitor.getUserId() );
	}
	
	
	@Test
	public void testSetUserId() {
		visitor.setUserId(15);
		assertEquals(15, visitor.getUserId());
	}
	
	
	@Test
	public void testGetUserName() {
		assertEquals("El userName coincide", USERNAME, visitor.getUserName() );
	}
	
	
	@Test
	public void testSetUserName() {
		String userName;
		
		userName = "Jose105";
		visitor.setUserName(userName);
		assertEquals(userName, visitor.getUserName());
		
		userName = "JavierLopez";
		visitor.setUserName(userName);
		assertEquals(userName, visitor.getUserName());
	}
	
	
	/**
	 * Test for null and bad range of userName
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetUserNameTestException() throws DomainException {
		try{
			String userName;
			//Check userName length out of maximum range.
			userName = "AntonioAntonio10";
			visitor.setUserName(userName);
			
			//Check userName length out of minimum range.
			userName = "Toni";
			visitor.setUserName(userName);
			
			//Check userName is NULL.
			userName = null;
			visitor.setUserName(userName);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}
	
		
	@Test
	public void testGetPassword() {
		assertEquals("El pass coincide", PASWORD, visitor.getPassword() );
	}
	
	
	@Test
	public void testSetPassword() {
		String pass;
		
		pass = "123456789";
		visitor.setPassword(pass);
		assertEquals(pass, visitor.getPassword());
		
		pass = "abcdefghijk";
		visitor.setPassword(pass);
		assertEquals(pass, visitor.getPassword());
	}
	
	
	/**
	 * Test for null and bad range of password
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetPasswordTestException() throws DomainException {
		try{
			String pass;
			//Check password length out of maximum range.
			pass = "1234abcdefghijk56789";
			visitor.setPassword(pass);
			
			//Check userName length out of minimum range.
			pass = "a12z";
			visitor.setPassword(pass);
			
			//Check userName is NULL.
			pass = null;
			visitor.setPassword(pass);
			
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}
	
	
	@Test
	public void testGetFirstName() {
		assertEquals("El firstName coincide", FIRST_NAME, visitor.getFirstName() );
	}
	
	
	@Test
	public void testSetFirstName() {
		String firstName;
		
		firstName = "Daniel";
		visitor.setFirstName(firstName);
		assertEquals(firstName, visitor.getFirstName());
		
		firstName = "Luis";
		visitor.setFirstName(firstName);
		assertEquals(firstName, visitor.getFirstName());
	}
	
	
	/**
	 * Test for null and bad range of firstName
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetFirstNameTestException() throws DomainException {
		try{
			String firstName;
			//Check password length out of maximum range.
			firstName = "Daniel Garcia Lopez de Todos Los Santos";
			visitor.setFirstName(firstName);
			
			//Check userName length out of minimum range.
			firstName = "";
			visitor.setFirstName(firstName);
			
			//Check userName is NULL.
			firstName = null;
			visitor.setFirstName(firstName);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}
	
	
	@Test
	public void testGetLastName() {
		assertEquals("El lastName coincide", LASTNAME, visitor.getLastName() );
	}

	@Test
	public void testSetLastName() {
		String lastName;
		
		lastName = "Daniel";
		visitor.setLastName(lastName);
		assertEquals(lastName, visitor.getLastName());
		
		lastName = "Luis";
		visitor.setLastName(lastName);
		assertEquals(lastName, visitor.getLastName());
	}
	
	
	/**
	 * Test for null and bad range of lastName
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetLastNameTestException() throws DomainException {
		try{
			String lastName;
			//Check password length out of maximum range.
			lastName = "Daniel Garcia Lopez de Todos Los Santos";
			visitor.setLastName(lastName);
			
			//Check userName length out of minimum range.
			lastName = "";
			visitor.setLastName(lastName);
			
			//Check userName is NULL.
			lastName = null;
			visitor.setLastName(lastName);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}

	@Test
	public void testGetDni() {
		assertEquals("El dni coincide", DNI, visitor.getDni() );
	}

	@Test
	public void testSetDni() {
		String dni;
		
		dni = "71.298.438-W";
		visitor.setDni(dni);
		assertEquals(dni, visitor.getDni());
		
		dni = "13.067.155-G";
		visitor.setDni(dni);
		assertEquals(dni, visitor.getDni());
	}
	
	
	/**
	 * Test for null and bad range of lastName
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetDniTestException() throws DomainException {
		try{
			String dni;
			//Check bad format.
			dni = "71298438w";
			visitor.setDni(dni);
			
			//Check bad range-23.
			dni = "71298438t";
			visitor.setDni(dni);
			
			//Check NULL.
			dni = null;
			visitor.setDni(dni);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}

	@Test
	public void testGetEmail() {
		assertEquals("El email coincide", EMAIL, visitor.getEmail() );
	}

	@Test
	public void testSetEmail() {
		String email;
		
		email = "codington@accenture.com";
		visitor.setEmail(email);
		assertEquals(email, visitor.getEmail());
		
		email = "codingtonCity@gmail.com";
		visitor.setEmail(email);
		assertEquals(email, visitor.getEmail());
	}
	
	
	/**
	 * Test for null and bad range of email
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetEmailTestException() throws DomainException {
		try{
			String email;
			//Check bad format.
			email = "proof@accenture";
			visitor.setEmail(email);
			
			//Check bad format.
			email = "proof$codington€City@accenture.com";
			visitor.setEmail(email);
			
			//Check NULL.
			email = null;
			visitor.setEmail(email);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}
	
	
	@Test
	public void testGetPhoneNumber() {
		assertEquals("El phoneNumber coincide", PHONE_NUMBER, visitor.getPhoneNumber() );
	}

	@Test
	public void testSetPhoneNumber() {
		String phoneNumber;
		
		phoneNumber = "0034987654321";
		visitor.setPhoneNumber(phoneNumber);
		assertEquals(phoneNumber, visitor.getPhoneNumber());
		
		phoneNumber = "0029555666777";
		visitor.setPhoneNumber(phoneNumber);
		assertEquals(phoneNumber, visitor.getPhoneNumber());
	}
	
	
	/**
	 * Test for null and bad range of phoneNumber
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetPhoneNumberTestException() throws DomainException {
		try{
			String phoneNumber;
			//Check bad format.
			phoneNumber = "999888777";
			visitor.setPhoneNumber(phoneNumber);
			
			//Check bad format.
			phoneNumber = "+34999888777";
			visitor.setPhoneNumber(phoneNumber);
			
			//Check NULL.
			phoneNumber = null;
			visitor.setPhoneNumber(phoneNumber);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}

	@Test
	public void testGetAddress() {
		assertEquals("El address coincide", ADDRESS, visitor.getAddress() );
	}

	@Test
	public void testSetAddress() {
		String address;
		
		address = "Avenida Pavlo VI";
		visitor.setAddress(address);
		assertEquals(address, visitor.getAddress());
	}
	
	
	/**
	 * Test for null and bad range of phoneNumber
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetAddressTestException() throws DomainException {
		try{
			String address;
			//Check bad format.
			address = "Avenida Pablo VI, numero2, Piso 4ºC";
			visitor.setAddress(address);
			
			//Check bad format.
			address = "";
			visitor.setAddress(address);
			
			//Check NULL.
			address = null;
			visitor.setAddress(address);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}

	/*
	@Test
	public void testViewEvents() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchEvent() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testRegisterNewVisitor() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testRegisterForNewEvent() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testUnregistreForEvent() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testUserIntStringStringStringStringStringStringStringString() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testUser() {
		fail("Not yet implemented");
	}
	
	*/
	@Test
	public void testLogin() throws SQLException, ClassNotFoundException {

		UserService user_service = new UserService();
		User user = new Visitor();

		int reg=0;

		user.setUserName("Gominolaa");
		user.setPassword("1234567890");

		reg = user_service.login(user);
		
		assertEquals(user.getUserId(), reg);

	}
	
	
	@Test
	public void testUpdatePassword() throws SQLException, ClassNotFoundException {
		
		UserService user_service = new UserService();
		User user = new Visitor();

		boolean reg = false;
		String new_pass="1234";

		user.setUserId(5);
		user.setUserName("Gominola");
		//user.setPassword("1234567890");

		reg = user_service.updatePassword(user, new_pass);
		
		assertTrue(reg);
	}
	
	
	@Test
	public void testUpdateInfo() throws SQLException, ClassNotFoundException {

		UserService user_service = new UserService();
		User user = new Visitor();

		boolean inf=false;
		
		user.setUserId(24);
		user.setAddress("C/ Soria");
		
		inf = user_service.updateInfo(user);
		
		assertTrue(inf);
		
	}
	
	
	@Test
	public void testRegister() throws SQLException, ClassNotFoundException {

		UserService user_service = new UserService();
		User user = new Visitor();

		boolean reg=false;
		
		user.setUserName("MiguelAngel");
		user.setPassword("1234567890");
		user.setFirstName("Miguel Angel");
		user.setLastName("Moreno");
		user.setDni("70.082.648-S");
		user.setEmail("miguelangel@gmail.com");
		user.setPhoneNumber("0034665871333");
		user.setAddress("C/ Fuente vieja 6");
		user.setEsAdmin(false);
		
		reg = user_service.registerNewVisitor(user);
		
		assertTrue(reg);
		
	}
	
	
}
