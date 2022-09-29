package za.co.business.enums;

public enum ErrorCodes {
	SUCCESS("200","Message Request processed successfully"), 
	INVALID_REQUEST("ANT300", "Invalid or missing request payload."),
	INVALID_CUSTOMER("ANT301", "Invalid or missing customer."),
	INVALID_MEASUREMENT_TYPE("ANT301", "The measurementType field is missing or empty"),
	INVALID_FIELD_ANTENNA_CODES("ANT302", "The antennaCodes field is missing or empty"),
	FAILURE_TO_PERSIST_TO_DATABASE("ANT400", "Failed to Persist to the Database"),
	MEASUREMENT_FROM_DATABASE_FAILURE("ANT401", "Failed to retrieve Measurement valies from Antenna Database");

	String code;
	String message;

	private ErrorCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public String getCode() {
		return this.code;
	}

}
