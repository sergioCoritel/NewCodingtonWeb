package com.newcodingtoncity.model.validators;


import com.newcodingtoncity.model.exceptions.DomainException;


public class ValidateEvent {
	
	
	/**
	 * Validate eventName, description
	 * @param userName
	 * @return
	 * @throws DomainException
	 */
	public static boolean validateString(String string) throws DomainException{
		boolean checkString = false;
		if(string != null && string.length() >= 1 && string.length() <= 45)
			checkString = true;
		return checkString;
	}
	
	
}
