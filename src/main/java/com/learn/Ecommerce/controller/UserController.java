package com.learn.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Ecommerce.dto.UserDto;
import com.learn.Ecommerce.exceptions.InvalidCredentials;
import com.learn.Ecommerce.model.User;
import com.learn.Ecommerce.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody UserDto userDto) {
		User user = userService.getUser(userDto);
		if (user.getPassword().equals(userDto.getPassword()) && user.getEmail().equals(userDto.getEmail())) {
			user.setEnabled(true);
			userService.UpdateUser(user);
			return new ResponseEntity<String>("logged in successfully", HttpStatus.OK);
		} else {
			throw new InvalidCredentials();
		}
	}

}
