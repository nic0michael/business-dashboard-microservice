package za.co.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

	public CustomerOrder findByCustomerOrderId(Long customerId);

}
