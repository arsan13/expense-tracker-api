package com.arsan.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arsan.expense.dao.TransactionRepository;
import com.arsan.expense.entity.Transaction;
import com.arsan.expense.exception.EtBadRequestException;
import com.arsan.expense.exception.EtResourceNotFoundException;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId) {
		return transactionRepository.findByUserIdAndCategoryId(userId, categoryId); 
	}

	@Override
	public Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId)
			throws EtResourceNotFoundException {
		try {
			return transactionRepository.findByUserIdAndCategoryIdAndId(userId, categoryId, transactionId);
		} catch (Exception e) {
			throw new EtResourceNotFoundException("Resource not found");
		}
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) throws EtBadRequestException {
		try {
			return transactionRepository.save(transaction);
		} catch (Exception e) {
			throw new EtResourceNotFoundException("Invalid input");
		}
	}

	@Override
	public void removeTransactionById(Integer userId, Integer categoryId, Integer transactionId)
			throws EtResourceNotFoundException {
		try {
			Transaction transaction = transactionRepository.findByUserIdAndCategoryIdAndId(userId, categoryId, transactionId);
			transactionRepository.delete(transaction);
		} catch (Exception e) {
			throw new EtResourceNotFoundException("Resource not found");
		}
		
	}

}
