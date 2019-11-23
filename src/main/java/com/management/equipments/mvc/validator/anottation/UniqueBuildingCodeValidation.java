package com.management.equipments.mvc.validator.anottation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.management.equipments.mvc.validator.UniqueBuildingCodeValidator;

@Documented
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueBuildingCodeValidator.class)
public @interface UniqueBuildingCodeValidation {
	String message() default "{buidling.message.invalid.code}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}