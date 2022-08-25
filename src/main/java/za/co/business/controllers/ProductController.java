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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierRequest;
import za.co.business.helper.BusinessHelper;
import za.co.business.helper.EmployeeHelper;
import za.co.business.model.Employee;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.utils.RequestResponseUtils;

@Controller
@RequestMapping("/business-dashboard/products")
public class ProductController {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
		

	@Autowired
	BusinessHelper processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Product> products = processor.findAllProductsSortedByName();
		model.addAttribute("productList", products);

		return "products/list-products";
		
	}
	

	@GetMapping(value = "/new")
	public String newProduct(Model model) {
		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		ProductRequest request =  new ProductRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		log.info("ProductController | newProduct | suppliers : "+suppliers);
		log.info("ProductController | newProduct | ProductRequest : "+request);
		model.addAttribute("productRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "products/new-product";
		
	}
	

	@PostMapping(value = "/save")
	public String saveProduct(ProductRequest request,Model model) {
		log.info("SupplierController | saveProduct | request : "+request);
		if(request!=null) {
			Long supplierId = request.getSupplierId();
			Supplier supplier=processor.findSupplierBySupplierId(supplierId);
			if(supplier!=null) {
				request.setSupplierName(supplier.getName());
			}
			Product product =processor.saveProduct(request);	
		}

		List<Product> products = processor.findAllProductsSortedByName();
		model.addAttribute("productList", products);
		return "products/list-products";
	}

	@PostMapping(value = "/update")
	public String supdateProduct(ProductRequest request,Model model) {
		log.info("SupplierController | saveProduct | request : "+request);
		if(request!=null) {
			Long supplierId = request.getSupplierId();
			Supplier supplier=processor.findSupplierBySupplierId(supplierId);
			Long productId=request.getProductId();
			Product product=processor.findProductByProductId(productId);
			if(supplier!=null) {
				request.setSupplierName(supplier.getName());
			}
			product =processor.updateProduct(product,request);	
		}

		List<Product> products = processor.findAllProductsSortedByName();
		model.addAttribute("productList", products);
		return "products/list-products";
	}
	

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long productId,Model model) {
		Product product =processor.findProductByProductId(productId);
		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		ProductRequest request =  RequestResponseUtils.makeProductRequest(product);
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		log.info("ProductController | newProduct | suppliers : "+suppliers);
		log.info("ProductController | newProduct | ProductRequest : "+request);
		model.addAttribute("productRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "products/edit-product";
		
	}


	@GetMapping("/maakdood")
	public String deleteProduct(@RequestParam(value = "id") Long productId,Model model) {
		log.info("BUSINESS : ProductController : deleteProduct : with project_id : "+productId);
		processor.deleteProduct(productId);

		return listall(model) ;
		
	}
}
