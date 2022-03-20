package za.co.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	Inventory findByInventoryId(Long inventoryId);
	

}
