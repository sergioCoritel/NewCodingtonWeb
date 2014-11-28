package es.codington.model.exceptions;

/**
 * Class to represent exceptions  will be launched in the Services layer
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}    
}
