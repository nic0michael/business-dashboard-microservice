package za.co.business.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.business.dtos.InventoryRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Inventory;

@Controller
@RequestMapping("/business-dashboard/inventory")
public class InventoryController {	
	private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Inventory> inventoryList = processor.findAllInventory();
		if(inventoryList!=null) {
			log.info("gratuities has "+inventoryList.size()+" records");
		} else {
			log.info("gratuities is null ");			
		}
		
		model.addAttribute("gratuityList", inventoryList);
		return "inventory/list-inventory";
		
	}
	
/* TODO
	@PostMapping(value = "/save")
	public String saveProduct(InventoryRequest request,Model model) {
		log.info("SupplierController | saveProduct | request : "+request);
		if(request!=null) {
			Long inventoryId = request.getInventoryId();
			Inventory inventory=processor.findInventoryIdByinventoryId(inventoryId);
			if(inventory!=null) {
				request.setSupplierName(inventory.getName());
			}
			inventory =processor.saveInventory(request);	
		}

		List<Inventory> inventoryList = processor.findAllInventory();	
		model.addAttribute("inventoryList", inventoryList);
		return "inventory/list-inventory";
	}

	@PostMapping(value = "/update")
	public String supdateProduct(InventoryRequest request,Model model) {
		log.info("SupplierController | saveProduct | request : "+request);
		if(request!=null) {
			Long inventoryId = request.getInventoryId();
			Inventory inventory=processor.findInventoryIdByinventoryId(inventoryId);
			
//			set fields here
			

		}

		List<Inventory> inventoryList = processor.findAllInventory();		
		model.addAttribute("gratuityList", inventoryList);
		return "inventory/list-inventory";
	}
*/	
	@GetMapping("/maakdood")
	public String deleteProduct(@RequestParam(value = "id") Long gratuityId,Model model) {
		log.info("BUSINESS : InventoryController : delete graduity : with project_id : "+gratuityId);
		processor.deleteInventory(gratuityId);

		return listall(model) ;
		
	}
	
	

}
