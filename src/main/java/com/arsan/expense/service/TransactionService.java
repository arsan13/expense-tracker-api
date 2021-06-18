package com.arsan.expense.service;

import java.util.List;

import com.arsan.expense.entity.Transaction;
import com.arsan.expense.exception.EtBadRequestException;
import com.arsan.expense.exception.EtResourceNotFoundException;

public interface TransactionService {
	
	public List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);
	
	public Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

	public Transaction saveTransaction(Transaction transaction) throws EtBadRequestException;
	
	public void removeTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}
