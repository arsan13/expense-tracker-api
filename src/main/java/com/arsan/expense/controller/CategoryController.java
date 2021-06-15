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
import com.arsan.expense.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
		
	@GetMapping("")
	public List<Category> getCategoriesOfUser(HttpServletRequest request) {
		int userId = (Integer) request.getAttribute("userId");
		return categoryService.fetchCategoriesOfUser(userId);
	}
	
	@GetMapping("{categoryId}")
	public Category getCategoryById(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		return categoryService.fetchCategoryById(categoryId, userId);
	}
	
	@PostMapping("")
	public Category addCategory(HttpServletRequest request, @RequestBody Category category) {
		int userId = (Integer) request.getAttribute("userId");
		Category categoryToInsert = new Category(userId, category.getTitle(), category.getDescription());
		return categoryService.addCategory(categoryToInsert);
	}
	
	@PutMapping("{categoryId}")
	public Category updateCategory(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId, @RequestBody Category category) {
		int userId = (Integer) request.getAttribute("userId");
		Category categoryToUpdate = new Category(categoryId, userId, category.getTitle(), category.getDescription());
		return categoryService.addCategory(categoryToUpdate);
	}
	
	@DeleteMapping("{categoryId}")
	public String deleteCategory(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId) {
		int userId = (Integer) request.getAttribute("userId");
		categoryService.removeCategoryById(categoryId, userId);
		return "Deleted";
	}
}
