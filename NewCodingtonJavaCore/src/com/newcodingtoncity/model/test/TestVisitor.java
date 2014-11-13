package com.newcodingtoncity.model.test;

import org.junit.Test;


import com.newcodingtoncity.model.domain.users.Visitor;

import junit.framework.TestCase;

/**
 * Testcase for demonstrate unit test for Visitor of NewCodington
 */
public class TestVisitor extends TestCase {
	
	private Visitor visitor;

	protected void setUp() throws Exception {
		super.setUp();
		visitor = new Visitor(123, "juan.c10", "1234", "Juan", "garcia",
				"12345678X", "juan.c10@gmail.com", "654321987", "Calle Falsa 123");
	}
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	/*@Before
	public void inicialice throws Exception {
		visitor = new Visitor(123, "juan.c10", "1234", "Juan", "garcia",
				"12345678X", "juan.c10@gmail.com", "654321987", "Calle Falsa 123");
	}
	
	@After
	public void finalice throws Exception {
		visitor = new Visitor(123, "juan.c10", "1234", "Juan", "garcia",
				"12345678X", "juan.c10@gmail.com", "654321987", "Calle Falsa 123");
	}*/


	
	
	@Test
	public void testVisitorNotNull(){
		assertNotNull("No deberia apuntar a null", visitor);
	}
	
	@Test
	public void testAtributosNotNull(){
		assertEquals("El userId coincide", 123, visitor.getUserId() );
		assertEquals("El userName coincide", "juan.c10", visitor.getUserName() );
		assertEquals("El pass coincide", "1234", visitor.getPassword() );
		assertEquals("El firstName coincide", "Juan", visitor.getFirstName() );
		assertEquals("El lastName coincide", "garcia", visitor.getLastName() );
		assertEquals("El dni coincide", "12345678X", visitor.getDni() );
		assertEquals("El email coincide", "juan.c10@gmail.com", visitor.getEmail() );
		assertEquals("El phoneNumber coincide", "654321987", visitor.getPhoneNumber() );
		assertEquals("El address coincide", "Calle Falsa 123", visitor.getAddress() );
	}
	
} //KitSuiteTest