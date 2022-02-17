package com.glotmansimpson.password;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 */

/**
 * @author kmusodza
 * Generate secure random password
 *
 */
public class RandomPasswordGenerator {

	private static final Logger LOG = LogManager.getLogger();

	/**
	 * @param args
	 */

		//construct secure random number generator
		private final SecureRandom randomNum = new SecureRandom();
		
		private final List<Character> valueObj = new ArrayList<>();
		
		public RandomPasswordGenerator() {
			
			//add ASCII Decimal value 33 < x > 47 
			//add special chars
			for(int i= 33; i < 47; i++) {
				valueObj.add((char) i);
			}
			
			//add ASCII Decimal value 48 < x > 85 
			//add special chars
			for(int i = 48; i < 85; i++) {
				valueObj.add((char) i );
			}
			
			
			for (int i = 86; i < 127; i++) {
		            valueObj.add((char) i);
		     }
			
			//shuffles the list by specified distance
			Collections.rotate(valueObj, 4);
			
			
		}
		
		 // Get Char value from above added Decimal values
	    public char getRandom() {
	 
	        char randomChar = this.valueObj.get(randomNum.nextInt(this.valueObj.size()));
	 
	        LOG.debug(String.valueOf(randomChar));
	        return randomChar;
	    }
		


}
