package com.newcodingtoncity.model.interfaces.services;

import java.util.List;

import com.newcodingtoncity.model.domain.Event;



public interface IEventService {
	
	public List<Event> getAllEvents();
	public Event getEventById(int id_event);
	public List<Event> getLargeBusinessEvents();
	public List<Event> getMuseumEvents();
	public List<Event> getParkEvents();
	public List<Event> getStadiumEvents();
	public List<Event> getTheaterEvents();
	public List<Event> getTouristAttractionEvents();
	public List<Event> getTraditionalMarketEvents();
	public List<Event> getZooEvents();

}
