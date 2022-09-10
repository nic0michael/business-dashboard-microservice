package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public void save(Employee employee);

	public Employee getOne(Long employeeId);

	public Employee findByEmployeeId(Long employeeId);

	public void delete(Employee employee);

	public List<Employee> findAll(Sort sortByFullnameAsc);
	
	public void update(Employee employee);




	
	

}
