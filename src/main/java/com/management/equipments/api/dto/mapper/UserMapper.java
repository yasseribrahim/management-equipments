package com.management.equipments.api.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.management.equipments.api.dto.UserDto;
import com.management.equipments.api.entities.User;

@Mapper(componentModel="spring")
public interface UserMapper {
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	User fromDto(UserDto dto);

	UserDto toDto(User user);
	
	Iterable<User> fromDtos(Iterable<UserDto> dtos);
	
	Iterable<UserDto> toDtos(Iterable<User> users);
	
	List<UserDto> toDtos(List<User> users);
}
