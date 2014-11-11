package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;

public class UserDAO {

	// JDBC API classes for data persistence
		private Connection connection = null;
		private PreparedStatement statement = null;
		private ResultSet resultSet = null;
		

	    private static final String selec_login =
	                    "select userId from user " +
	                    "where userName=? " +
	                    " and password=? ";    

	    public boolean ValidationLogin(String user, String pass) throws SQLException{
	    			    	
	    	try {
      
	    		connection = CodingtonConnectToDB.createConnection();
				statement = connection.prepareStatement(selec_login);
				resultSet = statement.executeQuery();
				
	           
               String select  = DatabaseHelper.getQuery(selec_login);	              
               statement = connection.prepareStatement(select);
               statement.setString(1, user);
               statement.setString(2, pass);	             
               resultSet = statement.executeQuery();                   
  
               if(resultSet.getRow()<=0){
            	   
            	   System.out.println("No existe el usuario en la base de datos");
            	  
               }
               

	        } catch (Exception ee) {
	        	System.out.println("No se pudo conectar a la base de datos");
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
	                	 CodingtonConnectToDB.closeConnection();
	                	 connection = null;
	                }
	            } catch (SQLException e) {
	            	return false;
	            }
	        }

			return true;
	    	
	    }	    
	
}
