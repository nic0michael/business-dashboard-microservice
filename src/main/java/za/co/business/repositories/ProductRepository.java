package za.co.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByProductId(Long productId);

}
