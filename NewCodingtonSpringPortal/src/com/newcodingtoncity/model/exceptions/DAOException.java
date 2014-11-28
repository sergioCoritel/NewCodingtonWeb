package es.codington.model.exceptions;

/**
 * Clase que representan las excepciones que serán lanzadas en la capa de DAOs
 *
 */
@SuppressWarnings("serial")
public class DAOException extends RuntimeException {
    
    public DAOException(String message) {
	super(message);
    }
    
    public DAOException(String message, Throwable cause) {
	super(message, cause);
    }    

}
