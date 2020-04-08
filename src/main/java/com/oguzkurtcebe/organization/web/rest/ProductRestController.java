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

import com.oguzkurtcebe.organization.model.Product;
import com.oguzkurtcebe.organization.service.ProductService;

@RestController
@RequestMapping("/restProduct")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		try {
			productService.createProduct(product);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value="product/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?>updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
		try {
			product.setProductId(id);
			productService.updateProduct(product);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?>deleteProduct(@PathVariable("id") Long id){
		try {
		
			productService.deleteProduct(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
		Product product = productService.findProduct(id);
		return ResponseEntity.ok(product);
	}


	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productService.findProducts();
		return ResponseEntity.ok(products);
	}
}
