package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import za.co.business.model.CustomerOrder;
import za.co.business.repositories.CustomerOrderRepository;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
	
	@Autowired
	CustomerOrderRepository custOrdRep;

	@Override
	public List<CustomerOrder> findAll(Sort sortByDateCreatedDesc) {
		return custOrdRep.findAll(sortByDateCreatedDesc);
	}

	@Override
	public List<CustomerOrder> findAllByCustomerId(Long customerId) {
		return custOrdRep.findAllByCustomerId(customerId);
	}

	@Override
	public CustomerOrder findByCustomerOrderId(Long customerOrderId) {
		return custOrdRep.findByCustomerOrderId(customerOrderId);
	}

	@Override
	public void deleteById(Long customerOrderId) {
		custOrdRep.deleteById(customerOrderId);
		
	}

	@Override
	public CustomerOrder save(CustomerOrder customerOrder) {
		return custOrdRep.save(customerOrder);
	}
	
	

}
