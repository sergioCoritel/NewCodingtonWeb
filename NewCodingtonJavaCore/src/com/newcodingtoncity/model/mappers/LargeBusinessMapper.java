package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.helper.ConvertImage;

public class LargeBusinessMapper {

	public static LargeBusiness map(ResultSet resultSet) throws IOException{
		LargeBusiness largeBusiness = new LargeBusiness();
		try {
			largeBusiness.setId(resultSet.getInt("id_place"));
			largeBusiness.setName(resultSet.getString("name_place"));
			largeBusiness.setCapacity(resultSet.getInt("capacity"));
			largeBusiness.setPlaceDescription(resultSet.getString("description_place"));
			largeBusiness.setStart(resultSet.getString("start_time"));
			largeBusiness.setEnd(resultSet.getString("end_time"));
			largeBusiness.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return largeBusiness;
	}

}
