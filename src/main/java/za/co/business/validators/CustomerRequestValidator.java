package za.co.business.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerRequestValidationResponse;
import za.co.business.enums.ResponseStatusCodes;
import za.co.business.enums.ResponseStatusMessages;

public class CustomerRequestValidator {
	private static final Logger log = LoggerFactory.getLogger(CustomerRequestValidator.class);
	
	private static final boolean VALIDATION_FAILED=false;
	private static final boolean VALIDATION_PASSED=true;
	
	private  static String responseStatusMessage;
	private  static String responseStatusCode;	
	
	public static CustomerRequestValidationResponse validate(CustomerRequest request) {
		log.info("validateSendToQueueRequest called");
		validateRequest(request);
		CustomerRequestValidationResponse response =makeCustomerRequestValidationResponse(request);
		log.info("validateSendToQueueRequest | response : "+response);
		return response;
	}

	private static void validateRequest(CustomerRequest request) {

		log.info("validateRequest called");
		if(request==null) {
			responseStatusCode=ResponseStatusCodes.BAD_REQUEST.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.BAD_REQUEST.getResponseStatusMessage();
			
		} else if(StringUtils.isEmpty(request.getName())) {
			responseStatusCode=ResponseStatusCodes.MISSING_NAME.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.MISSING_NAME.getResponseStatusMessage();			
		} else if(StringUtils.isEmpty(request.getCellPhone())) {
			responseStatusCode=ResponseStatusCodes.MISSING_CELLPHONE.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.MISSING_CELLPHONE.getResponseStatusMessage();			
		}  else {
			responseStatusCode=ResponseStatusCodes.OK.getResponseStatusCode();
			responseStatusMessage=ResponseStatusMessages.OK.getResponseStatusMessage();
		}

	}
	

	private  static CustomerRequestValidationResponse makeCustomerRequestValidationResponse(CustomerRequest request) {
		CustomerRequestValidationResponse response=new CustomerRequestValidationResponse();
		response.setResponseStatusCode(responseStatusCode);
		response.setResponseStatusMessage(responseStatusMessage);
		return response;
	}
}
