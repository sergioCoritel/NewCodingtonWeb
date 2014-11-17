package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Zoo;
import com.newcodingtoncity.model.helper.ConvertImage;

public class ZooMapper {

	public static Zoo map(ResultSet resultSet) throws IOException{
		Zoo zoo = new Zoo();
		try {
			zoo.setId(resultSet.getInt("id_zoo"));
			zoo.setName(resultSet.getString("name"));
			zoo.setCapacity(resultSet.getInt("capacity"));
			zoo.setPlaceDescription(resultSet.getString("description"));
			zoo.setStart(resultSet.getString("start_time"));
			zoo.setEnd(resultSet.getString("end_time"));
			zoo.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zoo;
	}

}
