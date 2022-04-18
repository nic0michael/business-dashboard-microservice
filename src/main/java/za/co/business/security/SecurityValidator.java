package za.co.business.security;

import org.springframework.stereotype.Component;

@Component
public class SecurityValidator {
	static final int REQUIRED_PASSWORD_SIZE=10;
	static final String PASSWORD_LENGTH_MESSAGE="The Password should have a length of "+REQUIRED_PASSWORD_SIZE+" characters";
	static final String LOWERCASE_CHARACTER_MESSAGE="The Password should have at least one lowercase character";
	static final String UPPERCASE_CHARACTER_MESSAGE="The Password should have at least one uppercase character";
	static final String MISSING_DIGITS_MESSAGE="The Password should have at least one numeric digit";
	static final String MISSING_SPECIAL_CHARACTER_MESSAGE="The Password should have at least one special character";
	static final String VALIDATION_PASSED_MESSAGE="VALIDATION_PASSED";
	
	private static StringBuilder result =new StringBuilder();
	private static boolean passwordValidationPassed=true;
	
	private static int passwordLength = 0;
	private static int upChars=0;
	private static int lowChars=0;
	private static int special=0;
	private static int digits=0;
	
	public static String  passwordValidationPassed(String password) {
		
		if(null != password) {
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
			
		}
		
		validateResults(); 
		
		
		return result.toString();
	}
	
	public static void validateResults() {
		if(REQUIRED_PASSWORD_SIZE>passwordLength) {
			passwordValidationPassed =false;
			result.append(PASSWORD_LENGTH_MESSAGE);			
		}
		if(lowChars<1) {
			passwordValidationPassed =false;
			result.append(LOWERCASE_CHARACTER_MESSAGE);				
		}
		if(upChars<1) {
			passwordValidationPassed =false;
			result.append(UPPERCASE_CHARACTER_MESSAGE);				
		}
		if(digits<1) {
			passwordValidationPassed =false;
			result.append(MISSING_DIGITS_MESSAGE);				
		}
		if(special<1) {
			passwordValidationPassed =false;
			result.append(MISSING_SPECIAL_CHARACTER_MESSAGE);				
		}
		if(passwordValidationPassed) {
			result.append(VALIDATION_PASSED_MESSAGE);			
		}
	}

}
