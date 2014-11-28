package es.codington.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;

import com.newcodingtoncity.model.domain.places.TraditionalMarket;

public class TraditionalMarketMapper {

	public static TraditionalMarket map(ResultSet resultSet) throws IOException{
		TraditionalMarket traditionalMarket = new TraditionalMarket();
		PlaceMapper.map(resultSet, traditionalMarket);
		return traditionalMarket;
	}

}
