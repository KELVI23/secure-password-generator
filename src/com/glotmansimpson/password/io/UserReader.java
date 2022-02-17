/**
 * 
 */
package com.glotmansimpson.password.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.glotmansimpson.password.data.User;
import com.glotmansimpson.password.data.util.Validator;



/**
 * @author kmusodza
 *
 */
public class UserReader {
	

	public static final String FILENAME = "adminLogInDetails.txt";
	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";

	private static final Logger LOG = LogManager.getLogger();

	/**
	 * private constructor to prevent instantiation
	 */
	private UserReader() {
	}

	/**
	 * Read the customer input data.
	 *
	 * @return A collection of customers.
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unused")
	public static void read(String userRole, File userDataFile ) throws Exception {
		Map<String, User> users = new HashMap<>();
		
		LOG.debug("Reading" + userDataFile.getAbsolutePath());
		
		Scanner scanner = new Scanner(new FileReader(userDataFile));
		
	
		
		try {
		
			String line = null;
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				String[] elements = line.split(RECORD_DELIMITER);
				if(elements.length != User.ATTRIBUTE_COUNT) {
					
					String.format("Expected %d but got %d: %s", User.ATTRIBUTE_COUNT, elements.length, Arrays.toString(elements));
		}
				String username = elements[0];
				String password = elements[1];
				String workStation = elements[2];
				
				String emailAddress = elements[3];
				if (!Validator.validateEmail(emailAddress)) {
					throw new Exception(String.format("Invalid email: %s", emailAddress));
				}
				
				users.put(userRole, new User.Builder(username, password, workStation).setEmail(emailAddress).build());
			}
		} catch(IOException e){
			LOG.error(e.getMessage());
		} finally{
		scanner.close();	
		}
		
	    LOG.info("Total amount of people read: " + users.size());
		
	}

	


}
