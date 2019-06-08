package com.pluralsight.mvc.view;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		final String PHONE_REGEX = "[0-9]{10}";
		if (StringUtils.isEmpty(value))
			return false;
		return value.matches(PHONE_REGEX);
	}

}
