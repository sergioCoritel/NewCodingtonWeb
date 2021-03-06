package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.TraditionalMarket;



public class TraditionalMarketMapper implements RowMapper<TraditionalMarket>{


	@Override
	public TraditionalMarket mapRow(ResultSet resultSet, int numRow)
			throws SQLException {
		TraditionalMarket traditionalMarket = new TraditionalMarket();
		try {
			PlaceMapper.map(resultSet, traditionalMarket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return traditionalMarket;
	}

}
