package com.newcodingtoncity.model.daos;

import java.sql.Connection;

import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;


public class DAOManager {

	private Connection connection;

	public DAOManager() {		
		connection  = CodingtonConnectToDB.createConnection();	
	}

	public IEventDAO getEventDAO() {
		return new EventDAO(connection);		
	}

	public IPlaceDAO getPlaceDAO() {
		return new PlaceDAO(connection);		
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