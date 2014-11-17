package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.helper.ConvertImage;

public class TraditionalMarketMapper {

	public static TraditionalMarket map(ResultSet resultSet) throws IOException{
		TraditionalMarket traditionalMarket = new TraditionalMarket();
		try {
			traditionalMarket.setId(resultSet.getInt("id_traditionalmarket"));
			traditionalMarket.setName(resultSet.getString("name"));
			traditionalMarket.setCapacity(resultSet.getInt("capacity"));
			traditionalMarket.setPlaceDescription(resultSet.getString("description"));
			traditionalMarket.setWorkingHours(resultSet.getString("workinghours"));
			traditionalMarket.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return traditionalMarket;
	}

}
