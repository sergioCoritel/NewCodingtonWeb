package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.helper.ConvertImage;

public class TouristAttractionMapper {

	public static TouristAttraction map(ResultSet resultSet) throws IOException{
		TouristAttraction touristAttraction = new TouristAttraction();
		try {
			touristAttraction.setId(resultSet.getInt("id_touristattraction"));
			touristAttraction.setName(resultSet.getString("name"));
			touristAttraction.setCapacity(resultSet.getInt("capacity"));
			touristAttraction.setPlaceDescription(resultSet.getString("description"));
			touristAttraction.setStart(resultSet.getString("start_time"));
			touristAttraction.setEnd(resultSet.getString("end_time"));
			touristAttraction.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return touristAttraction;
	}

}
