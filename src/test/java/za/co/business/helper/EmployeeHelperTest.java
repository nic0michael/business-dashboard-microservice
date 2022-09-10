package za.co.business.helper;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.business.dtos.EmployeePersistRequest;
import za.co.business.model.Employee;

@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeHelperTest {

	@Autowired
	EmployeeHelper employeeHelper;

	/**
	 * Disable this test when finished
	 */
	@Test
	@Disabled 
	public void writeToDatabaseTest() {
		EmployeePersistRequest employeePersistRequest = makeEmployeePersistRequest();
		Employee employee = employeeHelper.save(employeePersistRequest);
		assertNotNull(employee);
	}

	private EmployeePersistRequest makeEmployeePersistRequest() {
		EmployeePersistRequest employeePersistRequest = new EmployeePersistRequest();
		
		employeePersistRequest.setFullName("dummy_full_name");
		employeePersistRequest.setIdNumber("dummy_id_number");
		employeePersistRequest.setDetails("dummy_details");
		employeePersistRequest.setTelephone("dummy_telephone");
		employeePersistRequest.setCellphone("dummy_cellphone");
		employeePersistRequest.setEmail("dummy_email");
		employeePersistRequest.setPassword("dummy_password");
		employeePersistRequest.setAuthority("dummy_authority");
		employeePersistRequest.setUserId("dummy_user_id");
		employeePersistRequest.setEnabled("1");

		return employeePersistRequest;
	}

}
