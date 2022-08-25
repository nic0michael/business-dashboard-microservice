package za.co.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import za.co.business.model.Product;
import za.co.business.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository prodRep;

	@Override
	public List<Product> findAll(Sort sortByNameAsc) {
		return prodRep.findAll(sortByNameAsc) ;
	}

	@Override
	public Product findByProductId(Long productId) {
		return prodRep.findByProductId(productId) ;
	}

	@Override
	public void deleteById(Long productId) {
		prodRep.deleteById( productId) ;
		
	}

	@Override
	public Product save(Product product) {
		return prodRep.save( product);
	}
	
	

}
