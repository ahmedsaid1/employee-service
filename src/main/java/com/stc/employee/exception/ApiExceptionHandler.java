package com.stc.employee.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value = { DepartmentNotExistExciption.class })
	public ResponseEntity<Object> handleApiRequestException(DepartmentNotExistExciption e) {
		ErrorPayload errorPayload = new ErrorPayload(e.getMessage(), "DepartmentNotExistException",
				ZonedDateTime.now(ZoneId.of("Z")).toString());

		return new ResponseEntity<>(errorPayload, org.springframework.http.HttpStatus.BAD_REQUEST);

	}
}
