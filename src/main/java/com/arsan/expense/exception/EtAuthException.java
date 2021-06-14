package com.arsan.expense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EtAuthException extends RuntimeException {

	public EtAuthException(String message) {
		super(message);
	}
}
