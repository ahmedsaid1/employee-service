package com.stc.employee.exception;

public class DepartmentNotExistExciption extends RuntimeException {

	public DepartmentNotExistExciption(String message) {
		super(message);
	}

	public DepartmentNotExistExciption(String message, Throwable cause) {
		super(message, cause);
	}
}
