package za.co.business.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import za.co.business.model.Product;

public interface ProductService {

	public List<Product> findAll(Sort sortByNameAsc);

	public Product findByProductId(Long productId);

	public void deleteById(Long productId);

	public Product save(Product product);

}
