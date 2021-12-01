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
import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Employee;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
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
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<CustomerOrder> customerOrders = processor.findAllCustomerOrders();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-customer-orders";
		
	}
	

	@GetMapping(value = "/new")
	public String newCustomerOrder(Model model) {
		CustomerOrderRequest request =new CustomerOrderRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		List<Product> products = processor.findAllProducts();
		
		List<Customer> customers = processor.findAllCustomers();
		model.addAttribute("customerOrderRequest", request);
		model.addAttribute("productList", products);
		model.addAttribute("customerList", customers);

		return "customers/new-customer-order";
		
	}
	


	@PostMapping(value = "/save")
	public String saveCustomerOrder(CustomerOrderRequest request,Model model) {
		log.info("SupplierController | saveCustomerOrder | request : "+request);
		if(request!=null) {
			Long productId = request.getProductId();
			Product product=processor.findByProductId(productId);				
			if(product!=null){
				request.setProductName(product.getName());
			}
			
			Long customerId =request.getCustomerId();
			Customer customer=processor.findByCustomerId(customerId);
			if(customer!=null){
				request.setCustomerName(customer.getName());
			}
		}
		CustomerOrder customerOrder =processor.saveCustomerOrder(request);
		model.addAttribute("supplierRequest", request);

		List<CustomerOrder> customerOrders = processor.findAllCustomerOrders();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-customer-orders";
	}
	

	@GetMapping(value = "/verander/{id}")
	public String verander(@PathVariable String id,Model model) {
		log.info("ProductController | verander | id : "+id);
		List<Supplier> suppliers = processor.findAllSuppliers();
		ProductRequest request =  new ProductRequest();
		model.addAttribute("productRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "customers/new-customer-order";
		
	}
	
	@GetMapping("/maakdood")
	public String deleteCustomerOrder(@RequestParam(value = "id") Long customerOrderId,Model model) {
		log.info("BUSINESS : CustomerOrderController : deleteCustomerOrder : with customerOrderId : "+customerOrderId);
		processor.deleteCustomerOrder(customerOrderId);

		return listall(model) ;
		
	}

}
