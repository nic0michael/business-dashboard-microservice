package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierRequest;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.model.SupplierOrder;
import za.co.business.repositories.CustomerOrderRepository;
import za.co.business.repositories.CustomerRepository;
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
	

	public List<Customer> findAllCustomers() {
		return custRep.findAll();
	}

	public List<CustomerOrder> findAllCustomerOrders() {
		return custOrdRep.findAll();
	}

	public List<Product> findAllProducts() {
		return prodRep.findAll();
	}

	public List<Supplier> findAllSuppliers() {
		return suppRep.findAll();
	}

	public void deleteSupplier(Long suppliertId) {
		suppRep.deleteById(suppliertId);		
	}

	public List<SupplierOrder> findAllSupplierOrders() {
		return suppOrdRep.findAll();
	}

	public Supplier saveSupplier(SupplierRequest request) {
		Supplier supplier=RequestResponseUtils.makeSupplier(request);
		return suppRep.save(supplier);
	}

	public Product saveProduct(ProductRequest request) {
		Product product=RequestResponseUtils.makeRequestResponseUtils(request);
		return prodRep.save(product);
	}

	public Product updateProduct(ProductRequest request) {
		return null;
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

}
