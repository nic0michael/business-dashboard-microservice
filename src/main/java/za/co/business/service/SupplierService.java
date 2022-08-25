package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.model.Supplier;

public interface SupplierService {

	public List<Supplier> findAll(Sort sortByNameAsc);

	public Supplier findBySupplierId(Long supplierId);

	public void deleteById(Long suppliertId);

	public Supplier save(Supplier supplier);

}
