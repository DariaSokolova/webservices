package com.epam.mentoring.webservices.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.epam.mentoring.webservices.bean.Task;

public class TaskControllerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Task.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "title.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creationDate", "creationDate.incorrect");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deadLine", "deadLine.incorrect");
	}

}
