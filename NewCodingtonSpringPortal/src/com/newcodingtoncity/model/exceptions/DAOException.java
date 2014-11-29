package com.newcodingtoncity.model.exceptions;

/**
 * Clase que representan las excepciones que ser�n lanzadas en la capa de DAOs
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
