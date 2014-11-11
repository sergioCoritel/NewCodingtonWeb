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
	    public boolean ValidationLogin(User u) throws SQLException, ClassNotFoundException{
	    	
	    	int userId = 0;
	    
			/*Return userId*/
			userId = returnUserId(u);                
  
			if(userId<=0){
				System.out.println("User does not exit in ddbb");
				return false;
			}
			
			return true;
	    	
	    }	
	    
	    /**
	     * 
	     * @param user
	     * @param pass
	     * @return userId
	     * @throws SQLException
	     * @throws ClassNotFoundException
	     */
	    public int returnUserId(User u) throws SQLException, ClassNotFoundException{
	    	
	    	int userId = -1;
	    	
	    	try{	
	    		
		    	connection = CodingtonConnectToDB.createConnection();			
	            String select  = DatabaseHelper.getQuery("selec_login");	              
	            statement = connection.prepareStatement(select);
	            statement.setString(1, u.getUserName());
	            statement.setString(2, u.getPassword());	             
	            resultSet = statement.executeQuery(); 
	            userId = resultSet.getInt(1);         
            
	    	} catch (Exception ee) {
	    		System.out.println(" returnUserId "+ ee);
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
	
	                if (connection != null) {
	                	 CodingtonConnectToDB.closeConnection();
	                	 connection = null;
	                }
	    		}catch (Exception ee) {
	    			System.out.println(" returnUserId "+ ee);
	    			return userId;
	    		}
	    		
            } 
	    		
	    	return userId;
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
							
				connection = CodingtonConnectToDB.createConnection();			
	            String select  = DatabaseHelper.getQuery("change_pass");	              
	            statement = connection.prepareStatement(select);
	            statement.setString(1, new_pass);
	            statement.setInt(2, u.getUserId());	             
	            resultSet = statement.executeQuery(); 
	            
			}catch(Exception ee) {
				System.out.println(" updateDAOPassword "+ ee);		    	
	    		return false;
				
			}	
       	
	    	return true;
	    	
	    }
	
	    	    
	    public boolean updateDAOInfo(User u) throws SQLException, ClassNotFoundException{
	          	
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
	            resultSet = statement.executeQuery(); 
	            
			}catch(Exception ee) {
				System.out.println(" updateDAOInfo "+ ee);		    	
	    		return false;
				
			}
	   		    	
	    	return true;
	    }

		@Override
		public boolean ValidationLogin(String user, String pass)
				throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}
	    	
}
