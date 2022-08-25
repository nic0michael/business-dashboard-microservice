package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.business.model.Inventory;
import za.co.business.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Inventory findByInventoryId(Long inventoryId) {
		 return  inventoryRepository.findByInventoryId( inventoryId) ;
	}

	@Override
	public void delete(Inventory inventory) {
		inventoryRepository.delete(inventory) ;
		
	}

	@Override
	public void save(Inventory inventory) {
		 inventoryRepository.save( inventory) ;
		
	}

	@Override
	public List<Inventory> findAll() {
		 return  inventoryRepository. findAll() ;
	}
	
}
