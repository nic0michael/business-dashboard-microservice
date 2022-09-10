package za.co.business.security;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityValidator {
	
	private static final Logger log = LoggerFactory.getLogger(SecurityValidator.class);
	
	static final int REQUIRED_PASSWORD_SIZE=10;
	
	static final String PASSWORD_NULL_MESSAGE="The Password should should not be empty";
	static final String PASSWORD_LENGTH_MESSAGE="The Password should have a length of "+REQUIRED_PASSWORD_SIZE+" characters";
	static final String LOWERCASE_CHARACTER_MESSAGE="The Password should have at least one lowercase character";
	static final String UPPERCASE_CHARACTER_MESSAGE="The Password should have at least one uppercase character";
	static final String MISSING_DIGITS_MESSAGE="The Password should have at least one numeric digit";
	static final String MISSING_SPECIAL_CHARACTER_MESSAGE="The Password should have at least one special character";
	public static final String VALIDATION_PASSED_MESSAGE="VALIDATION_PASSED";
	
	
	
	public static String  validatePassword(String password) {
		boolean passwordValidationPassed=true;
		int passwordLength = 0;
		int upChars=0;
		int lowChars=0;
		int special=0;
		int digits=0;

		StringBuilder result =new StringBuilder();
		
		if(StringUtils.isNotEmpty(password)) {
			
			passwordLength = password.length();
			
			for(int i=0; i<passwordLength ; i++) {
				char ch =password.charAt(i);
				
				if(Character.isUpperCase(ch))
		               upChars += 1;
		            else if(Character.isLowerCase(ch))
		               lowChars += 1;
		            else if(Character.isDigit(ch))
		               digits += 1;
		            else
		               special += 1;
			}	
		
			if(REQUIRED_PASSWORD_SIZE>passwordLength) {
				passwordValidationPassed =false;
				result.append(PASSWORD_LENGTH_MESSAGE);	
				result.append(". ");			
			}
			if(lowChars<1) {
				passwordValidationPassed =false;
				result.append(LOWERCASE_CHARACTER_MESSAGE);
				result.append(". ");			
			}
			if(upChars<1) {
				passwordValidationPassed =false;
				result.append(UPPERCASE_CHARACTER_MESSAGE);	
				result.append(". ");			
			}
			if(digits<1) {
				passwordValidationPassed =false;
				result.append(MISSING_DIGITS_MESSAGE);
				result.append(". ");					
			}
			if(special<1) {
				passwordValidationPassed =false;
				result.append(MISSING_SPECIAL_CHARACTER_MESSAGE);
			}
			if(passwordValidationPassed) {
				result.append(VALIDATION_PASSED_MESSAGE);			
			}
		} else {
			result.append(PASSWORD_NULL_MESSAGE);
		}
		log.info("password : ->" +password+ "<- result : "+result.toString());
		return result.toString();
		
	}

}
