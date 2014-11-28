package es.codington.model.exceptions;

/**
 * Representa las excepciones lanzadas en paquete domain
 * 
 */

public class DomainException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public DomainException(String message){
		super(message);
	}
	
}
