package com.management.equipments.api.services;

import java.util.List;

import com.management.equipments.api.dto.EquipmetDto;

public interface EquipmentsService {

	EquipmetDto findById(Long id);
	 
	EquipmetDto findByName(String name);
 
	EquipmetDto save(EquipmetDto product);
 
	EquipmetDto update(EquipmetDto product);
 
    boolean deleteById(Long id);
 
    boolean deleteAll();
 
    List<EquipmetDto> findAll();
 
    boolean isExist(EquipmetDto product);
}
