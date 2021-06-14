package com.arsan.expense.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@GetMapping("")
	public String getCategories(HttpServletRequest request) {
		int userId = (Integer) request.getAttribute("userId");
		return "Authenticated user id: " + userId;
	}
}
