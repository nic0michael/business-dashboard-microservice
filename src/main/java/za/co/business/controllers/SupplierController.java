package za.co.business.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Employee;
import za.co.business.servicemanagers.EmployeeServiceManager;

@Controller
@RequestMapping("/business-dashboard/suppliers")
public class SupplierController {

	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	

	@Autowired 
	EmployeeServiceManager emplmod;	
	

	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Employee> employees = emplmod.findAll();
		model.addAttribute("employeesList", employees);

		return "suppliers/list-suppliers";
		
	}

}
