/**
 * 
 */
package com.glotmansimpson.password.database;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author kmusodza
 *
 */
public class DecryptData {
	
	private static final Logger LOG = LogManager.getLogger();

	
	public String DecryptPassword(String encryptedPassword) throws Exception {
		
		   //Creating a Signature object
	      Signature sign = Signature.getInstance("SHA256withRSA");
	      
	      //Creating KeyPair generator object
	      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	      
	      //Initializing the key pair generator
	      keyPairGen.initialize(2048);
	      
	      //Generate the pair of keys
	      KeyPair pair = keyPairGen.generateKeyPair();   
	      
	      //Getting the public key from the key pair
	      PublicKey publicKey = pair.getPublic();  

	      //Creating a Cipher object
	      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

	      //Initializing a Cipher object
	      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		  
	      //Add data to the cipher
	      byte[] input = encryptedPassword.getBytes();	  
	      cipher.update(input);
		  
	      //encrypting the data
	      byte[] cipherText = cipher.doFinal();	 
	      System.out.println( new String(cipherText, "UTF8"));

	      //Initializing the same cipher for decryption
	      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
	      
	      //Decrypting the text
	      byte[] decipheredText = cipher.doFinal(cipherText);
	      verifySign(sign, publicKey, cipherText, pair);
	      
	      return (new String(decipheredText));
	      
	      
	  	
		
		
	}
	
	 private void verifySign(Signature sign, PublicKey publicKey, byte[]arr, KeyPair pair ) throws Exception {
		 //initialize sign
		 sign.initSign((PrivateKey) publicKey);
		 sign.update(arr);
		 
		 //Calculating the signature
	     byte[] signature = sign.sign();      
	     
	     //Initializing the signature
	     sign.initVerify(pair.getPublic());
	     sign.update(arr);
	     
	     //Verifying the signature
	     boolean bool = sign.verify(signature);
	     
	     if(bool) {
	    	 LOG.debug("Sign verified"); 
	     }
	     
	  else {
		 LOG.debug("Signature failed");
	  	}
	 }

}
