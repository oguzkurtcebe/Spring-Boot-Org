package com.oguzkurtcebe.organization.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oguzkurtcebe.organization.model.Invoice;
import com.oguzkurtcebe.organization.service.InvoiceService;

@RestController
@RequestMapping("/restInvoice")
public class InvoiceRestController {

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id) {
		try {
			invoiceService.deleteInvoice(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateInvoice(@PathVariable("id") Long id, @RequestBody Invoice invoice) {
		try {
			invoice.setInvoiceId(id);
			invoiceService.updateInvoice(invoice);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.POST)
	public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice) {

		try {
			invoiceService.createInvoice(invoice);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
	public ResponseEntity<Invoice> getInvoice(@PathVariable("id") Long id) {
		try {
			Invoice invoice = invoiceService.findInvoice(id);
			return ResponseEntity.ok(invoice);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value = "/invoices", method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getInvoices() {
		List<Invoice> list = invoiceService.findInvoices();
		return ResponseEntity.ok(list);
	}

	@RequestMapping(value="/invoice",method=RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getInvoices(@RequestParam("on") String ownerName) {
		List<Invoice> list = invoiceService.findInvoices(ownerName);
		return ResponseEntity.ok(list);
	}

}
