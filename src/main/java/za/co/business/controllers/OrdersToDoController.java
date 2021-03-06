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
import za.co.business.utils.RequestResponseUtils;
import za.co.business.utils.Utils;

@Controller
@RequestMapping("/business-dashboard/orders-to-do")
public class OrdersToDoController {

	private static final Logger log = LoggerFactory.getLogger(OrdersToDoController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;

	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersSortedByDate();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-orders-to-do";		
	}
	

	
	@GetMapping("/completed")
	public String completedOrder(@RequestParam(value = "id") Long customerOrderId,Model model) {
		CustomerOrder customerOrder=processor.findCustomerOrderByCustomerOrderId(customerOrderId);
		customerOrder.setOrderCompleted(true);
		processor.saveCustomerOrder(customerOrder);		

		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersSortedByDate();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-orders-to-do";
	}

}
