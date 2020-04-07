package com.oguzkurtcebe.organization.service;

import java.util.List;

public interface InvoiceService {
List<InvoiceService>findInvoices();
List<InvoiceService>findInvoices(String ownerName);
InvoiceService findInvoice(Long id);
void createInvoice(InvoiceService invoice);
void updateInvoice(InvoiceService invoice);
void deleteInvoice(Long id);
}
