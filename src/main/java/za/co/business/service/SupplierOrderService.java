package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.model.SupplierOrder;

public interface SupplierOrderService {

	public List<SupplierOrder> findAll(Sort sortByDateCreatedDesc);

	public SupplierOrder findBySupplierOrderId(Long supplierOrderId);

	public void deleteById(Long supplierOrderId);

	public SupplierOrder save(SupplierOrder supplierOrder);

}
