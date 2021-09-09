package com.llts.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llts.miniproject.model.Product;
import com.llts.miniproject.service.ProductService;

@RestController
public class ExternalController {


	@Autowired
	ProductService ps;
	
	@GetMapping("/external/products")
	public List<Product> getProducts(){
		return ps.getAllProducts();
	}
}
