package com.newcodingtoncity.model.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateVisitor {
	
	/**
	 * Probando validaciones
	 * @param argv
	 */
	public static void main(String[] argv) {
		//String dni = "71.298.438-E";
		//String phoneNUmber = "666777888";
		//validateSetDNI(dni);
		//validateGetPhoneNumber(phoneNUmber);
	}
	
	
	/**
	 * Validacion del metodo setDNI
	 * @param dni
	 * @return
	 */
	public String validateSetDNI(String dni){
		Pattern pattern;
		Matcher matcher = null;
		boolean dniCorrect = false;
		
		if (!dniCorrect && dni != null){
			pattern = Pattern.compile("\\d{2}.\\d{3}.\\d{3}-[[a-hA-H]||[j-nJ-N]||[p-tP-T]||[v-zV-Z]]");
			matcher = pattern.matcher(dni);
			
			if (matcher.matches()) {					//Structure DNI correct
				int numericDni = convertDni(dni);
				String letter = letterDNI(numericDni);
				if(letter.charAt(8) == Character.toUpperCase(dni.charAt(11)))		//Compara las letras de la conversion (mod23) con la del Dni introducido (la convertimos a mayusculas)
					dniCorrect = true;
				}
			}
		if(dniCorrect)									//Si el DNI ha sido introducido correctamente cambiamos el boolean, sino se queda en false
			System.out.println("DNI VALID");
		else
			System.out.println("DNI NO VALID (must be in the form XX.XXX.XXX-X, or DNI badly inserted)");
		return dni;
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
	 * Validacion del metodo getPhoneNumber
	 * @param phoneNumber
	 * @return
	 */
	public static String validateGetPhoneNumber(String phoneNumber){
		String number = null;
		Pattern pattern;
		Matcher matcher = null;
		boolean phoneNumberCorect = false;
		
		if (!phoneNumberCorect && phoneNumber != null){
			pattern = Pattern.compile("[0-9]{10,20}");
			matcher = pattern.matcher(phoneNumber);
			if (matcher.matches())
				phoneNumberCorect = true;
			}
		if(phoneNumberCorect)									//Si el DNI ha sido introducido correctamente cambiamos el boolean, sino se queda en false
			System.out.println("Phone Number VALID");
		else
			System.out.println("Phone Number NO VALID:" +
					"\n must be in the form internacional (eg. in Spain 0034 + your number)" +
					"\n and min 10digits or max 20digits");
		return number;
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
