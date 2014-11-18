package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.helper.ConvertImage;

public class TraditionalMarketMapper {

	public static TraditionalMarket map(ResultSet resultSet) throws IOException{
		TraditionalMarket traditionalMarket = new TraditionalMarket();
		PlaceMapper.map(resultSet, traditionalMarket);
		return traditionalMarket;
	}

}
