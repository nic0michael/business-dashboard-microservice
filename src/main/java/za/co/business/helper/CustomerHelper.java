package za.co.business.helper;


import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.business.dtos.CustomerRequest;
import za.co.business.model.Customer;
import za.co.business.service.CustomerService;
import za.co.business.utils.Utils;

@Component
public class CustomerHelper {

	@Autowired
	CustomerService customerService;

	public Customer saveCustomer(CustomerRequest request){
		Customer customer= makeCustomer( request);
		try {
			customerService.save(customer);
		} catch (Exception e) {
//			log.error("Failed to sace Customer ",e);
		}
		return customer;
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



