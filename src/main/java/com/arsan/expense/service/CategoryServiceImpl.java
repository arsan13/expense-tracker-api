package com.arsan.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arsan.expense.dao.CategoryRepository;
import com.arsan.expense.entity.Category;
import com.arsan.expense.exception.EtBadRequestException;
import com.arsan.expense.exception.EtResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> fetchCategoriesOfUser(Integer userId){
		return categoryRepository.findByUserId(userId);
	}

	@Override
	public Category fetchCategoryById(Integer categoryId, Integer userId) throws EtResourceNotFoundException {
		try {
			return categoryRepository.findByIdAndUserId(categoryId, userId);
		} catch (Exception e) {
			throw new EtResourceNotFoundException("Resource not found");
		}
	}

	@Override
	public Category saveCategory(Category category) throws EtBadRequestException {
		try {
			return categoryRepository.save(category);
		} catch (Exception e) {
			throw new EtBadRequestException("Invalid request");
		}
	}

	@Override
	public void removeCategoryById(Integer categoryId, Integer userId)
			throws EtResourceNotFoundException {
		try {
			Category category = categoryRepository.findByIdAndUserId(categoryId, userId);
			categoryRepository.delete(category);
		} catch (Exception e) {
			throw new EtResourceNotFoundException("Resource not found");
		}

	}

}
