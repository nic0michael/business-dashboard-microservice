package za.co.business.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import za.co.business.model.Gratuity;
import za.co.business.model.Inventory;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.model.SupplierOrder;

public class RequestResponseUtils {
	private static final Logger log = LoggerFactory.getLogger(RequestResponseUtils.class);

	public static Configuration makeConfiguration(ConfigurationRequest request) {
		Configuration configuration = new Configuration();
		return updateConfiguration(configuration, request);
	}

	public static Configuration updateConfiguration(Configuration configuration, ConfigurationRequest request) {
		if (configuration != null && request != null) {
			configuration.setDateCreated(request.getDateCreated());
			configuration.setCompanyName(request.getCompanyName());
			configuration.setBranchName(request.getBranchName());
			configuration.setBranchPhone(request.getBranchPhone());
			configuration.setIndustry(request.getIndustry());
			configuration.setEmail(request.getEmail());
			configuration.setEnabled(request.getEnabled());
			configuration.setDiscount(request.getDiscount());

		}
		return configuration;
	}

	public static ConfigurationRequest makeConfigurationRequest(Configuration configuration) {
		ConfigurationRequest request = new ConfigurationRequest();
		if (configuration != null) {
			request.setDateCreated(configuration.getDateCreated());
			request.setCompanyName(configuration.getCompanyName());
			request.setBranchName(configuration.getBranchName());
			request.setBranchPhone(configuration.getBranchPhone());
			request.setIndustry(configuration.getIndustry());
			request.setEmail(configuration.getEmail());
			request.setEnabled(configuration.getEnabled());
			request.setConfigurationId(configuration.getConfigurationId());
			request.setDiscount(configuration.getDiscount());

		}
		return request;
	}

	public static Supplier makeSupplier(SupplierRequest request) {
		Supplier supplier = new Supplier();
		return updateSupplier(supplier, request);
	}

	public static Supplier updateSupplier(Supplier supplier, SupplierRequest request) {

		if (supplier != null && request != null) {
			supplier.setCellPhone(request.getCellPhone());
			supplier.setContactName(request.getContactName());
			supplier.setDateCreated(request.getDateCreated());
			supplier.setEmailAddress(request.getEmailAddress());
			supplier.setName(request.getName());
			supplier.setPhone(request.getPhone());
			supplier.setPhysicalAddress(request.getPhysicalAddress());
			supplier.setPostalAddress(request.getPostalAddress());
		}

		return supplier;
	}

	public static SupplierRequest makeSupplierRequest(Supplier supplier) {
		SupplierRequest request = new SupplierRequest();
		if (supplier != null) {

			if (supplier != null) {
				request.setSupplierId(supplier.getSupplierId());
				request.setCellPhone(supplier.getCellPhone());
				request.setContactName(supplier.getContactName());
				request.setDateCreated(supplier.getDateCreated());
				request.setEmailAddress(supplier.getEmailAddress());
				request.setName(supplier.getName());
				request.setPhone(supplier.getPhone());
				request.setPhysicalAddress(supplier.getPhysicalAddress());
				request.setPostalAddress(supplier.getPostalAddress());
			}
		}
		return request;
	}

	public static Product makeRequestResponseUtils(ProductRequest request) {
		Product product = new Product();
		return makeUpdateRequestResponseUtils(product, request);
	}

	public static Product makeUpdateRequestResponseUtils(Product product, ProductRequest request) {
		if (request != null) {
			product.setSupplierName(request.getSupplierName());
			product.setProductCode(request.getProductCode());
			product.setCostPrice(request.getCostPrice());
			product.setDateCreated(request.getDateCreated());
			product.setDescription(request.getDescription());
			product.setEconomicOrderQuantity(request.getEconomicOrderQuantity());
			product.setFileImageId(request.getFileImageId());
			product.setName(request.getName());
			product.setReorderLevel(request.getReorderLevel());
			product.setSellingPrice(request.getSellingPrice());
			product.setStockQuantity(request.getStockQuantity());
			product.setSupplierId(request.getSupplierId());
		}

		return product;
	}

	public static ProductRequest makeProductRequest(Product product) {
		ProductRequest request = new ProductRequest();
		return editProductRequest(product, request);
	}

	public static ProductRequest editProductRequest(Product product, ProductRequest request) {
		if (product != null && request != null) {
			request.setName(product.getName());
			request.setProductId(product.getProductId());
			request.setSupplierName(product.getSupplierName());
			request.setProductCode(product.getProductCode());
			request.setCostPrice(product.getCostPrice());
			request.setDateCreated(product.getDateCreated());
			request.setDescription(product.getDescription());
			request.setEconomicOrderQuantity(product.getEconomicOrderQuantity());
			request.setFileImageId(product.getFileImageId());
			request.setName(product.getName());
			request.setReorderLevel(product.getReorderLevel());
			request.setSellingPrice(product.getSellingPrice());
			request.setStockQuantity(product.getStockQuantity());
			request.setSupplierId(product.getSupplierId());

		}
		return request;
	}

	public static SupplierOrder makeSupplierOrder(SupplierOrderRequest request) {
		SupplierOrder supplierOrder = new SupplierOrder();
		return updateSupplierOrder(supplierOrder, request);
	}

	public static SupplierOrder updateSupplierOrder(SupplierOrder supplierOrder, SupplierOrderRequest request) {
		if (supplierOrder != null && request != null) {
			supplierOrder.setProductId(request.getProductId());
			supplierOrder.setProductName(request.getProductName());
			supplierOrder.setSupplierId(request.getSupplierId());
			supplierOrder.setSupplierName(request.getSupplierName());
			supplierOrder.setCostPrice(request.getCostPrice());
			supplierOrder.setDateCreated(request.getDateCreated());
			supplierOrder.setName(request.getName());
			supplierOrder.setProductId(request.getProductId());
			supplierOrder.setQuantity(request.getQuantity());
		}
		return supplierOrder;
	}

	public static SupplierOrderRequest makeSupplierOrderRequest(SupplierOrder supplierOrder) {
		SupplierOrderRequest request = new SupplierOrderRequest();
		return editSupplierOrderRequest(request, supplierOrder);
	}

	public static SupplierOrderRequest editSupplierOrderRequest(SupplierOrderRequest request,
			SupplierOrder supplierOrder) {
		if (supplierOrder != null && request != null) {
			request.setSupplierOrderId(supplierOrder.getSupplierOrderId());
			request.setProductId(supplierOrder.getProductId());
			request.setProductName(supplierOrder.getProductName());
			request.setSupplierId(supplierOrder.getSupplierId());
			request.setSupplierName(supplierOrder.getSupplierName());
			request.setCostPrice(supplierOrder.getCostPrice());
			request.setDateCreated(supplierOrder.getDateCreated());
			request.setName(supplierOrder.getName());
			request.setProductId(supplierOrder.getProductId());
			request.setQuantity(supplierOrder.getQuantity());
		}
		return request;
	}

	public static CustomerOrder makeCustomerOrder(CustomerOrderRequest request) {
		CustomerOrder customerOrder = new CustomerOrder();
		return updateCustomerOrder(customerOrder, request);
	}

	public static CustomerOrder updateCustomerOrder(CustomerOrder customerOrder, CustomerOrderRequest request) {

		if (request != null) {
			customerOrder.setEmployeeFullname(request.getEmployeeFullname());
			customerOrder.setEmployeeId(request.getEmployeeId());
			customerOrder.setOrderCompleted(request.getOrderCompleted());
			customerOrder.setCustomerRequirements(request.getCustomerRequirements());
			customerOrder.setCustomerId(request.getCustomerId());
			customerOrder.setCustomerName(request.getCustomerName());
			customerOrder.setDateCreated(request.getDateCreated());
			customerOrder.setName(request.getName());
			customerOrder.setProductId(request.getProductId());
			customerOrder.setProductName(request.getProductName());
			customerOrder.setQuantity(request.getQuantity());
			customerOrder.setSellingPrice(request.getSellingPrice());
		}

		return customerOrder;
	}

	public static CustomerOrderRequest makeCustomerOrderRequest(CustomerOrder customerOrder) {
		CustomerOrderRequest request = new CustomerOrderRequest();
		if (customerOrder != null) {
			request.setCustomerOrderId(customerOrder.getCustomerOrderId());
			request.setCustomerRequirements(customerOrder.getCustomerRequirements());
			request.setCustomerId(customerOrder.getCustomerId());
			request.setCustomerName(customerOrder.getCustomerName());
			request.setDateCreated(customerOrder.getDateCreated());
			request.setName(customerOrder.getName());
			request.setProductId(customerOrder.getProductId());
			request.setProductName(customerOrder.getProductName());
			request.setQuantity(customerOrder.getQuantity());
			request.setSellingPrice(customerOrder.getSellingPrice());
		}
		return request;
	}

	public static Customer makeCustomer(CustomerRequest request) {
		Customer customer = new Customer();
		return updateCustomer(customer, request);
	}

	public static Customer updateCustomer(Customer customer, CustomerRequest request) {
		if (request != null && customer != null) {
			customer.setCellPhone(request.getCellPhone());
			customer.setCredits(request.getCredits());
			customer.setDateCreated(request.getDateCreated());
			customer.setDeliveryAddress(request.getDeliveryAddress());
			customer.setEmailAddress(request.getEmailAddress());
			customer.setInvoiceAddress(request.getInvoiceAddress());
			customer.setName(request.getName());
		}
		return customer;
	}

	public static CustomerRequest makeCustomerRequest(Customer customer) {
		CustomerRequest request = new CustomerRequest();
		if (customer != null) {
			request.setCustomerId(customer.getCustomerId());
			request.setCellPhone(customer.getCellPhone());
			request.setCredits(customer.getCredits());
			request.setDateCreated(customer.getDateCreated());
			request.setDeliveryAddress(customer.getDeliveryAddress());
			request.setEmailAddress(customer.getEmailAddress());
			request.setInvoiceAddress(customer.getInvoiceAddress());
			request.setName(customer.getName());

		}
		return request;
	}

	public static Gratuity makeGratuity(GratuityRequest request) {
		Gratuity gratuity = new Gratuity();

		log.info("---> request " + request);

		gratuity.setCustomerId(request.getCustomerId());
		gratuity.setCustomerName(request.getCustomerName());
		gratuity.setDateCreated(request.getDateCreated());
		gratuity.setEmployeeFullname(request.getEmployeeFullname());
		gratuity.setEmployeeId(request.getEmployeeId());
		gratuity.setGratuityPaid(request.getGratuityPaid());
		gratuity.setNrOfOrdersNotPaid(request.getNrOfOrdersNotPaid());
		gratuity.setComments(request.getComments());

		return gratuity;
	}

	public static Inventory makeInventory(InventoryRequest request) {
		Inventory inventory = new Inventory();

		inventory.setCostPrice(request.getCostPrice());
		inventory.setDescription(request.getDescription());
		inventory.setEconomicOrderQuantity(request.getEconomicOrderQuantity());
		inventory.setName(request.getName());
		inventory.setReorderLevel(request.getReorderLevel());
		inventory.setStockCode(request.getStockCode());
		inventory.setStockQuantity(request.getStockQuantity());
		inventory.setSupplierId(request.getSupplierId());
		inventory.setSupplierName(request.getSupplierName());
		inventory.setSupplierstockCode(request.getSupplierstockCode());
		inventory.setSupplierName(request.getSupplierName());
		inventory.setDateCreated(request.getDateCreated());

		return inventory;
	}

	public static Inventory updateInventory(Inventory inventory, InventoryRequest request) {

		if (null != request.getCostPrice()) {
			inventory.setCostPrice(request.getCostPrice());
		}
		if (null != request.getDescription()) {
			inventory.setDescription(request.getDescription());

		}
		if (null != request.getEconomicOrderQuantity()) {
			inventory.setEconomicOrderQuantity(request.getEconomicOrderQuantity());

		}
		if (null != request.getName()) {
			inventory.setName(request.getName());

		}
		if (null != request.getReorderLevel()) {
			inventory.setReorderLevel(request.getReorderLevel());

		}
		if (null != request.getStockCode()) {
			inventory.setStockCode(request.getStockCode());

		}
		if (null != request.getStockQuantity()) {
			inventory.setStockQuantity(request.getStockQuantity());

		}
		if (null != request.getSupplierId()) {
			inventory.setSupplierId(request.getSupplierId());

		}
		if (null != request.getSupplierName()) {
			inventory.setSupplierName(request.getSupplierName());
		}
		

		if (null != request.getDateCreated()) {
			inventory.setDateCreated(request.getDateCreated());
		}
		
		if (null != request.getSupplierstockCode()) {
			inventory.setSupplierstockCode(request.getSupplierstockCode());
		}
		

		
		if (null != request.getSupplierName()) {
			inventory.setSupplierName(request.getSupplierName());
		}

		
		if (null != request.getDateCreated()) {
			inventory.setDateCreated(request.getDateCreated());
		}
		


		return inventory;
	}

	public static InventoryRequest makeInventoryRequest(Inventory inventory) {
		InventoryRequest request = new InventoryRequest();
		



		if (null != inventory.getCostPrice()) {
			request.setCostPrice(inventory.getCostPrice());
		}
		if (null != inventory.getDescription()) {
			request.setDescription(inventory.getDescription());

		}
		if (null != inventory.getEconomicOrderQuantity()) {
			request.setEconomicOrderQuantity(inventory.getEconomicOrderQuantity());

		}
		if (null != inventory.getName()) {
			request.setName(inventory.getName());

		}
		if (null != inventory.getReorderLevel()) {
			request.setReorderLevel(inventory.getReorderLevel());

		}
		if (null != inventory.getStockCode()) {
			request.setStockCode(inventory.getStockCode());

		}
		if (null != inventory.getStockQuantity()) {
			request.setStockQuantity(inventory.getStockQuantity());

		}
		if (null != inventory.getSupplierId()) {
			request.setSupplierId(inventory.getSupplierId());

		}
		if (null != inventory.getSupplierName()) {
			request.setSupplierName(inventory.getSupplierName());
		}
		

		if (null != inventory.getDateCreated()) {
			request.setDateCreated(inventory.getDateCreated());
		}

		
		if (null != inventory.getSupplierstockCode()) {
			request.setSupplierstockCode(inventory.getSupplierstockCode());
		}
		
		return request;
	}

}
