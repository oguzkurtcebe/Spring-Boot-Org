package com.oguzkurtcebe.organization.service;

import java.util.List;

import com.oguzkurtcebe.organization.model.Product;

public interface ProductService {
	List<Product> findProducts();

	Product findProduct(Long id);

	List<Product> findProducts(String category);
  
	void createProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Long id);

}
