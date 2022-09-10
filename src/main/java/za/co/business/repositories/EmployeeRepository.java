package za.co.business.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.business.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmployeeId(Long employeeId);
	
}
