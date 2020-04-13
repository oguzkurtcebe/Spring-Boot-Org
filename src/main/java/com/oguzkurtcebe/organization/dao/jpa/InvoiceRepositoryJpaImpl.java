package com.oguzkurtcebe.organization.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.oguzkurtcebe.organization.dao.InvoiceRepository;
import com.oguzkurtcebe.organization.model.Invoice;
@Repository("invoiceRepository")
public class InvoiceRepositoryJpaImpl implements InvoiceRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Invoice invoice) {
		entityManager.persist(invoice);

	}

	@Override
	public Invoice update(Invoice invoice) {
		return entityManager.merge(invoice);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Invoice.class,id));

	}

	@Override
	public Invoice findById(Long id) {
		return entityManager.find(Invoice.class, id);
	}

	@Override
	public List<Invoice> findAll() {
		List<Invoice> resultList = entityManager.createQuery("from Invoice", Invoice.class).getResultList();
		return resultList;
	}

	@Override
	public List<Invoice> findByOwnerName(String ownerName) {
		return entityManager.createQuery("from Invoice where ownerName = :ownerName ", Invoice.class)
		.setParameter("ownerName", ownerName).getResultList();
		
	}

}
