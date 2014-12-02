package com.newcodingtoncity.model.test;

import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.mysql.jdbc.Connection;
import com.newcodingtoncity.model.daos.PlaceDAO;

public class PruebaImagen {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, IOException {



		        String usuario = "root";
		        String password = "abcd1234";

		        String host = "localhost"; // tambien puede ser una ip como "192.168.1.14"
		        String puerto = "3306";
		        String database = "newcodington";

		        String driver = "com.mysql.jdbc.Driver";

		        String ulrjdbc = "jdbc:mysql://" + host + ":" + puerto + "/" + database;

		        Connection connection = null;
		        try {
		            Class.forName(driver).newInstance();
		            connection = (Connection) DriverManager.getConnection(ulrjdbc, usuario, password);


		        } 
		        catch (Exception e) {
		            e.printStackTrace();
		        } 
		        finally {
		            if (connection != null) {
		                try {
		                    connection.close();
		                } catch (SQLException e) {
		                }
		            }
		        }
		
		int id = 1;
		PlaceDAO place = new PlaceDAO(connection);
		File image = new File("images/" + id + ".jpg");
		place.changeImage(2, image);
		
		
		FileInputStream fin = new FileInputStream(image);
		int tam = (int) image.length();

			String ins = "UPDATE places SET image = ? WHERE id_place = ?";
			PreparedStatement statement = connection.prepareStatement(ins);

			statement.setBlob(1, fin, tam);
			statement.setInt(2, id);
			statement.executeUpdate();
	}
}
