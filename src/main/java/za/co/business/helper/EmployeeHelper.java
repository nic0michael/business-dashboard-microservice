package za.co.business.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.EmployeePersistRequest;
import za.co.business.model.Employee;
import za.co.business.service.EmployeeService;
import za.co.business.utils.Utils;

@Component
public class EmployeeHelper {
	private static final Logger log = LoggerFactory.getLogger(EmployeeHelper.class);

	@Autowired
	EmployeeService employeeService;


	
	public void save(EmployeePersistRequest employeePersistRequest) {
		log.info("PROJECT_MAN : EmployeeModule : save : saving employee from  EmployeePersistRequest: "
				+ employeePersistRequest);
		Employee employee = new Employee();
		employee = Utils.convertToEmployee(employeePersistRequest, employee);
		employeeService.save(employee);
	}

	
	public List<Employee> findAll() {
		System.out.println("getting list of employees");
		List<Employee> employees = (List<Employee>) employeeService.findAll();
		System.out.println("got list of employees : " + employees);
		return employees;
	}

	
	public Employee getOne(Long employeeId) {
		Employee employee = employeeService.getOne(employeeId);
		return employee;
	}

	
	public Employee findByEmployeeId(Long employeeId) {
		Employee employee = employeeService.findByEmployeeId(employeeId);
		return employee;
	}

	
	public void delete(Long project_id) {
		Employee employee = findByEmployeeId(project_id);
		employeeService.delete(employee);
	}

	
	public void update(EmployeePersistRequest employeePersistRequest) {
		log.info("PROJECT_MAN : EmployeeModule : update : updating employee from  EmployeePersistRequest: "
				+ employeePersistRequest);
		if (employeePersistRequest != null) {
			Long employeeId = Long.parseLong(employeePersistRequest.getEmployeeId());
			log.info("PROJECT_MAN : EmployeeModule : update : updating employee employeeId : " + employeeId);
			Employee employee = employeeService.getOne(employeeId);
			log.info("PROJECT_MAN : EmployeeModule : update : updating employee : " + employee);
			if (employee != null) {
				employee = Utils.convertToEmployee(employeePersistRequest, employee);
				employeeService.save(employee);
			}
		}

	}
}
