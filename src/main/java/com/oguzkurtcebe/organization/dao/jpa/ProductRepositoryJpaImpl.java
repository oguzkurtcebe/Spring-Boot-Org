package com.oguzkurtcebe.organization.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.oguzkurtcebe.organization.dao.ProductRepository;
import com.oguzkurtcebe.organization.model.Product;

public class ProductRepositoryJpaImpl implements ProductRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Product product) {
		entityManager.persist(product);

	}

	@Override
	public Product update(Product product) {
		return entityManager.merge(product);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(id);

	}

	@Override
	public Product findById(Long id) {
		Product product = entityManager.find(Product.class, id);
		return product;
	}

	@Override
	public List<Product> findByCategory(String category) {
		List<Product> resultList = entityManager.createQuery("from Product where category = : category", Product.class)
				.setParameter("category", category).getResultList();
		return resultList;
	}

	@Override
	public List<Product> findAll() {
		List<Product> resultList = entityManager.createQuery("from Product", Product.class).getResultList();
		return resultList;
	}

}
