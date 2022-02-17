/**
 * 
 */
package com.glotmansimpson.password.data.util;

/**
 * @author kmusodza
 *
 */
public class Validator {
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Validator() {
		
	}
	
	/*
	 * Validate an email string
	 * 
	 */
	public static boolean validateEmail(final String email) {
		return email.matches(EMAIL_PATTERN);
	}
	
//	public static boolean validateUserName(final String userName) {
//		return email.matches()
//	}
	
}
