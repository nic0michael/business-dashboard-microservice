package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerResponse;
import za.co.business.enums.ErrorCodes;
import za.co.business.enums.TestType;
import za.co.business.model.Customer;

public class MockCustomerServiceImpl implements CustomerService{
	
	private TestType testType;
	
	private MockCustomerServiceImpl() {}
	
	public MockCustomerServiceImpl(TestType testType) {
		this.testType=testType;	
	}

	@Override
	public CustomerResponse save(Customer customer) throws Exception {

		CustomerResponse response=new CustomerResponse();
		
		String theTestType = testType.name();
		switch(theTestType) {
		case "PASSING" :
			response.setCode(ErrorCodes.SUCCESS.getCode());
			response.setMessage(ErrorCodes.SUCCESS.getMessage());
			response.setCustomer(customer);
			break;
			
		case "FAILING" :
			response.setCode(ErrorCodes.INVALID_REQUEST.getCode());
			response.setMessage(ErrorCodes.INVALID_REQUEST.getMessage());
			break;
			
		case "THROWS_EXCEPTIONS" :
			throw new Exception();		
		}
		
		return response;
	}

	@Override
	public CustomerResponse save(CustomerRequest request) throws Exception {

		CustomerResponse response=new CustomerResponse();
		
		String theTestType = testType.name();
		switch(theTestType) {
		case "PASSING" :
			response.setCode(ErrorCodes.SUCCESS.getCode());
			response.setMessage(ErrorCodes.SUCCESS.getMessage());
			Customer customer = makeCustomer();
			response.setCustomer(customer);
			break;
			
		case "FAILING" :
			response.setCode(ErrorCodes.INVALID_REQUEST.getCode());
			response.setMessage(ErrorCodes.INVALID_REQUEST.getMessage());
			break;
			
		case "THROWS_EXCEPTIONS" :
			throw new Exception();		
		}
		
		return response;
	}

	@Override
	public List<Customer> findAll(Sort sortByNameAsc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long customerId) {
		// TODO Auto-generated method stub
		
	}


	private Customer makeCustomer() {
		Customer customer = new Customer();
		customer.setName("dummy_name");
		customer.setCellPhone("dummy_name");
		customer.setCredits(0L);
		customer.setDeliveryAddress("dummy_name");
		customer.setEmailAddress("dummy_name");
		customer.setInvoiceAddress("dummy_name");
		customer.setEmailAddress("dummy_name");
		return customer;
	}

}
