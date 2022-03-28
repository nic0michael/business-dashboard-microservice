package za.co.business.logic;

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
import za.co.business.dtos.GratuityRequest;
import za.co.business.dtos.InventoryRequest;
import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierOrderRequest;
import za.co.business.dtos.SupplierRequest;
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
import za.co.business.repositories.InventoryRepository;
import za.co.business.repositories.ProductRepository;
import za.co.business.repositories.SupplierOrderRepository;
import za.co.business.repositories.SupplierRepository;
import za.co.business.utils.RequestResponseUtils;

@Component
public class BusinessLogicProcessor {
	private static final Logger log = LoggerFactory.getLogger(BusinessLogicProcessor.class);
	
	@Autowired
	CustomerRepository custRep;
	
	@Autowired
	CustomerOrderRepository custOrdRep;
	
	@Autowired
	ProductRepository prodRep;
	
	@Autowired
	SupplierRepository suppRep;
	
	@Autowired
	SupplierOrderRepository suppOrdRep;
	
	@Autowired
	EmployeeRepository employeeRep;
	
	@Autowired
	ConfigurationRepository confRep;
	
	@Autowired
	GratuityRepository gratuityRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;
	

	private String companyName = null;
	private String branchName  = null;
	private String branchPhone = null;
	

	public List<Customer> findAllCustomersSortedByName() {
		return custRep.findAll(sortByNameAsc());
	}

	public Customer findCustomerByCustomerId(Long customerId) {
		return custRep.findByCustomerId(customerId);
	}

	public void deleteCustomer(Long customerId) {	
		custRep.deleteById(customerId);
	}

	public Customer saveCustomer(CustomerRequest request) {
		Customer customer=RequestResponseUtils.makeCustomer(request);
		customer=custRep.save(customer);
		return customer;
	}

	public Customer updateCustomer(Customer customer,CustomerRequest request) {
		customer=RequestResponseUtils.updateCustomer(customer,request);
		customer=custRep.save(customer);
		return customer;
	}


	public CustomerRequest makeCustomerRequest(Customer customer) {
		CustomerRequest request=RequestResponseUtils.makeCustomerRequest(customer);
		return request;
	}


	public List<CustomerOrder> findAllCustomerOrdersSortedByDate() {
		return custOrdRep.findAll(sortByDateCreatedDesc());
	}
	
	public List<CustomerOrder> findAllCustomerOrdersByCustomerNotPaid(Customer customer) {
		List<CustomerOrder> customerOrders=new ArrayList<CustomerOrder>();
		List<CustomerOrder> orders=findAllCustomerOrdersByCustomer(customer);
		for (CustomerOrder customerOrder : orders) {
			if(!customerOrder.getPayed()) {
				customerOrders.add(customerOrder);
			}
		}
		return customerOrders;
	}

	public List<CustomerOrder> findAllCustomerOrdersByCustomer(Customer customer) {
		return custOrdRep.findAllByCustomerId(customer.getCustomerId());
	}
	
	public CustomerOrder findCustomerOrderByCustomerOrderId(Long customerOrderId) {
		CustomerOrder customerOrder= custOrdRep.findByCustomerOrderId(customerOrderId);
		return customerOrder;
	}

	public void deleteCustomerOrder(Long customerOrderId) {
		custOrdRep.deleteById(customerOrderId);		
	}
	

	public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder) {
		customerOrder=custOrdRep.save(customerOrder);
		return customerOrder;
	}

	public CustomerOrder saveCustomerOrder(CustomerOrderRequest request) {
		if(request!=null && request.getEmployeeId() !=null) {
			Long employeeId = request.getEmployeeId();
			Employee employee =employeeRep.findByEmployeeId(employeeId);
			if(employee!=null) {
				request.setEmployeeFullname(employee.getFullName());
			}
		}
		CustomerOrder customerOrder=RequestResponseUtils.makeCustomerOrder(request);
		customerOrder=custOrdRep.save(customerOrder);
		return customerOrder;
	}

	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder, CustomerOrderRequest request) {
		if(request!=null && request.getEmployeeId() !=null) {
			Long employeeId = request.getEmployeeId();
			Employee employee =employeeRep.findByEmployeeId(employeeId);
			if(employee!=null) {
				request.setEmployeeFullname(employee.getFullName());
			}
		}
		customerOrder=RequestResponseUtils.updateCustomerOrder(customerOrder,request);
		customerOrder=saveCustomerOrder(customerOrder);
		return customerOrder;
	}


	public List<Product> findAllProductsSortedByName() {
		return prodRep.findAll(sortByNameAsc());
	}
	
	public Product findProductByProductId(Long productId){
		Product product=prodRep.findByProductId(productId);
		return product;
	}


	public void deleteProduct(Long productId) {
		if(productId!=null) {
			log.info("Deleting Ptoduct | productId : "+productId );
			Product product=prodRep.findByProductId(productId);
			if(product!=null) {			
				prodRep.deleteById(productId);
				log.info("Deleted Ptoduct | productId : "+productId );
			}
		}
	}	

	public Product saveProduct(ProductRequest request) {
		Product product=RequestResponseUtils.makeRequestResponseUtils(request);
		return prodRep.save(product);
	}


	public Product updateProduct(Product product,ProductRequest request) {
		if(request!=null) {
			product=RequestResponseUtils.makeUpdateRequestResponseUtils(product,request);
			product=prodRep.save(product);
		}
		
		return product;
	}

	public ProductRequest makeProductRequest(Product product) {
		ProductRequest request=RequestResponseUtils.makeProductRequest(product);
		return request;
	}

	
	public List<Supplier> findAllSuppliersSortedByName() {
		return suppRep.findAll(sortByNameAsc());
	}
	
	public Supplier findSupplierBySupplierId(Long supplierId) {
		return suppRep.findBySupplierId(supplierId);
	}

	public void deleteSupplier(Long suppliertId) {
		suppRep.deleteById(suppliertId);		
	}


	public Supplier saveSupplier(SupplierRequest request) {
		Supplier supplier=RequestResponseUtils.makeSupplier(request);
		return suppRep.save(supplier);
	}

	public Supplier updateSupplier(Supplier supplier,SupplierRequest request) {
		supplier=RequestResponseUtils.updateSupplier(supplier,request);
		return suppRep.save(supplier);
	}
	

	public List<SupplierOrder> findAllSupplierOrdersSortedByDate() {
		return suppOrdRep.findAll(sortByDateCreatedDesc());
	}


	public SupplierOrder findSupplierOrderBySupplierOrderId(Long supplierOrderId) {
		return suppOrdRep.findBySupplierOrderId(supplierOrderId);
	}


	public void deleteSupplierOrder(Long supplierOrderId) {
		if(supplierOrderId!=null) {
			suppOrdRep.deleteById(supplierOrderId);
		}
		
	}

	public SupplierOrder saveSupplierOrder(SupplierOrderRequest request) {
		SupplierOrder supplierOrder=RequestResponseUtils.makeSupplierOrder(request);
		supplierOrder=suppOrdRep.save(supplierOrder);
		return supplierOrder;
	}
	
	public SupplierOrder updateSupplierOrder(SupplierOrder supplierOrder, SupplierOrderRequest request) {
		supplierOrder=RequestResponseUtils.updateSupplierOrder(supplierOrder,request);
		supplierOrder=suppOrdRep.save(supplierOrder);
		return supplierOrder;
	}


	public List<Employee> findAllActiveEmployees() {
		List<Employee> activeEmployees=new ArrayList<>();
		List<Employee> employees=employeeRep.findAll(sortByFullnameAsc());
		for (Employee employee : employees) {
			if(employee!=null && employee.getEnabled()!=0) {
				activeEmployees.add(employee);
			}
		}
		return activeEmployees;
	}



	public Configuration saveConfiguration(ConfigurationRequest request) {
		Configuration configuration=RequestResponseUtils.makeConfiguration(request);	
		
		return confRep.save(configuration);
	}

	public List<Configuration> findAllConfigurations() {
		List<Configuration> configurations=confRep.findAll();
		return configurations;
	}
	


	public Configuration findConfigurationByConfigurationId(Long configurationId) {
		Configuration configuration =confRep.findByConfigurationId(configurationId);
		return configuration;
	}
	

	public Configuration getConfiguration() {
		Configuration configuration = null;
		List<Configuration>  configurations = findAllConfigurations();
		for (Configuration configuration2 : configurations) {
			if(null != configuration2) {
				configuration =configuration2;
			}
		}
		
		return configuration;
	}

	public Configuration updateConfiguration(Configuration configuration, ConfigurationRequest request) {
		configuration=RequestResponseUtils.updateConfiguration(configuration, request);
		confRep.save(configuration);
		return configuration;
	}
	

	public void deleteConfiguration(Long configurationtId) {
		Configuration configuration =confRep.findByConfigurationId(configurationtId);
		confRep.delete(configuration);
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

	public void addGraduity(GratuityRequest request) {
		Gratuity gratuity = RequestResponseUtils.makeGratuity(request);
		if(null!=gratuity) {
			gratuityRepository.save(gratuity);
		}
	}

	public List<Gratuity> findAllGraduities() {
		List<Gratuity> gratuities = gratuityRepository.findAll(sortByDateCreatedDesc());
		if(gratuities!=null) {
			log.info("gratuities has "+gratuities.size()+" records");
		} else {
			log.info("gratuities is null ");			
		}
		return gratuities;
	}

	public void deleteGratuity(Long gratuityId) {
		Gratuity gratuity = gratuityRepository.findByGratuityId(gratuityId);
		gratuityRepository.delete(gratuity);
	}

	public List<Inventory> findAllInventory() {
		List<Inventory> inventoryList = inventoryRepository.findAll();
		return inventoryList;
	}

	public void deleteInventory(Long inventoryId) {
		Inventory inventory = inventoryRepository.findByInventoryId(inventoryId);
		inventoryRepository.delete(inventory);		
	}

	public Inventory findInventoryIdByinventoryId(Long inventoryId) {
		Inventory inventory = inventoryRepository.findByInventoryId(inventoryId);
		return inventory;
	}

	public Inventory saveInventory(InventoryRequest request) {
		Inventory inventory = null;
		if(request!=null) {
			
			inventory = RequestResponseUtils.makeInventory(request);
			if(inventory!=null) {
				inventoryRepository.save(inventory);	
			}
		}
		return inventory;
	}

	public Inventory updateInventory(InventoryRequest request) {
		Inventory inventory = null;
		if(request!=null) {
			Long inventoryId = request.getInventoryId();
			inventory = findInventoryIdByinventoryId(inventoryId);
			if(null != inventory) {
				inventory = RequestResponseUtils.updateInventory(inventory, request);
				inventoryRepository.save(inventory);	
				log.info("--> inventory updated : "+inventory);
			}
			
		}
		return inventory;
	}

	public String getCompanyName() {
		if(null==companyName) {
			setConfigurationVariables();
		}
		return companyName;
	}

	public String getBranchName() {
		if(null==branchName) {
			setConfigurationVariables();
		}
		return branchName;
	}

	public String getBranchPhone() {
		if(null==branchPhone) {
			setConfigurationVariables();
		}
		return branchPhone;
	}


	private void setConfigurationVariables() {
		
		List<Configuration> configurations =confRep.findAll();
		Configuration configuration=null;
		for (Configuration theConfiguration : configurations) {
			if(null!= theConfiguration) {
				configuration=theConfiguration;
				break;
			}
		}
		if(null!= configuration) {
			companyName = configuration.getCompanyName();
			branchName  = configuration.getBranchName();
			branchPhone  = configuration.getBranchPhone();
		}
	}


}
