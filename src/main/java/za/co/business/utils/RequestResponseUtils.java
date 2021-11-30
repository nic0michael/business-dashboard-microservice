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

	public static Product makeRequestResponseUtils(ProductRequest request) {
		Product product=new Product();
		if(request!=null) {
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

	public static SupplierOrder makeSupplierOrder(SupplierOrderRequest request) {
		SupplierOrder supplierOrder=new SupplierOrder();
		if(request!=null) {
			supplierOrder.setCostPrice(request.getCostPrice());
			supplierOrder.setDateCreated(request.getDateCreated());
			supplierOrder.setName(request.getName());
			supplierOrder.setProductId(request.getProductId());
			supplierOrder.setQuantity(request.getQuantity());
		}
		
		return supplierOrder;
	}

	public static CustomerOrder makeCustomerOrder(CustomerOrderRequest request) {
		CustomerOrder customerOrder=new CustomerOrder();
		if(request!=null) {
			customerOrder.setCustomerId(request.getCustomerId());
			customerOrder.setDateCreated(request.getDateCreated());
			customerOrder.setName(request.getName());
			customerOrder.setProductId(request.getProductId());
			customerOrder.setQuantity(request.getQuantity());
			customerOrder.setSellingPrice(request.getSellingPrice());			
		}
		return customerOrder;
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

}
