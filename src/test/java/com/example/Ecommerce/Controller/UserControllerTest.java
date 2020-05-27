package com.example.Ecommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Service.UserService;


import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;

	@Test
	public void testViewProductNameForPositive() {
		List<Product> products = new ArrayList();
		
		Product product = new Product();
		product.setProductid(1);
		product.setProductName("dresses");
		products.add(product);
		
		Mockito.when(userService.viewProductByName("dresses")).thenReturn(products);
		
		ResponseEntity<List<Product>> productRe = userController.viewProductName("dresses");
		Assert.assertNotNull(productRe);
		Assert.assertEquals(HttpStatus.OK, productRe.getStatusCode());
		
	}
	

	@Test(expected = Exception.class)
	public void testViewProductNameForExce() {
		List<Product> products = new ArrayList();
		
		Product product = new Product();
		product.setProductid(1);
		product.setProductName("dresses");
		products.add(product);
		
		Mockito.when(userService.viewProductByName("dresses")).thenThrow(Exception.class);
		
		ResponseEntity<List<Product>> productRe = userController.viewProductName("dresses");
		Assert.assertNotNull(productRe);
		Assert.assertEquals(product.getProductName(), "chudidars");
		
	}

	@Test
	public void testViewProductNameForNegative() {
		List<Product> products = new ArrayList();
		
		Product product = new Product();
		product.setProductid(1);
		product.setProductName("dresses");
		products.add(product);
		
		Product product2 = new Product();
		product.setProductid(2);
		product.setProductName("dresses");
		products.add(product2);
		
		
		Mockito.when(userService.viewProductByName("dresses")).thenReturn(products);
		
		ResponseEntity<List<Product>> productRe = userController.viewProductName("chudidars");
		Assert.assertNotNull(productRe);
		Assert.assertEquals(HttpStatus.OK, productRe.getStatusCode());
		
	}
}
