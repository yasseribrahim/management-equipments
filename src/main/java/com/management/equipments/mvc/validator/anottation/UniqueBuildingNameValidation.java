package com.management.equipments.mvc.validator.anottation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.management.equipments.mvc.validator.UniqueBuildingNameValidator;

@Documented
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueBuildingNameValidator.class)
public @interface UniqueBuildingNameValidation {
	String message() default "{buidling.message.invalid.name}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}