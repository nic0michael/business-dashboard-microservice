package za.co.business.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import za.co.business.dtos.EmployeePersistRequest;
import za.co.business.model.Employee;
import za.co.business.service.EmployeeService;
import za.co.business.utils.Utils;

@Component
public class EmployeeHelper {
	private static final Logger log = LoggerFactory.getLogger(EmployeeHelper.class);


	@Value("${project.date.format}")
	private String dateUsaFormat;	// 06/17/2020

	@Value("${project.date.iso.format}")
	private String dateIsoFormat;	// "yyyy-MM-dd

	@Value("${project.date.rsa.format}")
	private String dateRsaFormat;	// "dd-MM-yyyy"

	@Value("${project.time.rsa.format}")
	private String timeRsaFormat;	// "HH:mm:ss"
	
	@Autowired
	EmployeeService employeeService;
	

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;


	public List<Employee> findAllActiveEmployees() {
		List<Employee> activeEmployees = new ArrayList<>();
		List<Employee> employees = employeeService.findAll(sortByFullnameAsc());
		for (Employee employee : employees) {
			if (employee != null && employee.getEnabled() != 0) {
				activeEmployees.add(employee);
			}
		}
		return activeEmployees;
	}
	
	public Employee save(EmployeePersistRequest employeePersistRequest) {
		log.info("BUSINESS : EmployeeModule : save : saving employee from  EmployeePersistRequest: "+ employeePersistRequest);
		Employee employee = populateEmployee(employeePersistRequest);
		employeeService.save(employee);
		return employee;
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
		log.info("BUSINESS : EmployeeModule : update : updating employee from  EmployeePersistRequest: "+ employeePersistRequest);
		if (employeePersistRequest != null) {
			Long employeeId = Long.parseLong(employeePersistRequest.getEmployeeId());
			log.info("BUSINESS : EmployeeModule : update : updating employee employeeId : " + employeeId);
			Employee employee = employeeService.findByEmployeeId(employeeId);
			log.info("BUSINESS : EmployeeModule : update : updating employee : " + employee);
			if (employee != null) {
				employee = populateEmployee(employeePersistRequest, employee);
				employeeService.update(employee);
			}
		}

	}

	private Sort sortByFullnameAsc() {
		return new Sort(Sort.Direction.ASC, "fullName");
	}
	

	private Employee populateEmployee(EmployeePersistRequest employeePersistRequest) {
		Employee employee = null;
		if(null==employeePersistRequest.getEmployeeId()) {
			employee = populateEmployee(employeePersistRequest, new Employee());
			
		} else if(! StringUtils.isNumeric(employeePersistRequest.getEmployeeId())) {
			log.error("employeeId is not numeric "+employeePersistRequest.getEmployeeId());
		} else {		
			Long employeeId=Long.parseLong(employeePersistRequest.getEmployeeId());
			employee = employeeService.findByEmployeeId(employeeId);
			employee = populateEmployee(employeePersistRequest,employee); 
		}
		return employee;
	}

	private Employee populateEmployee(EmployeePersistRequest employeePersistRequest, Employee employee) {		
		log.info("BUSINESS : Utils : convertToEmployee : EmployeePersistRequest :" + employeePersistRequest);
		employee.setFullName(employeePersistRequest.getFullName().toUpperCase());
		employee.setEmployeeNumber(employeePersistRequest.getEmployeeNumber());
		employee.setIdNumber(employeePersistRequest.getIdNumber());
		employee.setDetails(employeePersistRequest.getDetails());
		employee.setTelephone(employeePersistRequest.getTelephone());
		employee.setCellphone(employeePersistRequest.getCellphone());
		employee.setEmail(employeePersistRequest.getEmail());
	    employee.setPassword(employeePersistRequest.getPassword());
	    employee.setAuthority(employeePersistRequest.getAuthority());
	    employee.setUserId(employeePersistRequest.getUserId());
	    
	    if(StringUtils.isNotEmpty(employeePersistRequest.getDateCreated())){
	    	employee.setDateCreated(convertStringToDate(employeePersistRequest.getDateCreated()));
	    }

		if (StringUtils.isNotEmpty(employeePersistRequest.getEmployeePassword())) {
			if (passwordEncoder == null) {
				passwordEncoder = new BCryptPasswordEncoder();
			}

			employee.setPassword(passwordEncoder.encode(employeePersistRequest.getEmployeePassword()));
		}

		if (StringUtils.isNotEmpty(employeePersistRequest.getEnabled()) &&  "1".equals(employeePersistRequest.getEnabled())) {
			employee.setEnabled(1);
		}
		else {
			employee.setEnabled(0);
		}

		log.info("BUSINESS : convertToEmployee : Employee :" + employee);
		
		return employee;
	}


	/**
	 * 
	 * project.date.usa.format=MM/dd/yyyy
	 * project.date.iso.format=yyyy-MM-dd
	 * 
	 */
	private Date convertStringToDate(String sDate) {

		String saDateFormat = "dd/MM/yyyy";
		
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		
		if (dateIsoFormat == null) {
			dateIsoFormat = "yyyy-MM-dd";
		}
		
		String dateFormt = dateUsaFormat;
		Date date = null;
		
		if (StringUtils.isNotEmpty(sDate)) {
			if (sDate.contains("/")) {
				dateFormt = dateUsaFormat;
		
				try {
					date = new SimpleDateFormat(dateFormt).parse(sDate);
				}
				catch (ParseException e) {
					dateFormt =saDateFormat;
				}
			}
			else if (sDate.contains("-")) {
				dateFormt = dateIsoFormat;
			}
			
			if (sDate.length() > 10) {
				sDate = sDate.substring(0, 10);
			}
			try {
				date = new SimpleDateFormat(dateFormt).parse(sDate);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}

		log.info("BUSINESS : Utils : convertStringToDate : converting date:" + date);
		return date;
	}
}
