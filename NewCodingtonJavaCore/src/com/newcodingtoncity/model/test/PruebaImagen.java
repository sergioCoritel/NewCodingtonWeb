package com.newcodingtoncity.model.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sun.font.CreatedFontTracker;

import com.mysql.jdbc.Connection;
import com.newcodingtoncity.model.daos.PlaceDAO;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.ConvertImage;
import com.newcodingtoncity.model.helper.DatabaseHelper;

public class PruebaImagen {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
/*		Connection conection = (Connection) CodingtonConnectToDB.createConnection();
		PlaceDAO place = new PlaceDAO(conection);
		File image = new File("images/museum.jpg");
		place.changeImage(2, image);
		
		conection = (Connection) CodingtonConnectToDB.createConnection();
		String read  = DatabaseHelper.getQuery("read_image");
		PreparedStatement statement = conection.prepareStatement(read);
		statement.setInt(1, 1);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			Blob blob = resultSet.getBlob("image");

			File image2 = ConvertImage.blobToImage(blob, 1);
		}
		
		System.out.println("FIN");
	*/}
}
