package com.epam.mentoring.webservices.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.epam.mentoring.webservices.bean.User;

public class UserControllerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "surname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
	}

}
