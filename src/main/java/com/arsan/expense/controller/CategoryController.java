package com.arsan.expense.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arsan.expense.entity.Category;
import com.arsan.expense.entity.User;
import com.arsan.expense.service.CategoryService;
import com.arsan.expense.service.UserService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
		
	@Autowired
	UserService userService;
	
	@GetMapping("/categories")
	public List<Category> getCategoriesOfUser(HttpServletRequest request) {
		int userId = (Integer) request.getAttribute("userId");
		return categoryService.fetchCategoriesOfUser(userId);
	}
	
	@GetMapping("/categories/{categoryId}")
	public Category getCategoryById(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		return categoryService.fetchCategoryById(categoryId, userId);
	}
	
	@PostMapping("/categories")
	public Category addCategory(HttpServletRequest request, @RequestBody Category category) {
		int userId = (Integer) request.getAttribute("userId");
		User user = userService.getUserById(userId);
		category.setUser(user);
		return categoryService.saveCategory(category);
	}
	
	@PutMapping("/categories/{categoryId}")
	public Category updateCategory(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId, @RequestBody Category category) {
		int userId = (Integer) request.getAttribute("userId");
		User user = userService.getUserById(userId);
		category.setId(categoryId);
		category.setUser(user);
		return categoryService.saveCategory(category);
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public String deleteCategory(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		categoryService.removeCategoryById(categoryId, userId);
		return "Deleted";
	}
}
