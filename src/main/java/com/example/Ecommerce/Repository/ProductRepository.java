package com.example.Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Ecommerce.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByProductNameLike(String productName);

	

}
