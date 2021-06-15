package com.arsan.expense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EtBadRequestException extends RuntimeException {

	public EtBadRequestException(String message) {
		super(message);
	}
}
