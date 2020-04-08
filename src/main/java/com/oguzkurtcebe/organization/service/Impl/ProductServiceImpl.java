package com.oguzkurtcebe.organization.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzkurtcebe.organization.dao.ProductRepository;
import com.oguzkurtcebe.organization.model.Product;
import com.oguzkurtcebe.organization.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findProducts() {
		List<Product> list = productRepository.findAll();
		return list;
	}

	@Override
	public Product findProduct(Long id) {
		Product product = productRepository.findById(id);
		return product;
	}

	@Override
	public List<Product> findProducts(String category) {
		List<Product> list = productRepository.findByCategory(category);
		return list;
	}

	@Override
	public void createProduct(Product product) {
		productRepository.create(product);

	}

	@Override
	public void updateProduct(Product product) {
		productRepository.update(product);

	}

	@Override
	public void deleteProduct(Long id) {
	
		productRepository.delete(id);

	}

}
