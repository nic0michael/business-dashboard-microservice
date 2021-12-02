package za.co.business.utils;

import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierOrderRequest;
import za.co.business.dtos.SupplierRequest;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.model.SupplierOrder;

public class RequestResponseUtils {

	public static Supplier makeSupplier(SupplierRequest request) {
		Supplier supplier =new Supplier();
		if(request!=null) {
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
		SupplierRequest request=new SupplierRequest();
		if(supplier!= null) {

			if(supplier!=null) {
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
		Product product=new Product();
		if(request!=null) {
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
		ProductRequest request=new ProductRequest();
		if(product!=null) {
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
		SupplierOrder supplierOrder=new SupplierOrder();
		if(request!=null) {
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
		if(supplierOrder!=null) {
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
		CustomerOrder customerOrder=new CustomerOrder();
		return updateCustomerOrder(customerOrder, request);
	}
	

	public static CustomerOrder updateCustomerOrder(CustomerOrder customerOrder, CustomerOrderRequest request) {

		if(request!=null) {
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
		CustomerOrderRequest request=new CustomerOrderRequest();
		if(customerOrder!=null) {
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
		Customer customer =new Customer();
		if(request!=null) {
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
		CustomerRequest request=new CustomerRequest();
		if(customer!=null) {
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

	

	



}
