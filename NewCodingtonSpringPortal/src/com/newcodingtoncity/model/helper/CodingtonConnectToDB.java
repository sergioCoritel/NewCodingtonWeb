package es.codington.model.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CodingtonConnectToDB {

	static Connection connection ;
	private static   String url = "jdbc:mysql://localhost:3306/newcodington";
	private static String user = "root";
	private static String pass = "abcd1234";

	public static Connection createConnection() {
		try {
			Context context = new InitialContext();             
			DataSource dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/codingtondb");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public static Connection createConnectionWithoutDataSource() {
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Where is your MySQL JDBC Driver?");
	        e.printStackTrace();
	        return null;
	    }

		try {
			connection = DriverManager.getConnection(url, user, pass);
			connection.setAutoCommit(false);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return connection;
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
	
	public static void commit(Connection connection) throws RuntimeException {
		if(connection != null) {
			try {
				connection.commit();
			} catch(SQLException ex) {
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}
	}
	
	public static void rollback(Connection connection) throws RuntimeException {
		if(connection != null) {
			try {
				connection.rollback();
			} catch(SQLException ex) {
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}
	}
	
}
