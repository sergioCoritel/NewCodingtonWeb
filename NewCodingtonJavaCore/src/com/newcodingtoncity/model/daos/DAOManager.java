package com.newcodingtoncity.model.daos;

import java.sql.Connection;

import javax.servlet.ServletContext;

import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;
import com.newcodingtoncity.model.interfaces.daos.IIdentifiersDAO;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;


public class DAOManager {

	private Connection connection;
	private ServletContext context;
	public DatabaseHelper databaseHelper;



	public Connection getConnection() {
		return connection;
	}

	public DAOManager(ServletContext context) {		
		connection  = CodingtonConnectToDB.createConnection();
		this.context = context;
		this.databaseHelper = new DatabaseHelper(context);
	}
	public DAOManager() {		
		connection  = CodingtonConnectToDB.createConnectionWithoutDataSource();	
		this.context = null;
	}


	public DatabaseHelper getDatabaseHelper() {
		return databaseHelper;
	}
	
	/**
	 * Return an instance of IEventDAO
	 * @return
	 */
	public IEventDAO getEventDAO() {		 	
		return new EventDAO(connection, databaseHelper);				 			
	}		 	

	/**
	 * Return an instance of IVisitorDAO
	 * 
	 * @return IVisitorDAO
	 */
	public IUserDAO getUserDAO() {
		return new UserDAO(connection,databaseHelper);	
	}

	public IPlaceDAO getPlaceDAO() {
		return new PlaceDAO(connection, databaseHelper);				
	}

	/**
	 * Return an instance of IEventSignUpDAO
	 * 
	 * @return IEventSignUpDAO
	 */
	public IEventSignUpDAO getEventSignUpDAO() {
		return new EventSignUpDAO(connection, databaseHelper);		
	}


	/**
	 * Return an instance of IIdentifiersDAO
	 * 
	 * @return ISequencerDAO
	 */
	public IIdentifiersDAO getIdentifiersDAO() {
		return new IdentifiersDAO(connection, databaseHelper);		
	}


	public void closeConnectionWithCommit() {
	
			CodingtonConnectToDB.commit(connection);
			CodingtonConnectToDB.closeConnection(connection);
		
	}

	public void closeConnectionWithRollback() {

			CodingtonConnectToDB.rollback(connection);
			CodingtonConnectToDB.closeConnection(connection);
		
	}



}