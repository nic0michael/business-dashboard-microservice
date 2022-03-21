package za.co.business.controllers;

import java.sql.Timestamp;
import java.util.Date;
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
import za.co.business.dtos.InventoryRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Inventory;
import za.co.business.model.Supplier;
import za.co.business.utils.RequestResponseUtils;

@Controller
@RequestMapping("/business-dashboard/inventory")
public class InventoryController {
	private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

	@Autowired
	BusinessLogicProcessor processor;

	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Inventory> inventoryList = processor.findAllInventory();
		if (inventoryList != null) {
			log.info("inventoryList has " + inventoryList.size() + " records");
		} else {
			log.info("inventoryList is null ");
		}

		model.addAttribute("inventoryList", inventoryList);
		return "inventory/list-inventory";

	}

	@GetMapping(value = "/new")
	public String newInventory(Model model) {
		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		InventoryRequest request = new InventoryRequest();
		Timestamp dateCreated = new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		log.info("InventoryController | newInventory | suppliers : " + suppliers);
		log.info("InventoryController | newInventory | InventoryRequest : " + request);
		model.addAttribute("inventoryRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "inventory/new-inventory";

	}

	@PostMapping(value = "/save")
	public String saveInventory(InventoryRequest request, Model model) {
		log.info("SupplierController | saveInventory | request : " + request);
		Inventory inventory = null;
		if (request != null) {
			Long supplierId = request.getSupplierId();
			if (null != supplierId) {
				Supplier supplier = processor.findSupplierBySupplierId(supplierId);
				if (null != supplier) {
					String supplierName = supplier.getName();
					request.setSupplierName(supplierName);
				}
			}
			inventory = processor.saveInventory(request);
		}

		List<Inventory> inventoryList = processor.findAllInventory();
		model.addAttribute("inventoryList", inventoryList);
		return "inventory/list-inventory";
	}

	@PostMapping(value = "/update")
	public String updateInventory(InventoryRequest request, Model model) {
		log.info("SupplierController | saveInventory | request : " + request);

		if (request != null) {
			Long supplierId = request.getSupplierId();
			if (null != supplierId) {
				Supplier supplier = processor.findSupplierBySupplierId(supplierId);
				if (null != supplier) {
					String supplierName = supplier.getName();
					request.setSupplierName(supplierName);
				}
			}
			Inventory inventory = processor.updateInventory(request);
		}

		List<Inventory> inventoryList = processor.findAllInventory();
		if (inventoryList != null) {
			log.info("inventoryList has " + inventoryList.size() + " records");
		} else {
			log.info("inventoryList is null ");
		}

		model.addAttribute("inventoryList", inventoryList);
		return "inventory/list-inventory";
	}

	@PostMapping(value = "/receive")
	public String receiveInventory(InventoryRequest request, Model model) {
		log.info("SupplierController | saveInventory | request : " + request);

		if (request != null) {
			Long supplierId = request.getSupplierId();
			Double reorderQuantity = request.getReorderQuantity();
			Long inventoryId = request.getInventoryId();

			if (null != inventoryId) {
				Inventory inventory = processor.findInventoryIdByinventoryId(inventoryId);

				if (null != inventory) {
					Double stockQuantity = inventory.getStockQuantity();
					if(stockQuantity ==null) {
						stockQuantity=0D;
					}
					
					

					if (null != reorderQuantity) {
						
						stockQuantity += reorderQuantity;

						if (null != supplierId) {
							Supplier supplier = processor.findSupplierBySupplierId(supplierId);
							if (null != supplier) {
								String supplierName = supplier.getName();
								request.setSupplierName(supplierName);
								request.setStockQuantity(stockQuantity);
							}
						}
						inventory = processor.updateInventory(request);
					}
				}
			}
		}

		List<Inventory> inventoryList = processor.findAllInventory();
		if (inventoryList != null) {
			log.info("inventoryList has " + inventoryList.size() + " records");
		} else {
			log.info("inventoryList is null ");
		}

		model.addAttribute("inventoryList", inventoryList);
		return "inventory/list-inventory";
	}

	@GetMapping("/maakdood")
	public String deleteInventory(@RequestParam(value = "id") Long inventoryId, Model model) {
		log.info("BUSINESS : InventoryController : delete graduity : with project_id : " + inventoryId);
		processor.deleteInventory(inventoryId);

		return listall(model);

	}

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long inventoryId, Model model) {
		Inventory inventory = processor.findInventoryIdByinventoryId(inventoryId);
		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		InventoryRequest request = RequestResponseUtils.makeInventoryRequest(inventory);
		Timestamp dateCreated = new Timestamp(new Date().getTime());
		request.setInventoryId(inventoryId);
		request.setDateCreated(dateCreated);
		log.info("InventoryController | newInventory | suppliers : " + suppliers);
		log.info("Inventoryontroller | newInventory | InventoryRequest : " + request);
		model.addAttribute("inventoryRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "inventory/edit-inventory";

	}

	@GetMapping("/ontvang")
	public String ontvang(@RequestParam(value = "id") Long inventoryId, Model model) {
		Inventory inventory = processor.findInventoryIdByinventoryId(inventoryId);
		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		List<Inventory> inventoryList = processor.findAllInventory();
		InventoryRequest request = RequestResponseUtils.makeInventoryRequest(inventory);
		Timestamp dateCreated = new Timestamp(new Date().getTime());
		request.setInventoryId(inventoryId);
		request.setDateCreated(dateCreated);
		log.info("InventoryController | newInventory | suppliers : " + suppliers);
		log.info("Inventoryontroller | newInventory | InventoryRequest : " + request);
		model.addAttribute("inventoryRequest", request);
		model.addAttribute("supplierList", suppliers);
		model.addAttribute("inventoryList", inventoryList);

		return "inventory/receive-inventory";

	}

}
