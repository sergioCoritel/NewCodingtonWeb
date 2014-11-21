package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IIdentifiersDAO;

public class IdentifiersDAO implements IIdentifiersDAO{


	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private DatabaseHelper databaseHelper;

	public IdentifiersDAO(Connection connection, DatabaseHelper databaseHelper) {
		this.connection = connection;
		this.databaseHelper = databaseHelper;
	}

	/**
	 * Method that returns the next id assigned to the table whose name is
	 * passed as parameter
	 * 
	 * @param nameclass
	 * @return nextId
	 */
	@Override
	public int getNextId(String classname) {
		int nextId = 0;

		try {
			
			String sql  = databaseHelper.getQuery("FALTA LA QUERY");
			statement = connection.prepareStatement(sql);
			statement.setString(1, classname);
			resultSet = statement.executeQuery();
		    resultSet.next();
		    
		    nextId += resultSet.getInt("value");
		    this.updateNextId(classname, nextId);

		}catch(Exception ee) {
			System.out.println(" getNextId 1: "+ ee.getMessage());		    	
			return nextId;

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
				System.out.println(" getNextId 2: "+ ee.getMessage());
				return nextId;
			}
		}	

		return nextId;
	}

	/**
	 * Method that update the next id assigned to the table whose name is passed
	 * as parameter
	 * 
	 * @param nameclass
	 * @param nextId
	 * @return affectedRows
	 */
	@Override
	public int updateNextId(String classname, int nextId) {
		return 0;
	}
}
