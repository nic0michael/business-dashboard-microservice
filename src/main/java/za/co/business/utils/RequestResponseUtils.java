package za.co.business.utils;

import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierRequest;
import za.co.business.model.Product;
import za.co.business.model.Supplier;

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
		
		return product;
	}

}
