package za.co.business.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.dtos.GratuityRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Configuration;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Employee;
import za.co.business.model.Product;
import za.co.business.servicemanagers.EmployeeServiceManager;
import za.co.business.utils.RequestResponseUtils;
import za.co.business.utils.Utils;

@Controller
@RequestMapping("/business-dashboard/customer-orders")
public class CustomerOrderController {

	private static final Logger log = LoggerFactory.getLogger(CustomerOrderController.class);
	
	private final double DISCOUNT_PERCENTAGE=10;

	@Value("${project.version}")
	private String projectVersion;

	@Value("${project.name}")
	private String projectName;

	@Autowired
	BusinessLogicProcessor processor;

	@Autowired
	EmployeeServiceManager emplmod;

	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersSortedByDate();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-customer-orders";

	}

	@GetMapping(value = "/new")
	public String newCustomerOrder(Model model) {
		CustomerOrderRequest request = new CustomerOrderRequest();
		Timestamp dateCreated = new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		List<Product> products = processor.findAllProductsSortedByName();

		List<Customer> customers = processor.findAllCustomersSortedByName();
		model.addAttribute("customerOrderRequest", request);
		model.addAttribute("productList", products);
		model.addAttribute("customerList", customers);

		return "customers/new-customer-order";

	}

	@PostMapping(value = "/save")
	public String saveCustomerOrder(CustomerOrderRequest request, Model model) {
		log.info("CustomerOrderController | saveCustomerOrder | request : " + request);
		if (request != null) {
			request.setOrderCompleted(false);
			Long productId = request.getProductId();
			Product product = processor.findProductByProductId(productId);
			if (product != null) {
				request.setProductName(product.getName());
				request.setSellingPrice(product.getSellingPrice());
			}

			Long customerId = request.getCustomerId();
			Customer customer = processor.findCustomerByCustomerId(customerId);
			if (customer != null) {
				request.setCustomerName(customer.getName());
			}
		}
		CustomerOrder customerOrder = processor.saveCustomerOrder(request);
		model.addAttribute("supplierRequest", request);

		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersSortedByDate();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-customer-orders";
	}

	@PostMapping(value = "/update")
	public String updateCustomerOrder(CustomerOrderRequest request, Model model) {
		log.info("CustomerOrderController | saveCustomerOrder | request : " + request);
		if (request != null) {

			Long productId = request.getProductId();
			Product product = processor.findProductByProductId(productId);
			if (product != null) {
				request.setProductName(product.getName());
				request.setSellingPrice(product.getSellingPrice());
			}

			Long customerId = request.getCustomerId();
			Customer customer = processor.findCustomerByCustomerId(customerId);
			if (customer != null) {
				request.setCustomerName(customer.getName());
			}

			Long customerOrderId = request.getCustomerOrderId();
			CustomerOrder customerOrder = processor.findCustomerOrderByCustomerOrderId(customerOrderId);
			if (customerOrder != null) {
				customerOrder = processor.updateCustomerOrder(customerOrder, request);
			}
		}
		model.addAttribute("supplierRequest", request);

		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersSortedByDate();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-customer-orders";
	}

	@GetMapping("/addorder")
	public String addOrdernder(@RequestParam(value = "id") Long customerId, Model model) {
		List<Employee> employees = processor.findAllActiveEmployees();
		Customer customer = processor.findCustomerByCustomerId(customerId);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);

		CustomerOrderRequest request = new CustomerOrderRequest();
		Timestamp dateCreated = new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		List<Product> products = processor.findAllProductsSortedByName();

		model.addAttribute("customerOrderRequest", request);
		model.addAttribute("productList", products);
		model.addAttribute("customerList", customers);
		model.addAttribute("employeeList", employees);

		return "customers/new-customer-order";

	}

	@GetMapping("/printinvoice")
	public String printinvoice(@RequestParam(value = "id") Long customerId, Model model) {

		
		List<Customer> customers = processor.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}

	@GetMapping("/invoiceorder")
	public String invoiceOrder(@RequestParam(value = "id") Long customerId, Model model) {
		Date date = new Date();
		double totalSellingPrice = 0;
		Double discount = DISCOUNT_PERCENTAGE;
		Customer customer = processor.findCustomerByCustomerId(customerId);

		Configuration configuration = processor.getConfiguration();
		
		if(null!= configuration) {
			discount = configuration.getDiscount();
			if(null== discount) {
				discount = DISCOUNT_PERCENTAGE;
			}
		}

		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersByCustomerNotPaid(customer);
		if (customerOrders != null) {
			for (CustomerOrder customerOrder : customerOrders) {
				if (customerOrder.getSellingPrice() != null && customerOrder.getQuantity() != null) {
					totalSellingPrice += (customerOrder.getSellingPrice() * customerOrder.getQuantity());
				}
			}
		}
		String discountVoucherCode = Utils.makeDiscountVoucherCode(totalSellingPrice,discount);
		if (totalSellingPrice < 1) {
			discountVoucherCode = "Not Applicable";
		}

		String companyName = processor.getCompanyName();
		String branchName  = processor.getBranchName();
		String branchPhone = processor.getBranchPhone();
		

		model.addAttribute("companyName", companyName);
		model.addAttribute("branchName", branchName);
		model.addAttribute("branchPhone", branchPhone);

		model.addAttribute("customerOrderList", customerOrders);
		model.addAttribute("customerId", customerId);
		model.addAttribute("customer", customer.getName());
		model.addAttribute("date", date);
		model.addAttribute("totalSellingPrice", totalSellingPrice);
		model.addAttribute("discountVoucherCode", discountVoucherCode);
		return "customers/customer-invoice";
	}

	@GetMapping("/addgratuity")
	public String addGratuity(@RequestParam(value = "id") Long customerId, Model model) {
		log.info("CustomerOrderController | addGratuity | gratuityRequest | id : " + customerId);

		Customer customer = processor.findCustomerByCustomerId(customerId);
		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersByCustomerNotPaid(customer);
		List<Employee> employees = emplmod.findAll();
		
		if(null==customerOrders || customerOrders.isEmpty()) {
			log.info("CustomerOrderController | addGratuity | customerOrders.isEmpty ");
			List<Customer> customers = processor.findAllCustomersSortedByName();
			model.addAttribute("customerList", customers);
			return "customers/list-customers";
		}

		Timestamp dateCreated = new Timestamp(new Date().getTime());
		GratuityRequest gratuityRequest = new GratuityRequest();
		gratuityRequest.setCustomerId(customerId);
		gratuityRequest.setCustomerName(customer.getName());
		gratuityRequest.setDateCreated(dateCreated);
		gratuityRequest.setNrOfOrdersNotPaid(customerOrders.size());

		model.addAttribute("gratuityRequest", gratuityRequest);
		model.addAttribute("customerOrderList", customerOrders);
		model.addAttribute("employeeList", employees);

		return "customers/add-gratuity-to-customer-order";

	}

	@PostMapping("/payorder")
	public String payOrder(GratuityRequest request, Model model) {
		Long customerId = null;

		if (null != request) {
			log.info("--> request : " + request);
			
			Long employeeId = request.getEmployeeId();
			Employee employee = emplmod.findByEmployeeId(employeeId);
			

			customerId = request.getCustomerId();

			Date date=new Date();
			double totalSellingPrice=0;
			List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
			Customer customer=processor.findCustomerByCustomerId(customerId);
			List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersByCustomerNotPaid(customer);
			if(null !=customerOrders && !customerOrders.isEmpty() ) {
				
				request.setEmployeeFullname(employee.getFullName());
				request.setNrOfOrdersNotPaid(customerOrders.size());
				processor.addGraduity(request);
				
				if(customerOrders!=null) {
					for (CustomerOrder customerOrder : customerOrders) {
						if(customerOrder.getSellingPrice()!=null&& customerOrder.getQuantity()!=null) {
							totalSellingPrice+=(customerOrder.getSellingPrice()*customerOrder.getQuantity());
							customerOrder.setPayed(true);
							processor.saveCustomerOrder(customerOrder);
							customerOrderList.add(customerOrder);
						}
					}
				}
				
				model.addAttribute("customerOrderList", customerOrderList);		
				model.addAttribute("customerId", customerId);	
				model.addAttribute("customer", customer.getName());
				model.addAttribute("date", date);
				model.addAttribute("totalSellingPrice", totalSellingPrice);
				return "customers/customer-payed";
				
			} else {

				List<Customer> customers = processor.findAllCustomersSortedByName();
				model.addAttribute("customerList", customers);
				return "customers/list-customers";
			}
		}
		log.info("request is null");
		return "main/home";
	}

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long customerOrderId, Model model) {
		log.info(
				"BUSINESS : CustomerOrderController : deleteCustomerOrder : with customerOrderId : " + customerOrderId);
		CustomerOrder customerOrder = processor.findCustomerOrderByCustomerOrderId(customerOrderId);
		List<Employee> employees = processor.findAllActiveEmployees();
		if (customerOrder != null) {
			Long productId = customerOrder.getProductId();
			Product product = processor.findProductByProductId(productId);
			customerOrder.setSellingPrice(product.getSellingPrice());
		}
		CustomerOrderRequest request = RequestResponseUtils.makeCustomerOrderRequest(customerOrder);
		List<Product> products = processor.findAllProductsSortedByName();

		List<Customer> customers = processor.findAllCustomersSortedByName();
		model.addAttribute("customerOrderRequest", request);
		model.addAttribute("productList", products);
		model.addAttribute("customerList", customers);
		model.addAttribute("employeeList", employees);

		return "customers/edit-customer-order";

	}

	@GetMapping("/maakdood")
	public String deleteCustomerOrder(@RequestParam(value = "id") Long customerOrderId, Model model) {
		log.info(
				"BUSINESS : CustomerOrderController : deleteCustomerOrder : with customerOrderId : " + customerOrderId);
		processor.deleteCustomerOrder(customerOrderId);

		return listall(model);

	}

}
