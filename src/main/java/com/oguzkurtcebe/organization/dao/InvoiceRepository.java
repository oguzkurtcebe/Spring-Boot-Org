package com.oguzkurtcebe.organization.dao;

import java.util.List;

import com.oguzkurtcebe.organization.model.Invoice;

public interface InvoiceRepository {
	void create(Invoice invoice);
	Invoice update(Invoice invoice);
	void delete(Long id);
	Invoice findById(Long id);
	List<Invoice>findAll();
	List<Invoice>findByOwnerName(String ownerName);
}
