package com.newcodingtoncity.model.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * HELPER class to handle DATACONNECTIVITY with CODINGTONDB in MYSQL
 */
public class CodingtonConnectToDB {
	
	private static String dbUser = "root";
	private static String dbPassword = "abcd1234";
	
	// Opening connection with MYSQL database
	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/codingtondb", dbUser, dbPassword);
		return connection;
	}

	// Closing connection
	public static void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
