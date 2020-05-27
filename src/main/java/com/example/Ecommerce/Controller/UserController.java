package com.example.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.exception.UserNotLoggedIn;
import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	public ResponseEntity<String> isValidUser(@RequestParam long id) {
		User user = userService.getUserById(id);
		if (user.isEnabled()) {
			return new ResponseEntity<String>("user logged in successfully", HttpStatus.OK);
		} else {
			throw new UserNotLoggedIn();
		}
	}

}
