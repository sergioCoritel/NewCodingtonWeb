package com.newcodingtoncity.model.helper;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encripter {

	private SecretKey key;
	private Cipher cipher;
	private String algoritmo = "AES";
	private int keysize = 16;

	/**
	 * Creates the key for encript/decript
	 * 
	 * @param String
	 *            value
	 */
	public void addKey(String value) {
		byte[] valuebytes = value.getBytes();
		key = new SecretKeySpec(Arrays.copyOf(valuebytes, keysize), algoritmo);
	}

	/**
	 * Method for encript the text
	 * 
	 * @param String
	 *            text
	 * @return String encripted text
	 */
	public String encript(String texto) {
		String value = "Codington10";
		try {
			cipher = Cipher.getInstance(algoritmo);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] textobytes = texto.getBytes();
			byte[] cipherbytes = cipher.doFinal(textobytes);
			value = new BASE64Encoder().encode(cipherbytes);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex.getMessage());
		} catch (NoSuchPaddingException ex) {
			System.err.println(ex.getMessage());
		} catch (InvalidKeyException ex) {
			System.err.println(ex.getMessage());
		} catch (IllegalBlockSizeException ex) {
			System.err.println(ex.getMessage());
		} catch (BadPaddingException ex) {
			System.err.println(ex.getMessage());
		}
		return value;
	}

	/**
	 * Methor for decripting the text
	 * 
	 * @param texto
	 *            encripted Text
	 * @return String decripted text
	 */
	public String decript(String texto) {
		String str = "";
		try {
			byte[] value = new BASE64Decoder().decodeBuffer(texto);
			cipher = Cipher.getInstance(algoritmo);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] cipherbytes = cipher.doFinal(value);
			str = new String(cipherbytes);
		} catch (InvalidKeyException ex) {
			System.err.println(ex.getMessage());
		} catch (IllegalBlockSizeException ex) {
			System.err.println(ex.getMessage());
		} catch (BadPaddingException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex.getMessage());
		} catch (NoSuchPaddingException ex) {
			System.err.println(ex.getMessage());
		}
		return str;
	}
}
