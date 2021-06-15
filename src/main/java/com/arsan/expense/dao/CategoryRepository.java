package com.arsan.expense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arsan.expense.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public List<Category> findByUserId(Integer userId);
	
	public Category findByCategoryIdAndUserId(Integer categoryId, Integer userId);
	
	@Modifying
	@Query("delete from Category c where c.categoryId=:categoryId and c.userId=:userId")
	public void deleteByCategoryIdAndUserId(@Param("categoryId") Integer categoryId, @Param("userId") Integer userId);
}
