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
import za.co.business.helper.BusinessHelper;
import za.co.business.helper.EmployeeHelper;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Employee;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.utils.RequestResponseUtils;

@Controller
@RequestMapping("/business-dashboard/customers")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	


	@Autowired
	BusinessHelper businessHelper;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Customer> customers = businessHelper.findAllCustomersSortedByName();
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
	public String saveCustomer(CustomerRequest request,Model model) {
		log.info("SupplierController | saveCustomerOrder | request : "+request);
		Customer customer =businessHelper.saveCustomer(request);
		model.addAttribute("supplierRequest", request);


		List<Customer> customers = businessHelper.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}
	


	@PostMapping(value = "/update")
	public String updatesaveCustomer(CustomerRequest request,Model model) {
		log.info("SupplierController | saveCustomerOrder | request : "+request);
		if(request!=null) {
			Long customerId=request.getCustomerId();
			Customer customer =businessHelper.findCustomerByCustomerId(customerId);
			customer =businessHelper.updateCustomer(customer,request);		
		}

		List<Customer> customers = businessHelper.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}
	

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("ProductController | verander | customerId: "+customerId);

		
		Customer customer =businessHelper.findCustomerByCustomerId(customerId);
		CustomerRequest request =  businessHelper.makeCustomerRequest(customer);
		
		List<Supplier> suppliers = businessHelper.findAllSuppliersSortedByName();
		model.addAttribute("customerRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "customers/edit-customer";
	}
		




	
	@GetMapping("/maakdood")
	public String deleteCustomer(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("BUSINESS : CustomerController : deleteCustomer : with customerId : "+customerId);
		businessHelper.deleteCustomer(customerId);

		return listall(model) ;
		
	}
}
