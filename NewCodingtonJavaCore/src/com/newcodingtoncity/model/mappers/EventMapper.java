package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.Event;

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
			case 1:
				event.setPlace(LargeBusinessMapper.map(resultSet));
				break;
			case 2:
				event.setPlace(MuseumMapper.map(resultSet));
				break;
			case 3:
				event.setPlace(ParkMapper.map(resultSet));
				break;
			case 4:
				event.setPlace(StadiumMapper.map(resultSet));
				break;
			case 5:
				event.setPlace(TheaterMapper.map(resultSet));
				break;
			case 6:
				event.setPlace(TouristAttractionMapper.map(resultSet));
				break;
			case 7:
				event.setPlace(TraditionalMarketMapper.map(resultSet));
				break;
			case 8:
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
