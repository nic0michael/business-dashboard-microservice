package za.co.business.enums;

public enum ResponseStatusCodes {
	OK("200"),
	BAD_REQUEST("400"),
	MQ_FAILURE("401"),
	JSON_FAILURE("402"),
	DATABASE_FAILURE("403"),
	MISSING_DATE_CREATED("404"),
	MISSING_NAME("405"), 
	MISSING_CREDITS("406"),
	MISSING_DELIVERY_ADDRESS("407"),
	MISSING_INVOICE_ADDRESS("408"),
	MISSING_EMAIL_ADDRESS("409"),
	MISSING_CELLPHONE("410"),
	SYSTEM_FAILURE("411");
	
	String responseStatusCode;
	
	private ResponseStatusCodes(String responseStatusCode) {
		this.responseStatusCode=responseStatusCode;
	}
	public String getResponseStatusCode() {
		return this.responseStatusCode;
	}

}
