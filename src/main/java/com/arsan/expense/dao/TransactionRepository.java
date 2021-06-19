package com.arsan.expense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arsan.expense.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	public List<Transaction> findByUserIdAndCategoryId(Integer userId, Integer categoryId);
	
	public Transaction findByUserIdAndCategoryIdAndId(Integer userId, Integer categoryId, Integer transactionId);
}
