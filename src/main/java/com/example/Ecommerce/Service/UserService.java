package com.example.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}
	
	

}
