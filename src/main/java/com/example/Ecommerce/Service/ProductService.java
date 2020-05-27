package com.example.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.exception.DemoAccountIdNotFound;
import com.example.Ecommerce.exception.InsufficientBalance;
import com.example.Ecommerce.model.DemoAccount;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.repository.DemoAccountRepository;
import com.example.Ecommerce.repository.OrderRepository;
import com.example.Ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	DemoAccountRepository demoAccountRepository;
	
	public void buyProducts(float amount,long demoAccountNumber) {
	
	DemoAccount demoAccount;
	
	try {
		demoAccount = demoAccountRepository.findByDemoAccountNumber(demoAccountNumber);
	}
	catch(Exception e) {
		throw new DemoAccountIdNotFound();
	}
			
			if(demoAccount.getDemoAccountBalance()>amount) {
				demoAccount.setDemoAccountBalance(demoAccount.getDemoAccountBalance() - (long)amount);
				demoAccountRepository.save(demoAccount);
			}
			else
			{
				throw new InsufficientBalance();
			}
			
		}
	
	public float priceOfProducts() {
		/* Product product; */
		float amount=0;
		while(!productRepository.findAll().iterator().next().getPrice().isNaN()) {
			amount = amount+productRepository.findAll().iterator().next().getPrice();
			System.out.println(amount);
		}
		System.out.println(amount);
		return amount;
	}

}
