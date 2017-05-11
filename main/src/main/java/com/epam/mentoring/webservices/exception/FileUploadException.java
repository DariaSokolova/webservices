package com.epam.mentoring.webservices.exception;

public class FileUploadException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public FileUploadException() {	}
	
	public FileUploadException(String message) {
		this.message = message;
	}
	
	public FileUploadException(Exception exception) {
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
