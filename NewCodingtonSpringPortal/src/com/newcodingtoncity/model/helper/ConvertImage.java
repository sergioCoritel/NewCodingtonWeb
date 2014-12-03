package com.newcodingtoncity.model.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;


public class ConvertImage {

	public static File blobToImage(Blob image, int id) throws SQLException, IOException{
		File image_deserialized = new File("/images/" + id + ".jpg");
		
		
		InputStream is = image.getBinaryStream();  
        FileOutputStream fos = new FileOutputStream(image_deserialized);  

		int b = 0;
		while ((b = is.read()) != -1){
			fos.write(b);
		}
		return image_deserialized;
	}
	
	public static Blob imageToBlob(File image) throws SQLException, IOException{
		return null;
	}	
}
