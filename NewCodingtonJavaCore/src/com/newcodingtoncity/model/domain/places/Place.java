package com.newcodingtoncity.model.domain.places;


/**
 * Place POJO class for domain model 
 */
public abstract class Place {

	// Encapsulated data fields of PLACE object
	private int id;
	private String name;
	private int capacity;
	private String placeDescription; 
	private String workingHours;
	public enum Zone{NORTH, SOUTH};
	private Zone zone;
	private String image;

	
	/**
	 * @param events
	 * @param placeName
	 * @param capacity
	 * @param placeDescription
	 * @param workingHours
	 * @param zone
	 */
	
	public Place(){}
	
	public Place(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.placeDescription = placeDescription;
		this.workingHours = workingHours;
		this.zone = zone;
		this.setImage(image);
	}
	// GETTER and SETTER methods for Place class



	public String getPlaceDescription() {
		return placeDescription;
	}
	public void setPlaceDescription(String placeDescription) {
		this.placeDescription = placeDescription;
	}


	// Abstract method to be overrided in Subclasses like Stadium, Zoo etc.
	public abstract void showEvents();
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
