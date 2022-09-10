package za.co.business.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import za.co.business.dtos.ConfigurationRequest;
import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerRequestValidationResponse;
import za.co.business.dtos.GratuityRequest;
import za.co.business.dtos.InventoryRequest;
import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierOrderRequest;
import za.co.business.dtos.SupplierRequest;
import za.co.business.enums.ResponseStatusCodes;
import za.co.business.model.Configuration;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Employee;
import za.co.business.model.Gratuity;
import za.co.business.model.Inventory;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.model.SupplierOrder;
import za.co.business.repositories.ConfigurationRepository;
import za.co.business.repositories.CustomerOrderRepository;
import za.co.business.repositories.CustomerRepository;
import za.co.business.repositories.EmployeeRepository;
import za.co.business.repositories.GratuityRepository;
import za.co.business.repositories.ProductRepository;
import za.co.business.repositories.SupplierOrderRepository;
import za.co.business.repositories.SupplierRepository;
import za.co.business.service.ConfigurationService;
import za.co.business.service.CustomerOrderService;
import za.co.business.service.CustomerService;
import za.co.business.service.EmployeeService;
import za.co.business.service.GratuityService;
import za.co.business.service.InventoryService;
import za.co.business.service.ProductService;
import za.co.business.service.SupplierService;
import za.co.business.service.SupplierOrderService;

import za.co.business.utils.RequestResponseUtils;
import za.co.business.validators.CustomerRequestValidator;

@Component
public class BusinessHelper {
	private static final Logger log = LoggerFactory.getLogger(BusinessHelper.class);

	private final String RESPONSE_IS_OK = ResponseStatusCodes.OK.getResponseStatusCode();

	@Autowired
	CustomerService customerService;


	@Autowired
	CustomerOrderService customerOrderService;

	@Autowired
	ProductService productService;

	@Autowired
	SupplierService supplierService;

	@Autowired
	SupplierOrderService SupplierOrderService;

	@Autowired
	ConfigurationService configurationService;

	@Autowired
	GratuityService gratuityService;

	@Autowired
	InventoryService inventoryService;

	@Autowired
	EmployeeHelper employeeHelper;

	@Autowired
	CustomerRepository custRep;

	private String companyName = null;
	private String branchName = null;
	private String branchPhone = null;

	public BusinessHelper(CustomerService customerService, CustomerOrderService customerOrderService,
			ProductService productService, SupplierService supplierService,
			za.co.business.service.SupplierOrderService supplierOrderService, ConfigurationService configurationService,
			GratuityService gratuityService, InventoryService inventoryService, EmployeeHelper employeeHelper,
			CustomerRepository custRep) {

		super();
		this.customerService = customerService;
		this.customerOrderService = customerOrderService;
		this.productService = productService;
		this.supplierService = supplierService;
		SupplierOrderService = supplierOrderService;
		this.configurationService = configurationService;
		this.gratuityService = gratuityService;
		this.inventoryService = inventoryService;
		this.employeeHelper = employeeHelper;
		this.custRep = custRep;
	}

	public List<Customer> findAllCustomersSortedByName() {
		return customerService.findAll(sortByNameAsc());
	}

	public Customer findCustomerByCustomerId(Long customerId) {
		return customerService.findByCustomerId(customerId);
	}

	public void deleteCustomer(Long customerId) {
		customerService.deleteById(customerId);
	}

	public Customer saveCustomer(CustomerRequest request) {
		Customer customer = null;
		CustomerRequestValidationResponse validationResponse = CustomerRequestValidator.validate(request);
		String validationCode = validationResponse.getResponseStatusCode();
		String errorMessage = validationResponse.getResponseStatusMessage();
		
		if (RESPONSE_IS_OK.equalsIgnoreCase(validationCode)) {
			customer = RequestResponseUtils.makeCustomer(request);
			try {
				customer = customerService.save(customer);
			} catch (Exception e) {
				log.error("Failed to write to Database ", e);
			}
		} else {
			log.error("Failed to Validate CustomerRequest :  "+errorMessage);
		}
		return customer;
	}

	public Customer updateCustomer(Customer customer, CustomerRequest request) {
		customer = RequestResponseUtils.updateCustomer(customer, request);
		try {
			customer = customerService.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public CustomerRequest makeCustomerRequest(Customer customer) {
		CustomerRequest request = RequestResponseUtils.makeCustomerRequest(customer);
		return request;
	}

	public List<CustomerOrder> findAllCustomerOrdersSortedByDate() {
		return customerOrderService.findAll(sortByDateCreatedDesc());
	}

	public List<CustomerOrder> findAllCustomerOrdersByCustomerNotPaid(Customer customer) {
		List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
		List<CustomerOrder> orders = findAllCustomerOrdersByCustomer(customer);
		for (CustomerOrder customerOrder : orders) {
			if (!customerOrder.getPayed()) {
				customerOrders.add(customerOrder);
			}
		}
		return customerOrders;
	}

	public List<CustomerOrder> findAllCustomerOrdersByCustomer(Customer customer) {
		return customerOrderService.findAllByCustomerId(customer.getCustomerId());
	}

	public CustomerOrder findCustomerOrderByCustomerOrderId(Long customerOrderId) {
		CustomerOrder customerOrder = customerOrderService.findByCustomerOrderId(customerOrderId);
		return customerOrder;
	}

	public void deleteCustomerOrder(Long customerOrderId) {
		customerOrderService.deleteById(customerOrderId);
	}

	public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder) {
		customerOrder = customerOrderService.save(customerOrder);
		return customerOrder;
	}

	public CustomerOrder saveCustomerOrder(CustomerOrderRequest request) {
		if (request != null && request.getEmployeeId() != null) {
			Long employeeId = request.getEmployeeId();
			Employee employee = employeeHelper.findByEmployeeId(employeeId);
			if (employee != null) {
				request.setEmployeeFullname(employee.getFullName());
			}
		}
		CustomerOrder customerOrder = RequestResponseUtils.makeCustomerOrder(request);
		customerOrder = customerOrderService.save(customerOrder);
		return customerOrder;
	}

	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder, CustomerOrderRequest request) {
		if (request != null && request.getEmployeeId() != null) {
			Long employeeId = request.getEmployeeId();
			Employee employee = employeeHelper.findByEmployeeId(employeeId);
			if (employee != null) {
				request.setEmployeeFullname(employee.getFullName());
			}
		}
		customerOrder = RequestResponseUtils.updateCustomerOrder(customerOrder, request);
		customerOrder = saveCustomerOrder(customerOrder);
		return customerOrder;
	}

	public List<Product> findAllProductsSortedByName() {
		return productService.findAll(sortByNameAsc());
	}

	public Product findProductByProductId(Long productId) {
		Product product = productService.findByProductId(productId);
		return product;
	}

	public void deleteProduct(Long productId) {
		if (productId != null) {
			log.info("Deleting Ptoduct | productId : " + productId);
			Product product = productService.findByProductId(productId);
			if (product != null) {
				productService.deleteById(productId);
				log.info("Deleted Ptoduct | productId : " + productId);
			}
		}
	}

	public Product saveProduct(ProductRequest request) {
		Product product = RequestResponseUtils.makeRequestResponseUtils(request);
		return productService.save(product);
	}

	public Product updateProduct(Product product, ProductRequest request) {
		if (request != null) {
			product = RequestResponseUtils.makeUpdateRequestResponseUtils(product, request);
			product = productService.save(product);
		}

		return product;
	}

	public ProductRequest makeProductRequest(Product product) {
		ProductRequest request = RequestResponseUtils.makeProductRequest(product);
		return request;
	}

	public List<Supplier> findAllSuppliersSortedByName() {
		return supplierService.findAll(sortByNameAsc());
	}

	public Supplier findSupplierBySupplierId(Long supplierId) {
		return supplierService.findBySupplierId(supplierId);
	}

	public void deleteSupplier(Long suppliertId) {
		supplierService.deleteById(suppliertId);
	}

	public Supplier saveSupplier(SupplierRequest request) {
		Supplier supplier = RequestResponseUtils.makeSupplier(request);
		return supplierService.save(supplier);
	}

	public Supplier updateSupplier(Supplier supplier, SupplierRequest request) {
		supplier = RequestResponseUtils.updateSupplier(supplier, request);
		return supplierService.save(supplier);
	}

	public List<SupplierOrder> findAllSupplierOrdersSortedByDate() {
		return SupplierOrderService.findAll(sortByDateCreatedDesc());
	}

	public SupplierOrder findSupplierOrderBySupplierOrderId(Long supplierOrderId) {
		return SupplierOrderService.findBySupplierOrderId(supplierOrderId);
	}

	public void deleteSupplierOrder(Long supplierOrderId) {
		if (supplierOrderId != null) {
			SupplierOrderService.deleteById(supplierOrderId);
		}

	}

	public SupplierOrder saveSupplierOrder(SupplierOrderRequest request) {
		SupplierOrder supplierOrder = RequestResponseUtils.makeSupplierOrder(request);
		supplierOrder = SupplierOrderService.save(supplierOrder);
		return supplierOrder;
	}

	public SupplierOrder updateSupplierOrder(SupplierOrder supplierOrder, SupplierOrderRequest request) {
		supplierOrder = RequestResponseUtils.updateSupplierOrder(supplierOrder, request);
		supplierOrder = SupplierOrderService.save(supplierOrder);
		return supplierOrder;
	}


	public Configuration saveConfiguration(ConfigurationRequest request) {
		Configuration configuration = RequestResponseUtils.makeConfiguration(request);

		return configurationService.save(configuration);
	}

	public List<Configuration> findAllConfigurations() {
		List<Configuration> configurations = configurationService.findAll();
		return configurations;
	}

	public Configuration findConfigurationByConfigurationId(Long configurationId) {
		Configuration configuration = configurationService.findByConfigurationId(configurationId);
		return configuration;
	}

	public Configuration getConfiguration() {
		Configuration configuration = null;
		List<Configuration> configurations = findAllConfigurations();
		for (Configuration configuration2 : configurations) {
			if (null != configuration2) {
				configuration = configuration2;
			}
		}

		return configuration;
	}

	public Configuration updateConfiguration(Configuration configuration, ConfigurationRequest request) {
		configuration = RequestResponseUtils.updateConfiguration(configuration, request);
		configurationService.save(configuration);
		return configuration;
	}

	public void deleteConfiguration(Long configurationtId) {
		Configuration configuration = configurationService.findByConfigurationId(configurationtId);
		configurationService.delete(configuration);
	}

	public void addGraduity(GratuityRequest request) {
		Gratuity gratuity = RequestResponseUtils.makeGratuity(request);
		if (null != gratuity) {
			gratuityService.save(gratuity);
		}
	}

	public List<Gratuity> findAllGraduities() {
		List<Gratuity> gratuities = gratuityService.findAll(sortByDateCreatedDesc());
		if (gratuities != null) {
			log.info("gratuities has " + gratuities.size() + " records");
		} else {
			log.info("gratuities is null ");
		}
		return gratuities;
	}

	public void deleteGratuity(Long gratuityId) {
		Gratuity gratuity = gratuityService.findByGratuityId(gratuityId);
		gratuityService.delete(gratuity);
	}

	public List<Inventory> findAllInventory() {
		List<Inventory> inventoryList = inventoryService.findAll();
		return inventoryList;
	}

	public void deleteInventory(Long inventoryId) {
		Inventory inventory = inventoryService.findByInventoryId(inventoryId);
		inventoryService.delete(inventory);
	}

	public Inventory findInventoryIdByinventoryId(Long inventoryId) {
		Inventory inventory = inventoryService.findByInventoryId(inventoryId);
		return inventory;
	}

	public Inventory saveInventory(InventoryRequest request) {
		Inventory inventory = null;
		if (request != null) {

			inventory = RequestResponseUtils.makeInventory(request);
			if (inventory != null) {
				inventoryService.save(inventory);
			}
		}
		return inventory;
	}

	public Inventory updateInventory(InventoryRequest request) {
		Inventory inventory = null;
		if (request != null) {
			Long inventoryId = request.getInventoryId();
			inventory = findInventoryIdByinventoryId(inventoryId);
			if (null != inventory) {
				inventory = RequestResponseUtils.updateInventory(inventory, request);
				inventoryService.save(inventory);
				log.info("--> inventory updated : " + inventory);
			}

		}
		return inventory;
	}

	public String getCompanyName() {
		if (null == companyName) {
			setConfigurationVariables();
		}
		return companyName;
	}

	public String getBranchName() {
		if (null == branchName) {
			setConfigurationVariables();
		}
		return branchName;
	}

	public String getBranchPhone() {
		if (null == branchPhone) {
			setConfigurationVariables();
		}
		return branchPhone;
	}

	private void setConfigurationVariables() {

		List<Configuration> configurations = configurationService.findAll();
		Configuration configuration = null;
		for (Configuration theConfiguration : configurations) {
			if (null != theConfiguration) {
				configuration = theConfiguration;
				break;
			}
		}
		if (null != configuration) {
			companyName = configuration.getCompanyName();
			branchName = configuration.getBranchName();
			branchPhone = configuration.getBranchPhone();
		}
	}

	private Sort sortByDateCreatedAsc() {
		return new Sort(Sort.Direction.ASC, "dateCreated");
	}

	private Sort sortByDateCreatedDesc() {
		return new Sort(Sort.Direction.DESC, "dateCreated");
	}

	private Sort sortByNameAsc() {
		return new Sort(Sort.Direction.ASC, "name");
	}

	private Sort sortByFullnameAsc() {
		return new Sort(Sort.Direction.ASC, "fullName");
	}
}
