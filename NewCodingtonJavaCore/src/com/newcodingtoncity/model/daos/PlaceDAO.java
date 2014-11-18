package com.newcodingtoncity.model.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;

public class PlaceDAO implements IPlaceDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public PlaceDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void changeImage(int id, File image) throws FileNotFoundException,
			SQLException {
		FileInputStream fin = new FileInputStream(image);
		int tam = (int) image.length();

//		if (VACIO) {
			connection = CodingtonConnectToDB.createConnection();
			String ins = DatabaseHelper.getQuery("insert_image");
			statement = connection.prepareStatement(ins);

			statement.setBlob(1, fin, tam);
			statement.setInt(2, id);
			statement.executeUpdate();
//		}

//		else {
			connection = CodingtonConnectToDB.createConnection();
			String upd = DatabaseHelper.getQuery("update_image");
			statement = connection.prepareStatement(upd);

			statement.setBlob(1, fin, tam);
			statement.setInt(2, id);
			statement.executeUpdate();
//		}
	}
}
