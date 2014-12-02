package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;

public class EventMapper implements RowMapper<Event>{

	@Override
	public Event mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Event event = new Event();
			event.setEventId(resultSet.getInt("id_event"));
			event.setEventName(resultSet.getString("name_event"));
			event.setDescription(resultSet.getString("description_event"));
			event.setStart(resultSet.getString("start_event"));
			event.setEnd(resultSet.getString("end_event"));
			event.setEventType(resultSet.getString("type_event"));
			event.setTicketPrice(resultSet.getInt("ticket_price"));
			event.setSeatsAvailable(resultSet.getInt("seats_available"));
			event.setSeatsTotal(resultSet.getInt("seats_total"));
			
			switch (resultSet.getInt("id_type_place")) {
			case LargeBusiness.ID_TYPE_OF_PLACE:

				event.setPlace(new LargeBusinessMapper().mapRow(resultSet, numRow));
				break;
			case Museum.ID_TYPE_OF_PLACE:
				event.setPlace(new MuseumMapper().mapRow(resultSet, numRow));
				break;
			case Park.ID_TYPE_OF_PLACE:
				event.setPlace(new ParkMapper().mapRow(resultSet, numRow));
				break;
			case Stadium.ID_TYPE_OF_PLACE:
				event.setPlace(new StadiumMapper().mapRow(resultSet, numRow));
				break;
			case Theater.ID_TYPE_OF_PLACE:
				event.setPlace(new TheaterMapper().mapRow(resultSet, numRow));
				break;
			case TouristAttraction.ID_TYPE_OF_PLACE:
				event.setPlace(new TouristAttractionMapper().mapRow(resultSet, numRow));
				break;
			case TraditionalMarket.ID_TYPE_OF_PLACE:
				event.setPlace(new TraditionalMarketMapper().mapRow(resultSet, numRow));
				break;
			case Zoo.ID_TYPE_OF_PLACE:
				event.setPlace(new ZooMapper().mapRow(resultSet, numRow));
				break;

			default:
				break;
			}
		
		return event;
	}

}
