package com.arsan.expense.service;

import com.arsan.expense.entity.User;
import com.arsan.expense.exception.EtAuthException;

public interface UserService {

	public User validateUser(String email, String password) throws EtAuthException;
	
	public User registerUser(User user) throws EtAuthException;
	
	public User getUserById(Integer id) throws EtAuthException;
	
}
