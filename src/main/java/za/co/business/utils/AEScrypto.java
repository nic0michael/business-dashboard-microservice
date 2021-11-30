package za.co.business.utils;

import org.springframework.security.crypto.encrypt.Encryptors;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.http.MediaType;
import org.springframework.security.crypto.keygen.KeyGenerators;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class AEScrypto {
	private static final Logger log = LoggerFactory.getLogger(AEScrypto.class);

	@Value("${crypto.salt}")
	private static String cryptoSalt;	

	@Value("${crypto.key}")
	private static String cryptoKey;
	
	public static String encryptText(String text) {
		return encryptText(text, cryptoKey, cryptoSalt);
	}	

	public static String decrypt(String encryptedText ) {
		return decrypt( encryptedText, cryptoKey, cryptoSalt );
	}
	
	public static String encryptText(String text,String cryptoKey,String cryptoSalt) {
		log.info( "BUSINESS | AEScrypto| encryptText | encrypting text");		
		String encryptedText = Encryptors.text(cryptoKey, cryptoSalt).encrypt(text);
		return encryptedText;
	}
	public static String decrypt(String encryptedText,String cryptoKey,String cryptoSalt ) {
		
		String decryptedText = Encryptors.text(cryptoKey, cryptoSalt).decrypt(encryptedText);
		log.info( "BUSINESS | AEScrypto| decrypt | decrypting text");	
		return decryptedText;
	}

	public static String generateCryptoKey() {
		
		KeyGenerator keyGen;
		SecretKey secretKey = null;
		byte[] raw=null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            secretKey = keyGen.generateKey();
            raw=secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
        	log.info( "BUSINESS| Failed to make key");
        }
        log.info( "BUSINESS | AEScrypto| generateCryptoKey |  CryptoKey "+raw);
        
        StringBuilder generatedKey = new StringBuilder();
        for (byte b : raw) {
            generatedKey.append(String.format("%02X", b));
        }
        
        return generatedKey.toString();
	}

}
