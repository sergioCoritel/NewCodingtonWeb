package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;
import com.newcodingtoncity.model.helper.Encripter;

public class UserDAO implements IUserDAO{

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	/**
	 * Constructor
	 * @param connection
	 */
	public UserDAO(Connection connection) {
		this.connection = connection;
	}


	@Override
	public boolean loginDAO(User u) throws SQLException, ClassNotFoundException{

		int userId = 0;

		try{		

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = DatabaseHelper.getQuery("selec_login");
			statement = connection.prepareStatement(sql);

			statement.setString(1, u.getUserName());
			statement.setString(2, u.getPassword());

			resultSet = statement.executeQuery();

			while (resultSet.next()){
				userId = resultSet.getInt(1);
			}

			u.setUserId(userId);

		} catch (Exception ee) {
			System.out.println(" loginDAO 1: "+ ee.getMessage());
			return false;

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}
			}catch (Exception ee) {
				System.out.println(" loginDAO 2: "+ ee.getMessage());
				return false;
			}

		} 

		return true;

	}	



	@Override
	public int updatePasswordDAO(User u, String new_pass) throws SQLException, ClassNotFoundException {

		int affectedRows = 0;

		try{

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = DatabaseHelper.getQuery("change_pass");
			statement = connection.prepareStatement(sql);

			statement.setString(1, new_pass);
			statement.setInt(2, u.getUserId());

			affectedRows = statement.executeUpdate();

		}catch (Exception ee) {

			System.out.println(" updatePasswordDAO 1: "+ ee.getMessage());
			return 0;


		}finally {

			try {

				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}

			}catch (Exception ee) {
				System.out.println(" updatePasswordDAO 2: "+ ee.getMessage());
				return 0;
			}
		}

		return affectedRows;

	}

	@Override
	public int updateInfoDAO(User u) throws SQLException, ClassNotFoundException{

		int affectedRows = 0;

		return userId;
	}  
	@Override
	public boolean ValidationLogin(String user, String pass) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @param user
	 * @param old_pass
	 * @param new_pass
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean updateDAOPassword(User u, String new_pass) throws SQLException, ClassNotFoundException {

		try{

			//connection = CodingtonConnectToDB.createConnection();			
			String sql  = DatabaseHelper.getQuery("change_info");	              
			statement = connection.prepareStatement(sql);
			statement.setString(1, u.getFirstName());
			statement.setString(2, u.getLastName());
			statement.setString(3, u.getDni());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getPhoneNumber());
			statement.setString(6, u.getAddress());
			statement.setInt(7, u.getUserId());
			affectedRows = statement.executeUpdate(); 

		}catch(Exception ee) {
			System.out.println(" updateInfoDAO "+ ee.getMessage());		    	
			return affectedRows;

		}finally {

			try {

				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}

			}catch (Exception ee) {
				System.out.println(" updateInfoDAO 2: "+ ee.getMessage());
				return affectedRows;
			}
		}

		return affectedRows;
	}

	@Override
	public int registerNewVisitorDAO(User u) throws SQLException, ClassNotFoundException{

		int affectedRows = 0, userId=0;

		try{

			//connection = CodingtonConnectToDB.createConnection();			
			String sql  = DatabaseHelper.getQuery("isAcountExists");	              
			statement = connection.prepareStatement(sql);
			statement.setString(1, u.getUserName());
			statement.setString(2, u.getEmail());
			resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				userId = resultSet.getInt(1);
			}
			
			/*If userId != 0, there is a user registered with this acount*/
			if(userId!=0){
				return affectedRows;
			}
			
			
			sql  = DatabaseHelper.getQuery("registerUser");	              
			statement = connection.prepareStatement(sql);
			statement.setInt(1, u.getUserId()); /*Falta una funci�n que autoamticamente asigne un ID*/
			statement.setString(2, u.getUserName());
			statement.setString(3, u.getPassword());
			statement.setString(4, u.getFirstName());
			statement.setString(5, u.getLastName());
			statement.setString(6, u.getDni());
			statement.setString(7, u.getEmail());
			statement.setString(8, u.getPhoneNumber());
			statement.setString(9, u.getAddress());
			statement.setInt(10, 0);
			
			affectedRows = statement.executeUpdate(); 

		}catch(Exception ee) {
			System.out.println(" registerNewVisitorDAO 1: "+ ee.getMessage());		    	
			return affectedRows;

		}finally {

			try {

				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}

			}catch (Exception ee) {
				System.out.println(" registerNewVisitorDAO 2: "+ ee.getMessage());
				return affectedRows;
			}
		}

		return affectedRows;
	}

}
