package com.newcodingtoncity.model.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.newcodingtoncity.model.exceptions.DomainException;


public class ValidateUser {
	
	
	/**
	 * Validate userName
	 * @param userName
	 * @return
	 */
	public static boolean validateSetUserName(String userName) throws DomainException{
		boolean checkUserName = false;
		if(userName != null && userName.length() >= 6 && userName.length() <= 12 && !findSpaces(userName))
			checkUserName = true;
		return checkUserName;
	}
	
	
	/**
	 * Busca espacios en blanco en una cadena. Si los encuentra devuelve true
	 * @return
	 */
	public static boolean findSpaces(String string){
		boolean checkSpaces = false;
		int i=0;
		while(i < string.length() ){							//Busca espacios en blanco
			if(string.charAt(i) == ' '){
				checkSpaces = true;
				break;
			}
			i++;
		}
		return checkSpaces;
	}
	
	
	/**
	 * Validate firstName, lastName and address
	 * @param string
	 * @return
	 */
	public static boolean validateString(String string) {
		boolean checkString = false;
		if(string != null && string.length() >= 1 && string.length() <= 30)
			checkString = true;
		return checkString;
	}
	
	
	/**
	 * Validate password
	 * @param password
	 * @return
	 */
	public static boolean validatePassword(String password) {
		boolean checkPassword = false;
		if(password != null && password.length() >= 6 && password.length() <= 15)
			checkPassword = true;
		return checkPassword;
	}
	
	
	/**
	 * Validate setDNI
	 * @param dni
	 * @return
	 */
	public static boolean validateSetDNI(String dni){
		Pattern pattern;
		Matcher matcher = null;
		boolean checkDniCorrect = false;
		
		if (dni != null){
			pattern = Pattern.compile("\\d{2}.\\d{3}.\\d{3}-[[a-hA-H]||[j-nJ-N]||[p-tP-T]||[v-zV-Z]]");
			matcher = pattern.matcher(dni);
			
			if (matcher.matches()) {					//Structure DNI correct
				int numericDni = convertDni(dni);
				String letter = letterDNI(numericDni);
				if(letter.charAt(8) == Character.toUpperCase(dni.charAt(11)))		//Compara las letras de la conversion (mod23) con la del Dni introducido (la convertimos a mayusculas)
					checkDniCorrect = true;
				}
			}
		return checkDniCorrect;
	}
	
	
	/**
	 * Convierte StringDni con puntos a IntDni sin puntos
	 * @param dni
	 * @return
	 */
	public static int convertDni(String dni){
		String dniNumeric = "";
	
		for(int i=0; i<=9; i++){
			if(dni.charAt(i) != '.'){
				dniNumeric += dni.charAt(i);
			}
		 }
		return Integer.parseInt(dniNumeric);
	  }
	
	
	  /**
	   * Devuelve un NIF completo a partir de un DNI. Es decir, a�ade la letra del NIF
	   * @param dni dni al que se quiere a�adir la letra del NIF
	   * @return NIF completo.
	   */ 
	public static String letterDNI(int dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	  }
	
	
	/**
	 * Validate setPhoneNumber
	 * @param phoneNumber
	 * @return
	 */
	public static boolean validateSetPhoneNumber(String phoneNumber){
		Pattern pattern;
		Matcher matcher = null;
		boolean checkphoneNumberCorrect = false;
		
		if (phoneNumber != null){
			pattern = Pattern.compile("[0]{2}[0-9]{8,18}");
			matcher = pattern.matcher(phoneNumber);
			if (matcher.matches())
				checkphoneNumberCorrect = true;
			}
		return checkphoneNumberCorrect;
	}
	
	
	/**
	 * Validate setEmail
	 * @param email
	 * @return
	 */
	public static boolean validateSetEmail(String email){
		Pattern pattern;
		Matcher matcher = null;
		boolean checkphoneEmailCorrect = false;
		
		if (email != null){
			pattern = Pattern.compile("[[a-zA-Z]||[0-9]||[._-]]{1,45}@[[a-zA-Z]||[0-9]]{1,45}.[[a-zA-Z]||[0-9]]{2,4}");
			matcher = pattern.matcher(email);
			if (matcher.matches() && email.length() < 45)			//Tiene que cumplir el patron y que su tama�o sea menor de 45
				checkphoneEmailCorrect = true;
			}
		return checkphoneEmailCorrect;
	}
	

	
}
