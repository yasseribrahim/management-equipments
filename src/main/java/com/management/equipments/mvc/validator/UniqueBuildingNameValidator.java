package com.management.equipments.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.management.equipments.api.services.BuildingsService;
import com.management.equipments.mvc.validator.anottation.UniqueBuildingNameValidation;

public class UniqueBuildingNameValidator implements ConstraintValidator<UniqueBuildingNameValidation, String> {
	private BuildingsService service;

	public UniqueBuildingNameValidator(BuildingsService service) {
		this.service = service;
	}

	@Override
	public void initialize(UniqueBuildingNameValidation validation) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return service.findByName(name) == null;
	}
}
