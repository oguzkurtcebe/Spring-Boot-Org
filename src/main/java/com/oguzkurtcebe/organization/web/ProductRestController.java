package com.oguzkurtcebe.organization.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@RequestMapping(value="/getvalue",method=RequestMethod.GET)
	public ResponseEntity<?> getProduct() {
	 String str="\"Burada Product Rest Apisi olacak\";";
	 return ResponseEntity.ok(str);
	}
}
