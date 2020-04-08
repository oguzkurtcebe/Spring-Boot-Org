package com.oguzkurtcebe.organization.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceRestController {

	@GetMapping
	public String getInvoice() {
		return "Burada Fatura Rest Apisi Olacak!";
	}
}
