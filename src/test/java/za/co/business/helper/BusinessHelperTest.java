package za.co.business.helper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.business.dtos.CustomerRequest;
import za.co.business.enums.TestType;
import za.co.business.model.Customer;
import za.co.business.service.CustomerService;
import za.co.business.service.MockCustomerServiceImpl;

@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BusinessHelperTest {
	
	@Autowired
	BusinessHelper businessHelper;
	
	 
	/**
	 * Disable this test when finished
	 */
	@Test
//	@Disabled 
	public void writeToDatabaseTest() {
		CustomerRequest request= makeCustomerRequest();
		Customer customer = businessHelper.saveCustomer(request);
		assertNotNull(customer);
	}

	@Test
	public void mockWriteToDatabaseTest() {
		CustomerService customerService =new MockCustomerServiceImpl(TestType.PASSING);
		BusinessHelper businessHelper2 = makeBusinessHelper(customerService);
		CustomerRequest request= makeCustomerRequest();
		Customer customer = businessHelper2.saveCustomer(request);
		assertNotNull(customer);
	}
	

	@Test
	public void testThatInvalidValuesDontCrashCodeTest() {
		CustomerService customerService =new MockCustomerServiceImpl(TestType.FAILING);
		BusinessHelper businessHelper2 = makeBusinessHelper(customerService);
		CustomerRequest request= makeCustomerRequest();
		Customer customer = businessHelper2.saveCustomer(request);
		assertNull(customer); 
	}

	@Test
	public void testThatExceptionDoesNotCrashCodeTest() {
		CustomerService customerService =new MockCustomerServiceImpl(TestType.THROWS_EXCEPTIONS);
		BusinessHelper businessHelper2 = makeBusinessHelper(customerService);
		CustomerRequest request= makeCustomerRequest();
		Customer customer = businessHelper2.saveCustomer(request);
	}
	
	private CustomerRequest makeCustomerRequest() {
		CustomerRequest customerRequest=new CustomerRequest();
		customerRequest.setCellPhone("N/A");
		customerRequest.setDeliveryAddress("N/A");
		customerRequest.setInvoiceAddress("N/A");
		customerRequest.setName("Table 2");
		
		return customerRequest;
	}
	
	private BusinessHelper makeBusinessHelper(CustomerService customerService) {
		BusinessHelper businessHelper2 = new BusinessHelper(customerService, null, null, null, null, null, null, null, null, null);
		return businessHelper2;
	}
}
