package com.newcodingtoncity.model.domain;

import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.exceptions.DomainException;
import com.newcodingtoncity.model.test.ValidateEvent;


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
	 * Event default constructor
	 */
	public Event(){}
	
	
	/**
	 * Event constructor
	 * @param eventId
	 * @param eventName
	 * @param description
	 * @param start
	 * @param end
	 * @param eventType
	 * @param ticketPrice
	 * @param seatsAvailable
	 * @param seatsTotal
	 * @param place
	 */
	public Event(int eventId, String eventName, String description,
			String start, String end, String eventType, int ticketPrice,
			int seatsAvailable, int seatsTotal, Place place) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.description = description;
		this.start = start;
		this.eventType = eventType;
		this.end = end;
		this.ticketPrice = ticketPrice;
		this.seatsAvailable = seatsAvailable;
		this.seatsTotal = seatsTotal;
		this.place = place;
	}
	
	
	/**
	 * Return the eventName associated with this instance of Event
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	
	
	/**
	 * Sets the eventName of the specified instance of Event, check the
     * eventName correct.
	 * @param the new eventName
	 */
	public void setEventName(String eventName) {
		if(ValidateEvent.validateString(eventName))
			this.eventName = eventName;
		else
			throw new DomainException("EventName NO VALID: username lengh must be between 1 and 45");
	}
	
	
	/**
	 * Return the description associated with this instance of Event
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * Sets the description of the specified instance of Event, check the
     * description correct.
	 * @param the new description
	 */
	public void setDescription(String description) {
		if(ValidateEvent.validateString(description))
			this.description = description;
		else
			throw new DomainException("Description NO VALID: description lengh must be between 1 and 45");
	}
	
	
	/**
	 * Return the start associated with this instance of Event
	 * @return the start
	 */
	public String getStart() {
		return start;
	}
	
	
	/**
	 * Sets the start of the specified instance of Event
	 * @param the new start
	 */
	public void setStart(String start) {
		this.start = start;
	}
	
	
	/**
	 * Return the end associated with this instance of Event
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}
	
	
	/**
	 * Sets the end of the specified instance of Event
	 * @param the new end
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	
	
	/**
	 * Return the eventType associated with this instance of Event
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}
	
	
	/**
	 * Sets the eventType of the specified instance of Event
	 * @param the new eventType
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	
	/**
	 * Return the ticketPrice associated with this instance of Event
	 * @return the ticketPrice
	 */
	public int getTicketPrice() {
		return ticketPrice;
	}
	
	
	/**
	 * Sets the ticketPrice of the specified instance of Event
	 * @param the new ticketPrice
	 */
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
	/**
	 * Return the eventId associated with this instance of Event
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}
	
	
	/**
	 * Sets the eventId of the specified instance of Event
	 * @param the new eventId
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	
	/**
	 * Return the seatsAvailable associated with this instance of Event
	 * @return the seatsAvailable
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	
	
	/**
	 * Sets the seatsAvailable of the specified instance of Event
	 * @param the new seatsAvailable
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	
	
	/**
	 * Return the seatsTotal associated with this instance of Event
	 * @return the seatsTotal
	 */
	public int getSeatsTotal() {
		return seatsTotal;
	}
	
	
	/**
	 * Sets the seatsTotal of the specified instance of Event
	 * @param the new seatsTotal
	 */
	public void setSeatsTotal(int seatsTotal) {
		this.seatsTotal = seatsTotal;
	}
	
	
	/**
	 * Return the place associated with this instance of Event
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}
	
	
	/**
	 * Sets the place of the specified instance of Event
	 * @param the new place
	 */
	public void setPlace(Place place) {
		this.place = place;
	}
	
	
}
