package com.newcodingtoncity.model.helper;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * HELPER class to handle DATACONNECTIVITY with CODINGTONDB in MYSQL
 */
public class CodingtonConnectToDB {
	
	static Connection con ;

	//	This source code tries to establish a connection to a MySQL server
	//	and displays a message concerning the error if connection fails
	
	//Following method creates a connection and returns it
	public static Connection createConnection() {

		try {
			String url = "jdbc:mysql://localhost/newcodington";
			String user = "root";
			String pass = "abcd1234";
			
			//Loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Obtaining a connection using DriverManager class
			con = DriverManager.getConnection(url, user, pass);
	
						
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	
	public static void main(String[] args) {
		createConnection();
		System.out.println("Connection obtained - " + con);
	}
}
