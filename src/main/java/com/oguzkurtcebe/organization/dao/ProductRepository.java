package com.oguzkurtcebe.organization.dao;

import java.util.List;

import com.oguzkurtcebe.organization.model.Product;

public interface ProductRepository {

	void create(Product product);

	Product update(Product product);

	void delete(Long id);

	Product findById(Long id);

	List<Product> findByCategory(String category);

	List<Product> findAll();
}
