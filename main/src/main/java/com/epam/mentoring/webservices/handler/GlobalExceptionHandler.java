package com.epam.mentoring.webservices.handler;

import org.hibernate.HibernateException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HibernateException.class)
	public String handleDatabaseException(HibernateException ex, Model model) {
		model.addAttribute("message", ex.getMessage());
		return "databaseError";
	}
}
