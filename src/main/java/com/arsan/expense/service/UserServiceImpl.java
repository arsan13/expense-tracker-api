package com.arsan.expense.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arsan.expense.dao.UserRepository;
import com.arsan.expense.entity.User;
import com.arsan.expense.exception.EtAuthException;


@Service
//@Transactional  // transactional not needed, since jpa provides it
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User validateUser(String email, String password) throws EtAuthException {
		
		if(email == null || password == null)
			throw new EtAuthException("Invalid credentials");
		
		User user = userRepository.findByEmailAndPassword(email, password);
		
		if(user == null)
			throw new EtAuthException("Invalid credentials");
		
		return user;
	}
	
	@Override
	public User registerUser(User user) throws EtAuthException {
		
		if(user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getPassword() == null)
			throw new EtAuthException("Fill all the details");
		
		if(user.getFirstName() == "" || user.getLastName() == "" || user.getEmail() == "" || user.getPassword() == "")
			throw new EtAuthException("Fill all the details");
		
		// Validating email
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		String email = user.getEmail().toLowerCase();
		if(!pattern.matcher(email).matches()) 
			throw new EtAuthException("Invalid email format");
		
		// Check if if email is already in use
		if(userRepository.findByEmail(email) != null)
			throw new EtAuthException("Email already in use");
				
		return userRepository.save(user);
	}

}
