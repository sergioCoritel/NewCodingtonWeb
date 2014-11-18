package com.newcodingtoncity.model.daos;

import java.sql.Connection;

import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
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


	public void closeConnection() {
		CodingtonConnectToDB.closeConnection(connection);	
	}


	/**
	 * método que hace commit y cierra la conexion
	 * 
	 */
	public void closeOK() {

		if(connection != null) {
			try {
				connection.commit();

			}catch (Exception ee) {
				System.out.println(" closeOK: "+ ee.getMessage());
			}

			closeConnection();		
		}
	}

	/**
	 * método que hace rollback y cierra la conexion
	 * 
	 */
	public void closeError() {

		if(connection != null) {
			try {
				connection.rollback();

			}catch (Exception ee) {
				System.out.println(" closeError: "+ ee.getMessage());
			}
		}
		closeConnection();		
	}

}