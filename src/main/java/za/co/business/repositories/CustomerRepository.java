package za.co.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByCustomerId(Long customerId);

}
