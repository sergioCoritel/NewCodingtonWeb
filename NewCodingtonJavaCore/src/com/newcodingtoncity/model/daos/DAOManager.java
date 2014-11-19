package com.newcodingtoncity.model.daos;

import java.sql.Connection;

import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;
import com.newcodingtoncity.model.interfaces.daos.IIdentifiersDAO;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;


public class DAOManager {

	private Connection connection;

	public DAOManager() {		
		connection  = CodingtonConnectToDB.createConnection();	
	}

	/**
	 * Return an instance of IEventDAO
	 * @return
	 */
	public IEventDAO getEventDAO() {		 	
		return new EventDAO(connection);				 			
	}		 	

	/**
	 * Return an instance of IVisitorDAO
	 * 
	 * @return IVisitorDAO
	 */
	public IUserDAO getUserDAO() {
		return new UserDAO(connection);
	}

	public IPlaceDAO getPlaceDAO() {
		return new PlaceDAO(connection);		
	}

	/**
	 * Return an instance of IEventSignUpDAO
	 * 
	 * @return IEventSignUpDAO
	 */
	public IEventSignUpDAO getEventSignUpDAO() {
		return new EventSignUpDAO(connection);
	}


	/**
	 * Return an instance of IIdentifiersDAO
	 * 
	 * @return ISequencerDAO
	 */
	public IIdentifiersDAO getIdentifiersDAO() {
		return new IdentifiersDAO(connection);
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