package za.co.business.helper;


import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import za.co.business.BusinessDashboardApplication;
import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerRequestValidationResponse;
import za.co.business.enums.ResponseStatusCodes;
import za.co.business.helper.CustomerHelper;
import za.co.business.model.Customer;
import za.co.business.validators.CustomerRequestValidator;

/**
 * Refactoring as per the original publication by Martin Fowler
 * TDD done according to the original TDD publication by Ken Beck
 *
 */
@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = { BusinessDashboardApplication.class })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerHelperTDDTest {
	
	@Autowired
	CustomerHelper customerHelper;
	
	

	@Test
	@Order(1)
	@DisplayName("customerRequestValidatorTest 1")
	public void customerRequestValidatorTest() {	

		// GIVEN			
		CustomerRequest request = makeCustomerRequest();
		CustomerRequestValidator validator =new CustomerRequestValidator();
		
		//WHEN
		CustomerRequestValidationResponse customerRequestValidationResponse = validator.validate(request);
		String responseStatusCode = customerRequestValidationResponse.getResponseStatusCode();
		String responseStatusMessage = customerRequestValidationResponse.getResponseStatusMessage();
		//THEN
		Assert.assertEquals(ResponseStatusCodes.OK.getResponseStatusCode(), responseStatusCode);

	}


	/**
	 * Disable this test when finished
	 */
	@Test
	@Order(2)
//	@Disabled
	@DisplayName("customerRequestValidatorTest 2")
	public void customeequestValidatorTest() {	

		// GIVEN			
		CustomerRequest request = makeCustomerRequest();
		
		//WHEN
		Customer customer = customerHelper.saveCustomer(request); 
		Assert.assertNotNull(customer);

	}


	private CustomerRequest makeCustomerRequest() {
		CustomerRequest request = new CustomerRequest();
		request.setName("dummy_name");
		request.setCellPhone("dummy_name");
		request.setCredits(0L);
		request.setDeliveryAddress("dummy_name");
		request.setEmailAddress("dummy_name");
		request.setInvoiceAddress("dummy_name");
		request.setEmailAddress("dummy_name");
		return request;
	}

}

