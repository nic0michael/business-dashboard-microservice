package za.co.business.service;

import java.util.List;

import za.co.business.model.Inventory;

public interface InventoryService {

	public Inventory findByInventoryId(Long inventoryId);

	public void delete(Inventory inventory);

	public void save(Inventory inventory);

	public List<Inventory> findAll();

}
