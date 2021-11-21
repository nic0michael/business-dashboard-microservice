package za.co.business.controllers;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Employee;
import za.co.business.servicemanagers.EmployeeServiceManager;

@Controller
@RequestMapping("/business-dashboard/customer-orders")
public class CustomerOrderController {

	private static final Logger log = LoggerFactory.getLogger(CustomerOrderController.class);
	
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

		return "customers/list-customer-orders";
		
	}
}
