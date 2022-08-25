package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.model.Customer;

public interface CustomerService {

	public List<Customer> findAll(Sort sortByNameAsc);

	public Customer findByCustomerId(Long customerId);

	public void deleteById(Long customerId);

	public Customer save(Customer customer) throws Exception;
	

}
