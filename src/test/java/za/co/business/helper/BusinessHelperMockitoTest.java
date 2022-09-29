package za.co.business.helper;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.hibernate.engine.config.internal.ConfigurationServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerResponse;
import za.co.business.enums.ErrorCodes;
import za.co.business.model.Customer;
import za.co.business.repositories.CustomerRepository;
import za.co.business.service.ConfigurationService;
import za.co.business.service.CustomerOrderService;
import za.co.business.service.CustomerOrderServiceImpl;
import za.co.business.service.CustomerService;
import za.co.business.service.CustomerServiceImpl;
import za.co.business.service.EmployeeService;
import za.co.business.service.EmployeeServiceImpl;
import za.co.business.service.GratuityService;
import za.co.business.service.GratuityServiceImpl;
import za.co.business.service.InventoryService;
import za.co.business.service.InventoryServiceImpl;
import za.co.business.service.ProductService;
import za.co.business.service.ProductServiceImpl;
import za.co.business.service.SupplierOrderService;
import za.co.business.service.SupplierOrderServiceImpl;
import za.co.business.service.SupplierService;
import za.co.business.service.SupplierServiceImpl;

@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BusinessHelperMockitoTest {
	
	@Mock
	BusinessHelper businessHelper;

	@InjectMocks
	CustomerServiceImpl customerService;

	@InjectMocks
	CustomerOrderServiceImpl customerOrderService;

	@InjectMocks
	ProductServiceImpl productService;

	@InjectMocks
	SupplierServiceImpl supplierService;

	@InjectMocks
	SupplierOrderServiceImpl SupplierOrderService;

	@InjectMocks
	GratuityServiceImpl gratuityService;

	@InjectMocks
	InventoryServiceImpl inventoryService;

	@InjectMocks
	EmployeeServiceImpl employeeService;


	 

	@Test
	public void mockWriteToDatabaseTest() throws Exception {
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
		customer.setCellPhone("dummy_name");
		customer.setCredits(0L);
		customer.setDeliveryAddress("dummy_name");
		customer.setEmailAddress("dummy_name");
		customer.setInvoiceAddress("dummy_name");
		customer.setEmailAddress("dummy_name");
		return customer;
	}
	

}
