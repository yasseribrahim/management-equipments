package com.management.equipments.api.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.management.equipments.api.dto.BuildingDto;
import com.management.equipments.api.entities.Building;

@Mapper(componentModel="spring")
public interface BuildingMapper {
	BuildingMapper MAPPER = Mappers.getMapper(BuildingMapper.class);

	Building fromDto(BuildingDto dto);

	BuildingDto toDto(Building building);
	
	Iterable<Building> fromDtos(Iterable<BuildingDto> dtos);
	
	Iterable<BuildingDto> toDtos(Iterable<Building> buildings);
	
	List<BuildingDto> toDtos(List<Building> buildings);
}
