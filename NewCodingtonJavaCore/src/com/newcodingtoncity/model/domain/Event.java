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
	private int duration;
	private String eventType;
	private String schedule;
	private int ticketPrice;
	private int seatsAvailable;
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
			int duration, String eventType, String schedule, int ticketPrice,
			int seatsAvailable, Place place) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.description = description;
		this.duration = duration;
		this.eventType = eventType;
		this.schedule = schedule;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
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
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
}
