package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.model.CustomerOrder;

public interface CustomerOrderService {

	public List<CustomerOrder> findAll(Sort sortByDateCreatedDesc);

	public List<CustomerOrder> findAllByCustomerId(Long customerId);

	public CustomerOrder findByCustomerOrderId(Long customerOrderId);

	public void deleteById(Long customerOrderId);

	public CustomerOrder save(CustomerOrder customerOrder);

}
