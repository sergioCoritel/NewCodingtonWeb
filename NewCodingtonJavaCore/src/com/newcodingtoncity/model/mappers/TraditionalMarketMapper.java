package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.TraditionalMarket;

public class TraditionalMarketMapper {

	public static TraditionalMarket map(ResultSet resultSet){
		TraditionalMarket traditionalMarket = new TraditionalMarket();
		try {
			traditionalMarket.setId(resultSet.getInt("id_traditionalmarket"));
			traditionalMarket.setName(resultSet.getString("name"));
			traditionalMarket.setCapacity(resultSet.getInt("capacity"));
			traditionalMarket.setPlaceDescription(resultSet.getString("description"));
			traditionalMarket.setWorkingHours(resultSet.getString("workinghours"));
			traditionalMarket.setImage(resultSet.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return traditionalMarket;
	}

}
