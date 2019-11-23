package com.management.equipments.api.services;

import java.util.List;

import com.management.equipments.api.dto.BuildingDto;
import com.management.equipments.api.services.implementation.exceptions.SaveFailException;

public interface BuildingsService {

	BuildingDto findById(Long id);

	BuildingDto findByCode(String code);
	 
	BuildingDto findByName(String name);
 
	BuildingDto save(BuildingDto building) throws SaveFailException;
 
	BuildingDto update(BuildingDto building) throws SaveFailException;
 
    boolean deleteById(Long id);
 
    boolean deleteAll();
 
    List<BuildingDto> findAll();
 
    boolean isExist(BuildingDto building);
}
