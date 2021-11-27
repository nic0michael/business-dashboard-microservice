package za.co.business.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import za.co.business.dtos.ProductRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Employee;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.servicemanagers.EmployeeServiceManager;

@Controller
@RequestMapping("/business-dashboard/products")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
		

	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Product> products = processor.findAllProducts();
		model.addAttribute("productList", products);

		return "products/list-products";
		
	}
	

	@GetMapping(value = "/new")
	public String newProduct(Model model) {
		List<Supplier> suppliers = processor.findAllSuppliers();
		ProductRequest request =  new ProductRequest();
		model.addAttribute("productRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "products/new-product";
		
	}

	@GetMapping(value = "/verander/{id}")
	public String verander(@PathVariable String id,Model model) {
		log.info("ProductController | verander | id : "+id);
		List<Supplier> suppliers = processor.findAllSuppliers();
		ProductRequest request =  new ProductRequest();
		model.addAttribute("productRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "products/new-product";
		
	}

	@GetMapping(value = "maakdood/{id}")
	public String maakdood(@PathVariable String id,Model model) {
		log.info("ProductController | maakdood | id : "+id);

		return listall(model) ;
		
	}
}
