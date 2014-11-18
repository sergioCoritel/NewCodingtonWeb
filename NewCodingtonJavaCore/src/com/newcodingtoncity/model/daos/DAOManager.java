package com.newcodingtoncity.model.daos;

import java.sql.Connection;

import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;


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


	public void closeConnectionWithCommit() {
		CodingtonConnectToDB.commit(connection);
		CodingtonConnectToDB.closeConnection(connection);	
	}
	
	public void closeConnectionWithRollback() {
		CodingtonConnectToDB.rollback(connection);

		CodingtonConnectToDB.closeConnection(connection);	
	}



}