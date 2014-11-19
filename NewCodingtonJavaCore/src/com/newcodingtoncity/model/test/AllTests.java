package com.newcodingtoncity.model.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses( { TestVisitor.class, TestEvent.class})
public class AllTests {
	
	/**
	 * Execute all tests.
	 * @param args
	 */
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main("com.newcodingtoncity.model.test.AllTest");
	}

} 