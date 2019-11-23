package com.management.equipments.api.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.management.equipments.api.dto.UserDto;
import com.management.equipments.api.services.implementation.exceptions.SaveFailException;

public interface UsersService extends UserDetailsService {
	public UserDto findByUsername(String username) throws UsernameNotFoundException;
	
	public List<UserDto> findAll();

	public void saveUser(UserDto user) throws SaveFailException;

	public void saveAdminUser(UserDto user) throws SaveFailException;
}
