package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;


public class UserDAO implements IUserDAO {


	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	/**
	 * 
	 * @param user
	 * @param pass
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public boolean ValidationLogin(User u) throws SQLException, ClassNotFoundException{

		int userId = 0;

		try{		    		

			connection = CodingtonConnectToDB.createConnection();
			String login  = DatabaseHelper.getQuery("selec_login");
			statement = connection.prepareStatement(login);

			statement.setString(1, u.getUserName());
			statement.setString(2, u.getPassword());

			resultSet = statement.executeQuery();
		
			while (resultSet.next()){
				userId = resultSet.getInt(1);
			}
	
			u.setUserId(userId);

		} catch (Exception ee) {
			System.out.println("ValidationLogin1: "+ ee.getMessage());
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
				System.out.println(" ValidationLogin2: "+ ee.getMessage());
				return false;
			}

		} 

		return true;

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
	@Override
	public int updateDAOPassword(User u, String new_pass) throws SQLException, ClassNotFoundException {

		int affectedRows = 0;
	
		try{

			connection = CodingtonConnectToDB.createConnection();
			String login  = DatabaseHelper.getQuery("change_pass");
			statement = connection.prepareStatement(login);

			statement.setString(1, new_pass);
			statement.setInt(2, u.getUserId());

			affectedRows = statement.executeUpdate();
		    
		}catch (Exception ee) {
			
			System.out.println(" updateDAOPassword 1: "+ ee.getMessage());
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
				System.out.println(" updateDAOPassword 2: "+ ee.getMessage());
				return 0;
			}
		}
		
		return affectedRows;

	}


	/**
	 * 
	 * @param u
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	public int updateDAOInfo(User u) throws SQLException, ClassNotFoundException{

		int affectedRows = 0;
		
		try{

			connection = CodingtonConnectToDB.createConnection();			
			String select  = DatabaseHelper.getQuery("change_info");	              
			statement = connection.prepareStatement(select);
			statement.setString(1, u.getFirstName());
			statement.setString(2, u.getLastName());
			statement.setString(3, u.getDni());
			statement.setString(4, u.getEmail());
			statement.setString(5, u.getPhoneNumber());
			statement.setString(6, u.getAddress());
			statement.setInt(7, u.getUserId());
			affectedRows = statement.executeUpdate(); 

		}catch(Exception ee) {
			System.out.println(" updateDAOInfo "+ ee.getMessage());		    	
			return 0;

		}

		return affectedRows;
	}

}
