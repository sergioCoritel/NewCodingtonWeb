package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;


public class EventMapper {

	public static Event map(ResultSet resultSet) throws IOException{
		Event event = new Event();
		try {
			event.setEventId(resultSet.getInt("id_event"));
			event.setEventName(resultSet.getString("name_event"));
			event.setDescription(resultSet.getString("description_event"));
			event.setStart(resultSet.getString("start_event"));
			event.setEnd(resultSet.getString("end_event"));
			event.setTicketPrice(resultSet.getInt("ticket_price"));
			event.setSeatsAvailable(resultSet.getInt("seats_available"));
			event.setSeatsTotal(resultSet.getInt("seats_total"));
			
			switch (resultSet.getInt("id_type_place")) {
			case LargeBusiness.ID_TYPE_OF_PLACE:

				event.setPlace(LargeBusinessMapper.map(resultSet));
				break;
			case Museum.ID_TYPE_OF_PLACE:
				event.setPlace(MuseumMapper.map(resultSet));
				break;
			case Park.ID_TYPE_OF_PLACE:
				event.setPlace(ParkMapper.map(resultSet));
				break;
			case Stadium.ID_TYPE_OF_PLACE:
				event.setPlace(StadiumMapper.map(resultSet));
				break;
			case Theater.ID_TYPE_OF_PLACE:
				event.setPlace(TheaterMapper.map(resultSet));
				break;
			case TouristAttraction.ID_TYPE_OF_PLACE:
				event.setPlace(TouristAttractionMapper.map(resultSet));
				break;
			case TraditionalMarket.ID_TYPE_OF_PLACE:
				event.setPlace(TraditionalMarketMapper.map(resultSet));
				break;
			case Zoo.ID_TYPE_OF_PLACE:
				event.setPlace(ZooMapper.map(resultSet));
				break;

			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return event;
	}

}
