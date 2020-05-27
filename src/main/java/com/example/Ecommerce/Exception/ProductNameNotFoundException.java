package com.example.Ecommerce.Exception;

public class ProductNameNotFoundException extends RuntimeException{
	
	public ProductNameNotFoundException(String productName) {
		super(String.format("productName with %ch not found",productName));
	}

}
