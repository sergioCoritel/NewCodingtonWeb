package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.exceptions.DAOException;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;

public class UserDAO implements IUserDAO{

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	DAOManager manager = null;

	/**
	 * Constructor
	 * @param connection
	 */
	public UserDAO(Connection connection) {
		this.connection = connection;
	}


	@Override
	public int loginDAO(User u) throws SQLException, ClassNotFoundException{

		int userId = 0;		

		try{		
		
			String sql  = DatabaseHelper.getQuery("selec_login");
			statement = connection.prepareStatement(sql);

			statement.setString(1, u.getUserName());
			statement.setString(2, u.getPassword());

			resultSet = statement.executeQuery();

			while (resultSet.next()){
				userId = resultSet.getInt(1);
			}

			u.setUserId(userId);
	
		}catch (Exception ee) {
			System.out.println(" updateInfoDAO 1: "+ ee.getMessage());
			return userId;

	
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

				/*if (connection != null) {
					manager.closeConnectionWithCommit();
					connection = null;
				}*/
				
			}catch (Exception ee) {
				System.out.println(" loginDAO: "+ ee.getMessage());
				return userId;
			}

		} 

		return userId;

	}	



	
	@Override
	public int updateInfoDAO(User u) throws SQLException, ClassNotFoundException{

		int affectedRows = 0;

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

		}catch (Exception ee) {
			System.out.println(" updateInfoDAO 1: "+ ee.getMessage());
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
				
				/*if (connection != null) {
					manager.closeConnectionWithCommit();
					connection = null;
				}*/

			}catch (Exception ee) {
				System.out.println(" updateInfoDAO 2: "+ ee.getMessage());
				return affectedRows;
			}
		}

		return affectedRows;
	}  
	
	

	@Override
	public boolean updatePasswordDAO(User u, String new_pass) throws SQLException, ClassNotFoundException {

		int affectedRows = 0;

		try{

			//connection = CodingtonConnectToDB.createConnection();
			//connection.setAutoCommit(false);
			String sql  = DatabaseHelper.getQuery("change_pass");
			statement = connection.prepareStatement(sql);

			statement.setString(1, new_pass);
			statement.setInt(2, u.getUserId());

			affectedRows = statement.executeUpdate();

		}catch (Exception ee) {
			System.out.println(" updatePasswordDAO 1: "+ ee.getMessage());
			return false;

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

				/*if (connection != null) {
					manager.closeConnectionWithCommit();
					connection = null;
				}*/
				
			}catch (Exception ee) {
				System.out.println(" updatePasswordDAO 2: "+ ee.getMessage());
				return false;
			}
		}

		if(affectedRows==1){
			return true;
		}
		else{
			return false;
		}

	}
	
	

	@Override
	public boolean registerNewVisitorDAO(User u) throws SQLException, ClassNotFoundException{

		int affectedRows = 0, userId=0;

		try{

			//connection = CodingtonConnectToDB.createConnection();
			//connection.setAutoCommit(false);
			
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
				throw new DAOException("Acount Exists: Username or email is registrared in date base");
			}


			sql  = DatabaseHelper.getQuery("registerUser");	              
			statement = connection.prepareStatement(sql);
			statement.setString(1, u.getUserName());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getFirstName());
			statement.setString(4, u.getLastName());
			statement.setString(5, u.getDni());
			statement.setString(6, u.getEmail());
			statement.setString(7, u.getPhoneNumber());
			statement.setString(8, u.getAddress());
			statement.setInt(9, 0);

			affectedRows = statement.executeUpdate(); 

		}catch (Exception ee) {
			System.out.println(" registerNewVisitorDAO 1: "+ ee.getMessage());
			return false;

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

				/*if (connection != null) {
					manager.closeConnectionWithCommit();
					connection = null;
				}*/

			}catch (Exception ee) {
				System.out.println(" registerNewVisitorDAO 2: "+ ee.getMessage());
				return false;
			}
		}

		if(affectedRows!=0){
			return true;
		}
		else{
			return false;
		}
	}

}
