package com.example.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
