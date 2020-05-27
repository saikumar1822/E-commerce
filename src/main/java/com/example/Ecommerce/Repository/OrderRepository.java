package com.example.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
