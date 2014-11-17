package com.newcodingtoncity.model.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateUser {
	
	/**
	 * Probando validaciones
	 * @param argv
	 */
	public static void main(String[] argv) {
		//String dni = "71.298.438-E";
		//String phoneNUmber = "666777888";
		//String email = "pru-eba@gmail.com";
		//validateSetDNI(dni);
		//validateGetPhoneNumber(phoneNUmber);
		//validateSetEmail(email);
		//String userName = "paoo ioi";
		//validateUserName(userName);
		String string = "paoo ioi";
		validateString(string);
	}
	
	
	public boolean validateUserId(int userId) {
		boolean checkUserIdCorrect = false;
		if(userId > 0)
			checkUserIdCorrect = true;
		
		if(checkUserIdCorrect)	
			System.out.println("UserId VALID");
		else
			System.out.println("UserId NO VALID:");
		return checkUserIdCorrect;
	}
	
	public static boolean validateUserName(String userName) {
		boolean checkUserName = false;
		if(userName != null && userName.length() >= 6 && userName.length() <= 12 && !findSpaces(userName))
			checkUserName = true;
		
		if(checkUserName)	
			System.out.println("UserName VALID");
		else
			System.out.println("UserName NO VALID: username can't have spaces and it lengh must be betwee 6 and 12");
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
	 * Validacion de FirstName, LastName y Address
	 * @param string
	 * @return
	 */
	public static boolean validateString(String string) {
		boolean checkFirstName = false;
		if(string != null && string.length() >= 1 && string.length() <= 30)
			checkFirstName = true;
		
		if(checkFirstName)	
			System.out.println("string VALID");
		else
			System.out.println("string NO VALID");
		return checkFirstName;
	}
	
	
	
	public boolean validatePassword(String password) {
		boolean checkPassword = false;
		if(password != null && password.length() >= 6 && password.length() <= 15)
			checkPassword = true;
		
		if(checkPassword)	
			System.out.println("password VALID");
		else
			System.out.println("password NO VALID");
		return checkPassword;
	}
	
	
	
	/**
	 * Validacion del metodo setDNI
	 * @param dni
	 * @return
	 */
	public boolean validateSetDNI(String dni){
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
		if(checkDniCorrect)									//Si el DNI ha sido introducido correctamente cambiamos el boolean, sino se queda en false
			System.out.println("DNI VALID");
		else
			System.out.println("DNI NO VALID (must be in the form XX.XXX.XXX-X, or DNI badly inserted)");
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
	   * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del NIF
	   * @param dni dni al que se quiere añadir la letra del NIF
	   * @return NIF completo.
	   */ 
	public static String letterDNI(int dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	    return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	  }
	
	
	/**
	 * Validacion del metodo setPhoneNumber
	 * @param phoneNumber
	 * @return
	 */
	public boolean validateSetPhoneNumber(String phoneNumber){
		Pattern pattern;
		Matcher matcher = null;
		boolean checkphoneNumberCorrect = false;
		
		if (phoneNumber != null){
			pattern = Pattern.compile("[0-9]{10,20}");
			matcher = pattern.matcher(phoneNumber);
			if (matcher.matches())
				checkphoneNumberCorrect = true;
			}
		if(checkphoneNumberCorrect)									//Si el DNI ha sido introducido correctamente cambiamos el boolean, sino se queda en false
			System.out.println("Phone Number VALID");
		else
			System.out.println("Phone Number NO VALID:" +
					"\n must be in the form internacional (eg. in Spain 0034 + your number)" +
					"\n and min 10digits or max 20digits");
		return checkphoneNumberCorrect;
	}
	
	
	public static boolean validateSetEmail(String email){
		Pattern pattern;
		Matcher matcher = null;
		boolean checkphoneEmailCorrect = false;
		
		if (email != null){
			pattern = Pattern.compile("[[a-zA-Z]||[0-9]||[., _]]{1,45}@[[a-zA-Z]||[0-9]]{1,45}.[[a-zA-Z]||[0-9]]{1,45}");
			matcher = pattern.matcher(email);
			if (matcher.matches() && email.length() < 45)			//Tiene que cumplir el patron y que su tamaño sea menor de 45
				checkphoneEmailCorrect = true;
			}
		if(checkphoneEmailCorrect)	
			System.out.println("Email VALID");
		else
			System.out.println("Email NO VALID: email must have leters, numbers, and specials characters ('.' and ' _')");
		return checkphoneEmailCorrect;
	}
	
	
	public void validateViewEvents() {
		fail("Not yet implemented");
	}

	
	public void validateSearchEvent() {
		fail("Not yet implemented");
	}

	
	public void validateVisitor() {
		fail("Not yet implemented");
	}

	
	public void validateRegisterNewVisitor() {
		fail("Not yet implemented");
	}

	
	public void validateRegisterForNewEvent() {
		fail("Not yet implemented");
	}

	
	public void validateUnregistreForEvent() {
		fail("Not yet implemented");
	}

}
