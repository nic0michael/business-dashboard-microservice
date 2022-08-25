package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.enums.TestType;
import za.co.business.model.Customer;

public class MockCustomerServiceImpl implements CustomerService{
	
	private TestType testType;
	
	private MockCustomerServiceImpl() {}
	
	public MockCustomerServiceImpl(TestType testType) {
		this.testType=testType;	
	}

	@Override
	public Customer save(Customer customer) throws Exception {
		Customer returnValue=null;
		
		String theTestType = testType.name();
		switch(theTestType) {
		case "PASSING" :
			returnValue =customer;
			break;
			
		case "FAILING" :
			returnValue =null;
			break;
			
		case "THROWS_EXCEPTIONS" :
			throw new Exception();		
		}
		
		return returnValue;
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


}
