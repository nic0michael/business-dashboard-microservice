package za.co.business.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;

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
		return custRep.findAll(sortByNameAsc());
	}
	

	public void deleteCustomer(Long customerId) {	
		custRep.deleteById(customerId);
	}

	public Customer findByCustomerId(Long customerId) {
		return custRep.findByCustomerId(customerId);
	}

	public List<CustomerOrder> findAllCustomerOrders() {
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
	
	private Sort sortByDateCreatedAsc() {
        return new Sort(Sort.Direction.ASC, "dateCreated");
    }
	
	private Sort sortByDateCreatedDesc() {
        return new Sort(Sort.Direction.DESC, "dateCreated");
    }

	public void deleteCustomerOrder(Long customerOrderId) {
		custOrdRep.deleteById(customerOrderId);		
	}
	
	public CustomerOrder findByCustomerOrderId(Long customerOrderId) {
		CustomerOrder customerOrder= custOrdRep.findByCustomerOrderId(customerOrderId);
		return customerOrder;
	}

	public List<Product> findAllProducts() {
		return prodRep.findAll(sortByNameAsc());
	}
	

	private Sort sortByNameAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }
	
	public Product findByProductId(Long productId){
		Product product=prodRep.findByProductId(productId);
		return product;
	}


	public List<Supplier> findAllSuppliers() {
		return suppRep.findAll(sortByNameAsc());
	}
	
	public Supplier findBySupplierId(Long supplierId) {
		return suppRep.findBySupplierId(supplierId);
	}

	public void deleteSupplier(Long suppliertId) {
		suppRep.deleteById(suppliertId);		
	}

	public List<SupplierOrder> findAllSupplierOrders() {
		return suppOrdRep.findAll(sortByDateCreatedDesc());
	}

	public Supplier saveSupplier(SupplierRequest request) {
		Supplier supplier=RequestResponseUtils.makeSupplier(request);
		return suppRep.save(supplier);
	}

	public Supplier updateSupplier(Supplier supplier,SupplierRequest request) {
		supplier=RequestResponseUtils.updateSupplier(supplier,request);
		return suppRep.save(supplier);
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

	public void deleteSupplierOrder(Long supplierOrderId) {
		if(supplierOrderId!=null) {
			suppOrdRep.deleteById(supplierOrderId);
		}
		
	}

	public SupplierOrder findBySupplierOrderId(Long supplierOrderId) {
		return suppOrdRep.findBySupplierOrderId(supplierOrderId);
	}

	public CustomerOrder saveCustomerOrder(CustomerOrderRequest request) {
		CustomerOrder customerOrder=RequestResponseUtils.makeCustomerOrder(request);
		customerOrder=custOrdRep.save(customerOrder);
		return customerOrder;
	}
	
	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder, CustomerOrderRequest request) {
		customerOrder=RequestResponseUtils.updateCustomerOrder(customerOrder,request);
		customerOrder=saveCustomerOrder(customerOrder);
		return customerOrder;
	}
	

	public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder) {
		customerOrder=custOrdRep.save(customerOrder);
		return customerOrder;
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








	










	










}
