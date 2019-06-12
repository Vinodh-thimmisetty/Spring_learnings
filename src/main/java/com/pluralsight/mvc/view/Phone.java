package com.pluralsight.mvc.view;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = PhoneConstraintValidator.class)
public @interface Phone {

	String message() default "{Phone}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
