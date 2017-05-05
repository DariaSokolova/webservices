package com.epam.mentoring.webservices.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public ServiceException() {	}
	
	public ServiceException(String message) {
		this.message = message;
	}
	
	public ServiceException(Exception exception) {
		this.message = exception.getMessage();
		this.setStackTrace(exception.getStackTrace());
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
