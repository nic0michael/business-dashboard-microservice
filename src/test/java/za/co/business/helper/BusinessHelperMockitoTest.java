package za.co.business.helper;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.business.dtos.CustomerRequest;
import za.co.business.model.Customer;
import za.co.business.service.CustomerServiceImpl;

@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BusinessHelperMockitoTest {
	
	@Mock
	BusinessHelper businessHelper;

	@InjectMocks
	CustomerServiceImpl customerService;
	
	 
	/**
	 * Disable this test when finished
	 */
	@Test
//	@Disabled 
	public void writeToDatabaseTest() {
		CustomerRequest request= makeCustomerRequest();
		Customer testCustomer =makeCustomer();
		when(businessHelper.saveCustomer(request)).thenReturn(testCustomer);
		Customer customer = businessHelper.saveCustomer(request);
		assertNotNull(customer);
	}

	
	private CustomerRequest makeCustomerRequest() {
		CustomerRequest customerRequest=new CustomerRequest();
		customerRequest.setCellPhone("N/A");
		customerRequest.setDeliveryAddress("N/A");
		customerRequest.setInvoiceAddress("N/A");
		customerRequest.setName("Table 2");
		
		return customerRequest;
	}

	private Customer makeCustomer() {
		Customer customer = new Customer();
		customer.setName("dummy_name");
		return customer;
	}

}
