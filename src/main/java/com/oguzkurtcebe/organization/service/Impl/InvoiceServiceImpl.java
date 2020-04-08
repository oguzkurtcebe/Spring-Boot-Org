package com.oguzkurtcebe.organization.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzkurtcebe.organization.dao.InvoiceRepository;
import com.oguzkurtcebe.organization.model.Invoice;
import com.oguzkurtcebe.organization.service.InvoiceService;
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> findInvoices() {
	List<Invoice> list = invoiceRepository.findAll();
	return list;
	}

	@Override
	public List<Invoice> findInvoices(String ownerName) {
	
		return invoiceRepository.findByOwnerName(ownerName);
	}

	
	@Override
	public Invoice findInvoice(Long id) {
		return invoiceRepository.findById(id);
	}

	@Override
	public void createInvoice(Invoice invoice) {
		invoiceRepository.create(invoice);
		
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		invoiceRepository.update(invoice);
		
	}

	@Override
	public void deleteInvoice(Long id) {
		invoiceRepository.delete(id);
		
	}
   
}
