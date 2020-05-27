package com.example.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
