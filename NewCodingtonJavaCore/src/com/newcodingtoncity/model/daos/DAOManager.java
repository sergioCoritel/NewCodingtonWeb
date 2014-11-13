package com.newcodingtoncity.model.daos;

import java.sql.Connection;

import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;


public class DAOManager {

	private Connection connection;

	public DAOManager() {		
		connection  = CodingtonConnectToDB.createConnection();	
	}

	public IEventDAO getEventDAO() {
		return new EventDAO(connection);		
	}

	public void closeConnection() {
		CodingtonConnectToDB.closeConnection(connection);	
	}

}