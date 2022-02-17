/**
 * 
 */
package com.glotmansimpson.password;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

import com.glotmansimpson.password.database.DecryptData;
import com.glotmansimpson.password.database.EncryptData;

/**
 * @author kmusodza
 *
 */

/*
 * https://www.tutorialspoint.com/java_cryptography/java_cryptography_decrypting_data.htm
 */
public class Driver {
	
	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger();
	private static String generatedPassword ;
	public static boolean isAdmin = false;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LOG.info("Starting Books");
		Instant startTime = Instant.now();
		LOG.info(startTime);
		
	/*
		 * generate random password 
		 * send to encrypter
		 * decrypt if key matches . 
		 * hide password if not administrator
		 * create user
		 */
		
		

		
		Instant endTime = Instant.now();
		LOG.info(endTime);
		LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
		LOG.info("Books has stopped");

	}
	
	public static void generatePassword() {
		RandomPasswordGenerator passwordGenerator = new RandomPasswordGenerator();
		LOG.info("Generating password");
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(passwordGenerator.getRandom());
		generatedPassword = stringBuilder.toString();
		
		stringBuilder.setLength(0);
	}
	
	public static void encryptPassword() throws Exception {
		EncryptData encrypt = new EncryptData();
		
		encrypt.encyptPassword(generatedPassword);
		
		//cahnge method to encrypt and store password
		
	}
	
	
		/*
		 * Read file: encrypt data. check if admin password is valid
		 */
	
	
	public String getPassword() throws Exception {
		DecryptData decrypt = new DecryptData();
		return decrypt.DecryptPassword(null);
	}
	
	
	
	/**
	 * @return the startTime
	 */
	public static Instant getStartTime() {
		Instant startTime = Instant.now();
		return startTime;
	}

	/**
	 * Configures log4j2 from the external configuration file specified in LOG4J_CONFIG_FILENAME.
	 * If the configuration file isn't found then log4j2's DefaultConfiguration is used.
	 */
	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(String.format("WARNING! Can't find the log4j logging configuration file %s; using DefaultConfiguration for logging.",
					LOG4J_CONFIG_FILENAME));
			Configurator.initialize(new DefaultConfiguration());
		}
	}


}
