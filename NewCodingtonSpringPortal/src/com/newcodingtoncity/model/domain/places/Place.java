package es.codington.model.domain.places;

import java.io.File;


/**
 * Place POJO class for domain model 
 */
public abstract class Place {

	// Encapsulated data fields of PLACE object
	private int id;
	private String name;
	private int capacity;
	private String placeDescription; 
	private String start;
	private String end;
	public enum Zone{NORTH, SOUTH};
	private Zone zone;
	private File image;

	
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
			String placeDescription, String start, String end, Zone zone, File image) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.placeDescription = placeDescription;
		this.start = start;
		this.end = end;
		this.zone = zone;
		this.setImage(image);
	}
	// GETTER and SETTER methods for Place class



	


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
	public String getPlaceDescription() {
		return placeDescription;
	}
	public void setPlaceDescription(String placeDescription) {
		this.placeDescription = placeDescription;
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
	
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}



}
