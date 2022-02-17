/**
 * 
 */
package com.glotmansimpson.password.database;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

import javax.crypto.Cipher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author kmusodza
 *
 */
public class EncryptData {
	
	private static final Logger LOG = LogManager.getLogger();


 public String encyptPassword(String password) throws Exception {
		// TODO Auto-generated constructor stub
	//create signature object 
	 Signature sign = Signature.getInstance("SHA256withRSA");
	
	//Create KeyPair generator object
	KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		
	  //Generating the pair of keys
    KeyPair pair = keyPairGen.generateKeyPair();      
	
  //Getting the privatekey from the key pair
    PrivateKey privKey = pair.getPrivate();
    
    //Creating a Cipher object
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      
    //Initializing a Cipher object
    cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
	  
    //Adding data to the cipher

    byte[] input = password.getBytes();	  
    cipher.update(input);
	  
    //encrypting the data
    byte[] cipherText = cipher.doFinal();	 
  
    // System.out.println(new String(cipherText, "UTF8"));
    verifySign(sign, privKey, cipherText, pair);
	
    return (new String(cipherText, "UTF8"));
 }
 
 private void verifySign(Signature sign, PrivateKey privKey, byte[]arr, KeyPair pair ) throws Exception {
	 //initialize sign
	 sign.initSign(privKey);
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
