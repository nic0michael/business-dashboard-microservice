package za.co.business.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import za.co.business.dtos.SupplierOrderRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.model.SupplierOrder;
import za.co.business.servicemanagers.EmployeeServiceManager;
import za.co.business.utils.RequestResponseUtils;

@Controller
@RequestMapping("/business-dashboard/supplier-orders")
public class SupplierOrderController {

	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	



	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<SupplierOrder> supplierOrders = processor.findAllSupplierOrders();
		model.addAttribute("supplierOrderList", supplierOrders);
		return "suppliers/list-supplier-orders";		
	}

	@GetMapping(value = "/new")
	public String newSupplierOrder(Model model) {
		SupplierOrderRequest request =new SupplierOrderRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		List<Product> products = processor.findAllProducts();
		model.addAttribute("supplierOrderRequest", request);
		model.addAttribute("productList", products);

		return "suppliers/new-supplier-order";
		
	}
	


	@GetMapping(value = "/edit")
	public String editSupplierOrder(Model model) {
		SupplierOrderRequest request =new SupplierOrderRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		List<Product> products = processor.findAllProducts();
		model.addAttribute("supplierOrderRequest", request);
		model.addAttribute("productList", products);

		return "suppliers/edit-supplier-order";
		
	}


	@PostMapping(value = "/save")
	public String saveOrder(SupplierOrderRequest request,Model model) {
		log.info("SupplierController | saveSupplier | request : "+request);
		if(request!=null) {
			Long productId = request.getProductId();			
			Product product=processor.findByProductId(productId);
			if(product!=null) {
				String productName=product.getName();
				request.setProductName(productName);
				Long supplierId = product.getSupplierId();
				Supplier supplier=processor.findBySupplierId(supplierId);
				if(supplier!=null) {
					String supplierName=supplier.getName();
					request.setSupplierId(supplierId);
					request.setSupplierName(supplierName);
				}
			}
		}
		SupplierOrder supplierorder =processor.saveSupplierOrder(request);
		model.addAttribute("supplierRequest", request);



		List<SupplierOrder> supplierOrders = processor.findAllSupplierOrders();
		model.addAttribute("supplierOrderList", supplierOrders);
		return "suppliers/list-supplier-orders";	
	}
	


	@PostMapping(value = "/update")
	public String updateOrder(SupplierOrderRequest request,Model model) {
		log.info("SupplierController | saveSupplier | request : "+request);
		SupplierOrder supplierOrder=null;
		if(request!=null) {
			Long productId = request.getProductId();			
			Product product=processor.findByProductId(productId);
			
			if(product!=null) {
				String productName=product.getName();
				request.setProductName(productName);
				Long supplierId = product.getSupplierId();
				Supplier supplier=processor.findBySupplierId(supplierId);
				if(supplier!=null) {
					String supplierName=supplier.getName();
					request.setSupplierId(supplierId);
					request.setSupplierName(supplierName);
				}
				Long supplierOrderId=request.getSupplierOrderId();
				supplierOrder=processor.findBySupplierOrderId(supplierOrderId);
			}
		}
		SupplierOrder supplierorder =processor.updateSupplierOrder(supplierOrder,request);

		List<SupplierOrder> supplierOrders = processor.findAllSupplierOrders();
		model.addAttribute("supplierOrderList", supplierOrders);
		return "suppliers/list-supplier-orders";	
	}
	

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long supplierOrderId,Model model) {
		SupplierOrder supplierOrder =processor.findBySupplierOrderId( supplierOrderId);
		SupplierOrderRequest request=RequestResponseUtils.makeSupplierOrderRequest(supplierOrder);
		
		List<Product> products = processor.findAllProducts();
		model.addAttribute("supplierOrderRequest", request);
		model.addAttribute("productList", products);
		return "suppliers/edit-supplier-order";
		
	}

	@GetMapping("/maakdood")
	public String deleteSupplierOrder(@RequestParam(value = "id") Long supplierOrderId,Model model) {
		log.info("BUSINESS : ProductController : deleteProduct : with project_id : "+supplierOrderId);
		processor.deleteSupplierOrder(supplierOrderId);
		return listall(model) ;
		
	}
}
