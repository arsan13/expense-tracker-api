package com.arsan.expense.service;

import java.util.List;

import com.arsan.expense.entity.Category;
import com.arsan.expense.exception.EtBadRequestException;
import com.arsan.expense.exception.EtResourceNotFoundException;

public interface CategoryService {

	public List<Category> fetchCategoriesOfUser(Integer userId);
	
	public Category fetchCategoryById(Integer categoryId, Integer userId) throws EtResourceNotFoundException;
	
	public Category saveCategory(Category category) throws EtBadRequestException;
	
	public void removeCategoryById(Integer categoryId, Integer userId) throws EtResourceNotFoundException;
}
