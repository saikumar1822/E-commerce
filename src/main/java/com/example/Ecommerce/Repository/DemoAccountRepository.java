package com.example.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecommerce.model.DemoAccount;

public interface DemoAccountRepository extends JpaRepository<DemoAccount, Long> {

	DemoAccount findByDemoAccountNumber(long demoAccountNumber);

}
