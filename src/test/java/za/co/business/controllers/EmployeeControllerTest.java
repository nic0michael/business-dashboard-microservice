package za.co.business.controllers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import za.co.business.BusinessDashboardApplication;


@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = { BusinessDashboardApplication.class })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTest {
	
	@Autowired
	EmployeeController controller;
	
	@Autowired
	TheModel model;
	

	

	/**
	 * Disable this test when finished
	 */
	@Test
	@Order(1)
//	@Disabled
	@DisplayName("Test 1")
	public void Test() {		
	
		// GIVEN	
		
		//WHEN
		String employees = controller.displayEmployees(model);
		
		// THEN
		System.out.println("The employees : "+employees);
		Assert.assertNotNull(employees);
	}

}
