package com.arsan.expense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arsan.expense.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public List<Category> findByUserId(Integer id);
	
	public Category findByIdAndUserId(Integer categoryId, Integer userId);
	
}
