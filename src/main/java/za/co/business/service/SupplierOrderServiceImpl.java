package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import za.co.business.model.SupplierOrder;
import za.co.business.repositories.SupplierOrderRepository;

@Service
public class SupplierOrderServiceImpl implements SupplierOrderService{
	@Autowired
	SupplierOrderRepository suppOrdRep;

	@Override
	public List<SupplierOrder> findAll(Sort sortByDateCreatedDesc) {
		return suppOrdRep. findAll( sortByDateCreatedDesc);
	}

	@Override
	public SupplierOrder findBySupplierOrderId(Long supplierOrderId) {
		return suppOrdRep.findBySupplierOrderId( supplierOrderId) ;
	}

	@Override
	public void deleteById(Long supplierOrderId) {
		suppOrdRep.deleteById( supplierOrderId) ;
		
	}

	@Override
	public SupplierOrder save(SupplierOrder supplierOrder) {
		return suppOrdRep.save( supplierOrder) ;
	}
	

}
