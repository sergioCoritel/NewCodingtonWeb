package com.newcodingtoncity.model.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CodingtonConnectToDB {

	static Connection connnection ;
	private static   String url = "jdbc:mysql://localhost:3306/newcodington";
	private static String user = "root";
	private static String pass = "abcd1234";

	public static Connection createConnection() {
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Where is your MySQL JDBC Driver?");
	        e.printStackTrace();
	        return null;
	    }

		try {
			connnection = DriverManager.getConnection(url, user, pass);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return connnection;
	}

	public static void closeConnection(Connection connection) throws RuntimeException {
		if(connection != null) {
			try {
				connection.close();
			} catch(SQLException ex) {
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}
	}
	
	public static void main(String[] args){
		createConnection();
		System.out.println(connnection);
	}
}
