package com.dbs.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DBS_RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DBS_RecordNotFoundException(String message) {
		super(message);
	}
	
	public DBS_RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
