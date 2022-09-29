package za.co.business.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerResponse;
import za.co.business.enums.ErrorCodes;
import za.co.business.model.Customer;
import za.co.business.repositories.CustomerRepository;
import za.co.business.utils.Utils;

@Service
public class CustomerServiceImpl implements CustomerService{
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	public CustomerServiceImpl(CustomerRepository custRep) {
		this.custRep=custRep;
	}
	
	@Autowired
	CustomerRepository custRep;
	
	public void setCustomerRepository(CustomerRepository custRep) {
		this.custRep=custRep;
	}

	@Override
	public List<Customer> findAll(Sort sortByNameAsc) {
		return custRep.findAll( sortByNameAsc);
	}

	@Override
	public Customer findByCustomerId(Long customerId) {
		return custRep.findByCustomerId(customerId);
	}

	@Override
	public void deleteById(Long customerId) {
		custRep.deleteById(customerId);
		
	}

	@Override
	public CustomerResponse save(Customer customer) {
		CustomerResponse response=new CustomerResponse();
		if(custRep==null) {
			response.setCode(ErrorCodes.INVALID_REQUEST.getCode());
			response.setMessage(ErrorCodes.INVALID_REQUEST.getMessage());
			return response;
		}
		if(customer==null) {
			response.setCode(ErrorCodes.INVALID_CUSTOMER.getCode());
			response.setMessage(ErrorCodes.INVALID_CUSTOMER.getMessage());
			return response;
		}
		try {
			custRep.save(customer);
			response.setCode(ErrorCodes.SUCCESS.getCode());
			response.setMessage(ErrorCodes.SUCCESS.getMessage());
			response.setCustomer(customer);
		} catch (Exception e) {
			log.error("Failed to save Customer ",e);
			response.setCode(ErrorCodes.FAILURE_TO_PERSIST_TO_DATABASE.getCode());
			response.setMessage(ErrorCodes.FAILURE_TO_PERSIST_TO_DATABASE.getMessage());
		}
		return response;
		
	}
	

	@Override
	public CustomerResponse save(CustomerRequest request) throws Exception {
		CustomerResponse response=new CustomerResponse();
		if(custRep==null) {
			response.setCode(ErrorCodes.INVALID_REQUEST.getCode());
			response.setMessage(ErrorCodes.INVALID_REQUEST.getMessage());
			return response;
		}
		Customer customer = makeCustomer(request);
		response = save(customer);
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
	

	private Sort sortByDateCreatedAsc() {
        return new Sort(Sort.Direction.ASC, "dateCreated");
    }
	
	private Sort sortByDateCreatedDesc() {
        return new Sort(Sort.Direction.DESC, "dateCreated");
    }

	private Sort sortByNameAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }



	private Sort sortByFullnameAsc() {
        return new Sort(Sort.Direction.ASC, "fullName");
    }

}
