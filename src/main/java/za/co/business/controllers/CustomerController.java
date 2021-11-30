package za.co.business.controllers;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
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

import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.ProductRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Employee;
import za.co.business.model.Supplier;
import za.co.business.servicemanagers.EmployeeServiceManager;

@Controller
@RequestMapping("/business-dashboard/customers")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	


	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Customer> customers = processor.findAllCustomers();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
		
	}
	

	@GetMapping(value = "/new")
	public String newCustomer(Model model) {
		CustomerRequest request =new CustomerRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		model.addAttribute("customerRequest", request);

		return "customers/new-customer";
		
	}

	@PostMapping(value = "/save")
	public String saveCustomerOrder(CustomerRequest request,Model model) {
		log.info("SupplierController | saveCustomerOrder | request : "+request);
		Customer customer =processor.saveCustomer(request);
		model.addAttribute("supplierRequest", request);


		List<Customer> customers = processor.findAllCustomers();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}
	
	

	@GetMapping(value = "/verander/{id}")
	public String verander(@PathVariable String id,Model model) {
		log.info("ProductController | verander | id : "+id);
		List<Supplier> suppliers = processor.findAllSuppliers();
		ProductRequest request =  new ProductRequest();
		model.addAttribute("productRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "customers/new-customer";
		
	}

	@GetMapping(value = "maakdood/{id}")
	public String maakdood(@PathVariable String id,Model model) {
		log.info("ProductController | maakdood | id : "+id);

		return listall(model) ;
		
	}
}
