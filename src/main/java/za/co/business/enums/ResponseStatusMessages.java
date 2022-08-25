package za.co.business.enums;

public enum ResponseStatusMessages {
	OK("OK : Message delivered to RabbitMQ"),
	BAD_REQUEST("The Request is NULL"),
	MQ_FAILURE("Failure : Failed to deliver Message to RabbitMQ"),
	JSON_FAILURE("Failure : Failed to conert DTO to a JSON String"),
	DATABASE_FAILURE("Failure : Failed to write to the Database"),
	
	MISSING_DATE_CREATED("The Request is invalid : MessageId is missing"),
	MISSING_NAME("The Request is invalid : name is missing"),
	MISSING_CREDITS("The Request is invalid : credits is missing"),
	MISSING_DELIVERY_ADDRESS("The Request is invalid : delivery address is missing"),
	MISSING_INVOICE_ADDRESS("The Request is invalid : invoice address is missing"),
	MISSING_EMAIL_ADDRESS("The Request is invalid : email address is missing"),
	MISSING_CELLPHONE("The Request is invalid : cellphone is missing"),
	SYSTEM_FAILURE("Failure : a System failure occured");
		
	String responseStatusMessage;
	
	private ResponseStatusMessages(String responseStatusMessage){
		this.responseStatusMessage=responseStatusMessage;
	}
	
	public String getResponseStatusMessage() {
		return this.responseStatusMessage;
	}

}
