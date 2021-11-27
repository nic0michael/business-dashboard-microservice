package za.co.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	public Supplier findBySupplierId(Long productId);

}
