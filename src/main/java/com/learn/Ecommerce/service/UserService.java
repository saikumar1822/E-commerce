package com.learn.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Ecommerce.dto.UserDto;
import com.learn.Ecommerce.exceptions.NullUserObjectException;
import com.learn.Ecommerce.exceptions.UserNotFoundException;
import com.learn.Ecommerce.model.User;
import com.learn.Ecommerce.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User getUser(UserDto userDto) {

		User user = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException();
		}

	}

	public User UpdateUser(User user) {
		if (user != null) {
			return userRepository.save(user);
		} else {
			throw new NullUserObjectException();
		}
	}

}
