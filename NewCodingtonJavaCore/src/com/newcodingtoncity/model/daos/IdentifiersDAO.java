package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IIdentifiersDAO;

public class IdentifiersDAO implements IIdentifiersDAO{


	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public IdentifiersDAO(Connection connection) {
		this.connection = connection;
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
		Integer nextId = 1;
			
		String sql  = DatabaseHelper.getQuery("selec_login");
		statement = connection.prepareStatement(sql);

		statement.setString(1, u.getUserName());
		statement.setString(2, u.getPassword());

		resultSet = statement.executeQuery();

		while (resultSet.next()){
			userId = resultSet.getInt(1);
		}

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, classname);

			resultSet = preparedStatement.executeQuery();
			resultSet.next();

			nextId += resultSet.getInt("value");
			this.updateNext(classname, nextId);

		} catch(SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);

		} finally {
			FERSDataConnection.closeStatement(preparedStatement);
			FERSDataConnection.closeResulSet(resultSet);

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
