package com.arsan.expense.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arsan.expense.Constants;
import com.arsan.expense.dao.UserRepository;
import com.arsan.expense.entity.User;
import com.arsan.expense.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("users/login")
	public Map<String, String> loginUser(@RequestBody User user) {
		return generateJWTToken(userService.validateUser(user.getEmail(), user.getPassword()));
	}

	@PostMapping("users/register")
	public Map<String, String> registerUser(@RequestBody User user) {
		return generateJWTToken(userService.registerUser(user));
	}
	
	private Map<String, String> generateJWTToken(User user) {
		long timeStamp = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
				.setIssuedAt(new Date(timeStamp))
				.setExpiration(new Date(timeStamp + Constants.TOKEN_VALIDITY))
				.claim("userId", user.getId())
				.claim("firstName", user.getFirstName())
				.claim("lastName", user.getLastName())
				.claim("email", user.getEmail())
				.compact();
		
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		
		return map;
	}
}
