package za.co.business.helper;


import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerResponse;
import za.co.business.enums.ErrorCodes;
import za.co.business.model.Customer;
import za.co.business.service.CustomerService;
import za.co.business.utils.Utils;

@Component
public class CustomerHelper {
	

	private static final Logger log = LoggerFactory.getLogger(Utils.class);

	@Autowired
	CustomerService customerService;


	public CustomerResponse saveCustomer(CustomerRequest request){
		CustomerResponse response =new CustomerResponse();
		Date date = new Date();
		long time = date.getTime();
		Timestamp dateCreated=new Timestamp(time);		
		Customer customer=makeCustomer(request);
		
		try {
			response= customerService.save(request);
		} catch (Exception e) {
			log.error("Failed to save Customer ",e);
			response.setCode(ErrorCodes.FAILURE_TO_PERSIST_TO_DATABASE.getCode());
			response.setMessage(ErrorCodes.FAILURE_TO_PERSIST_TO_DATABASE.getMessage());
		}
		
		return response;
	}

	private Customer makeCustomer(CustomerRequest request){
		Date date = new Date();
		long time = date.getTime();
		Timestamp dateCreated=new Timestamp(time);		
		Customer customer=new Customer();
		customer.setDateCreated(dateCreated);
		customer.setCellPhone(request.getCellPhone());
		customer.setCredits(request.getCredits());
		customer.setEmailAddress(request.getEmailAddress());
		customer.setDeliveryAddress(request.getDeliveryAddress());
		customer.setInvoiceAddress(request.getInvoiceAddress());
		customer.setName(request.getName());
		return customer;
	}
}




