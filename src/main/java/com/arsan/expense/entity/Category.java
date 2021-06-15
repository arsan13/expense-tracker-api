package com.arsan.expense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column
	private Integer userId;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Transient
	private Double totalExpense;

	public Category() {
	}

	public Category(Integer categoryId, Integer userId, String title, String description, Double totalExpense) {
		this.categoryId = categoryId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.totalExpense = totalExpense;
	}
	
	public Category(Integer categoryId, Integer userId, String title, String description) {
		this.categoryId = categoryId;
		this.userId = userId;
		this.title = title;
		this.description = description;
	}

	public Category(Integer userId, String title, String description) {
		this.userId = userId;
		this.title = title;
		this.description = description;
	}
	
	public Category(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}
}
