package com.example.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.OrderService;
import com.example.Ecommerce.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	UserController userController;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/hello")
	public ResponseEntity<Object> hello() {
		return new ResponseEntity<Object>("hai all",HttpStatus.OK);
		
	}
	
	@PostMapping("/buy")
	public ResponseEntity<Object> buyProducts(@RequestParam int orderId,@RequestParam long demoAccountNumber,@RequestParam long userId){
		userController.isValidUser(userId);
		float amount = productService.priceOfProducts();/* orderService.getAmountOfProductsByOrderId(orderId); */
		productService.buyProducts(amount, demoAccountNumber);
		return new ResponseEntity<Object>("products bought successfully",HttpStatus.OK);
	}

}
