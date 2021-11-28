package za.co.business.utils;

import za.co.business.dtos.SupplierRequest;
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

}
