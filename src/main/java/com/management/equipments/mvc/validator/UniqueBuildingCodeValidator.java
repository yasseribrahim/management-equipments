package com.management.equipments.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.management.equipments.api.services.BuildingsService;
import com.management.equipments.mvc.validator.anottation.UniqueBuildingCodeValidation;

public class UniqueBuildingCodeValidator implements ConstraintValidator<UniqueBuildingCodeValidation, String> {
	private BuildingsService service;

	public UniqueBuildingCodeValidator(BuildingsService service) {
		this.service = service;
	}

	@Override
	public void initialize(UniqueBuildingCodeValidation validation) {
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {
		return service.findByCode(code) == null;
	}
}
