package com.cg.exception;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateEmpException extends Exception{
	private List<FieldError> errors;

	public ValidateEmpException() {
		super();

	}

	public ValidateEmpException(String message) {
		super(message);

	}

	public ValidateEmpException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}
	
	
}
