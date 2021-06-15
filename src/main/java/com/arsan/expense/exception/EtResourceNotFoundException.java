package com.arsan.expense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EtResourceNotFoundException extends RuntimeException {
	
	public EtResourceNotFoundException(String message) {
		super(message);
	}
}
