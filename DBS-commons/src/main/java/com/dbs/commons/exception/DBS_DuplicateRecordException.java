package com.dbs.commons.exception;

public class DBS_DuplicateRecordException extends Exception{
private static final long serialVersionUID = 1L;
	
	public DBS_DuplicateRecordException(String message) {
		super(message);
	}
	
	public DBS_DuplicateRecordException(String message, Throwable t) {
		super(message, t);
	}
}
