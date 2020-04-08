package com.oguzkurtcebe.organization.service;

import java.util.List;

import com.oguzkurtcebe.organization.model.Invoice;

public interface InvoiceService {
List<Invoice>findInvoices();
List<Invoice>findInvoices(String ownerName);
Invoice findInvoice(Long id);
void createInvoice(Invoice invoice);
void updateInvoice(Invoice invoice);
void deleteInvoice(Long id);
}
