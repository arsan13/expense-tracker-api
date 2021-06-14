package com.arsan.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arsan.expense.entity.User;
import com.arsan.expense.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		return userService.validateUser(user.getEmail(), user.getPassword());
	}

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
}
