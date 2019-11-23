package com.management.equipments.api.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.management.equipments.api.dto.EquipmetDto;
import com.management.equipments.api.entities.Equipment;

@Mapper(componentModel="spring")
public interface EquipmetMapper {
	EquipmetMapper MAPPER = Mappers.getMapper(EquipmetMapper.class);

	Equipment fromDto(EquipmetDto dto);

	EquipmetDto toDto(Equipment product);
	
	Iterable<Equipment> fromDtos(Iterable<EquipmetDto> dtos);
	
	Iterable<EquipmetDto> toDtos(Iterable<Equipment> productss);
	
	List<EquipmetDto> toDtos(List<Equipment> productss);
}
