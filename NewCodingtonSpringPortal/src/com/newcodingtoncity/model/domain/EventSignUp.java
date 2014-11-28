package es.codington.model.domain;

public class EventSignUp {
	
	private int id;
	private int eventId;
	private int visitorId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public EventSignUp(int eventId,int visitorId) {
		// TODO Auto-generated constructor stub
		// this.id = TRAER DE LA BASE DE DATOS 
		this.eventId = eventId;
		this.visitorId = visitorId;
	}
	
	public EventSignUp() {

	}

}
