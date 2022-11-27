package za.co.business.helper;


import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
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
import za.co.business.dtos.CustomerResponse;
import za.co.business.enums.ErrorCodes;
import za.co.business.enums.ResponseStatusCodes;
import za.co.business.helper.CustomerHelper;
import za.co.business.model.Customer;
import za.co.business.validators.CustomerRequestValidator;

@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = { BusinessDashboardApplication.class })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerHelperTDDTest {
	
	@Autowired
	CustomerHelper customerHelper;		

	/**
	 * YOU NEED TO DISABLE THIS TEST WHEN FINISHED | IT WRITES TO THE DB
	 * 
	 * The outcome of this test is to create new Behavior 
	 * 
	 */
	@Test
	@Order(1)
//	@Disabled 
	@DisplayName("saveCustomerTest")
	public void saveCustomerTest() {	

		// GIVEN	 we have a request with required fields		
		CustomerRequest request = makeCustomerRequest();
				
		// WHEN      a record is successfully created in the Database
		CustomerResponse response = customerHelper.saveCustomer(request); 
				
		// THEN      we should get a Successful response
		Assert.assertNotNull(response);
		String responseCode=response.getCode();
		String responseMessage=response.getMessage();
		Assert.assertEquals(responseCode, ErrorCodes.SUCCESS.getCode());
		Assert.assertEquals(responseMessage, ErrorCodes.SUCCESS.getMessage());
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

