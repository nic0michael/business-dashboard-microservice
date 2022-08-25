package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import za.co.business.model.Customer;
import za.co.business.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository custRep;

	@Override
	public List<Customer> findAll(Sort sortByNameAsc) {
		return custRep.findAll( sortByNameAsc);
	}

	@Override
	public Customer findByCustomerId(Long customerId) {
		return custRep.findByCustomerId(customerId);
	}

	@Override
	public void deleteById(Long customerId) {
		custRep.deleteById(customerId);
		
	}

	@Override
	public Customer save(Customer customer) {
		return custRep.save(customer);
	}
	

	private Sort sortByDateCreatedAsc() {
        return new Sort(Sort.Direction.ASC, "dateCreated");
    }
	
	private Sort sortByDateCreatedDesc() {
        return new Sort(Sort.Direction.DESC, "dateCreated");
    }

	private Sort sortByNameAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }



	private Sort sortByFullnameAsc() {
        return new Sort(Sort.Direction.ASC, "fullName");
    }
}
