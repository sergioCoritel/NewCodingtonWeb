package com.newcodingtoncity.model.domain;

import com.newcodingtoncity.model.domain.places.Place;
/**
 * POJO class to represent EVENT domain class
 */
public class Event {

	// Encapsulated data fields for EVENT class 
	private int eventId;
	private String eventName;
	private String description;
	private String start;
	private String end;
	private String eventType;
	private int ticketPrice;
	private int seatsAvailable;
	private int seatsTotal;
	private Place place;
	
	/**
	 * @param eventId
	 * @param eventName
	 * @param description
	 * @param duration
	 * @param eventType
	 * @param schedule
	 * @param ticketPrice
	 * @param seatsAvailable
	 * @param place
	 */
	
	public Event(){}
	
	public Event(int eventId, String eventName, String description,
			String start, String end, String eventType, int ticketPrice,
			int seatsAvailable, Place place) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.description = description;
		this.start = start;
		this.eventType = eventType;
		this.end = end;
		this.ticketPrice = ticketPrice;
		this.seatsAvailable = seatsAvailable;
		this.place = place;
	}
	
	// GETTER and SETTER methods for EVENT class
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public int getSeatsTotal() {
		return seatsTotal;
	}
	public void setSeatsTotal(int seatsTotal) {
		this.seatsTotal = seatsTotal;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}

	


	
}
