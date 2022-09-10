package za.co.business.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import za.co.business.dtos.EmployeePersistRequest;
import za.co.business.model.Employee;
import za.co.business.repositories.EmployeeRepository;
import za.co.business.utils.Utils;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);


	@Autowired
	EmployeeRepository repository;


	@Override
	public List<Employee> findAll() {
		return repository.findAll() ;
	}


	@Override
	public void save(Employee employee) {
		repository.save(employee) ;
	}


	@Override
	public void update(Employee employee) {
		Long employeeId=employee.getEmployeeId();
		repository.deleteById(employeeId);
		repository.save(employee) ;
		
	}

	@Override
	public Employee getOne(Long employeeId) {
		return repository.getOne(employeeId) ;
	}


	@Override
	public Employee findByEmployeeId(Long employeeId) {
		return repository.findByEmployeeId(employeeId) ;
	}


	@Override
	public void delete(Employee employee) {
		repository.delete(employee) ;
	}


	@Override
	public List<Employee> findAll(Sort sortByFullnameAsc) {
		return repository.findAll(sortByFullnameAsc) ;
	}

}
