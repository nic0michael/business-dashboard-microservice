package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import za.co.business.model.Supplier;
import za.co.business.repositories.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierRepository suppRep;

	@Override
	public List<Supplier> findAll(Sort sortByNameAsc) {
		return suppRep.findAll( sortByNameAsc) ;
	}

	@Override
	public Supplier findBySupplierId(Long supplierId) {
		return suppRep.findBySupplierId(supplierId) ;
	}

	@Override
	public void deleteById(Long suppliertId) {
		suppRep.deleteById(suppliertId) ;
		
	}

	@Override
	public Supplier save(Supplier supplier) {
		return suppRep.save(supplier) ;
	}
	

}
