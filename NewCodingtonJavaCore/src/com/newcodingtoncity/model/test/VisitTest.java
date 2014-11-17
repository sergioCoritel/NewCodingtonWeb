package com.newcodingtoncity.model.test;

import org.junit.Test;

import com.newcodingtoncity.model.domain.users.Visitor;

import junit.framework.TestCase;

public class VisitTest extends TestCase {
	
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
	

	protected void setUp() throws Exception {
		super.setUp();
		visitor = new Visitor(USER_ID, USERNAME, PASWORD, FIRST_NAME, LASTNAME,
				DNI, EMAIL, PHONE_NUMBER, ADDRESS);
	}
	
	
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
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetUserName() {
		assertEquals("El userName coincide", USERNAME, visitor.getUserName() );
	}
	
	
	@Test
	public void testSetUserName() {
		String userName;
		
		//Check minimum length for userName(6).
		userName = "Jose";
		visitor.setUserName(userName);
		assertEquals(userName, visitor.getUserName());
		
		//Check maximum length for userName(12).
		userName = "JavierJavier";
		visitor.setUserName(userName);
		assertEquals(userName, visitor.getUserName());
		
		/*//Check userName length out of maximum range.
		userName = "JavierJavier10";
		this.checkSet(userName, USERNAME);
		
		//Check userName length out of minimum range.
		userName = "Javi";
		this.checkSet(userName, USERNAME);
		
		//Check userName is NULL.
		userName = null;
		this.checkSet(userName, USERNAME);*/
	}
	
	
	@Test
	public void testGetPassword() {
		assertEquals("El pass coincide", PASWORD, visitor.getPassword() );
	}
	
	
	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetFirstName() {
		assertEquals("El firstName coincide", FIRST_NAME, visitor.getFirstName() );
	}
	
	
	@Test
	public void testSetFirstName() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetLastName() {
		assertEquals("El lastName coincide", LASTNAME, visitor.getLastName() );
	}

	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDni() {
		assertEquals("El dni coincide", DNI, visitor.getDni() );
	}

	@Test
	public void testSetDni() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		assertEquals("El email coincide", EMAIL, visitor.getEmail() );
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals("El phoneNumber coincide", PHONE_NUMBER, visitor.getPhoneNumber() );
	}

	@Test
	public void testSetPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddress() {
		assertEquals("El address coincide", ADDRESS, visitor.getAddress() );
	}

	@Test
	public void testSetAddress() {
		fail("Not yet implemented");
	}

	
	
	
	
	
	
	
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
	
	
	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testUpdatePassword() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testUpdateInfo() {
		fail("Not yet implemented");
	}
	
	
}
