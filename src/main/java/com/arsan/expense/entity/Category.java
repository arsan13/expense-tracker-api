package com.arsan.expense.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	
	@Transient
	private Double totalExpense;
	
	@JsonIgnore
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	public Category() {
	}

	public Category(Integer id, String title, String description, Double totalExpense, User user) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalExpense = totalExpense;
		this.user = user;
	}
	
	public Category(Integer id, String title, String description, Double totalExpense) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.totalExpense = totalExpense;
	}
	
	public Category(Integer id, String title, String description, User user) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.user = user;
	}

	public Category(String title, String description, User user) {
		this.title = title;
		this.description = description;
		this.user = user;
	}
	
	public Category(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
