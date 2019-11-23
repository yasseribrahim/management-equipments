package com.management.equipments.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.management.equipments.api.dto.UserDto;
import com.management.equipments.api.services.UsersService;

@ControllerAdvice
public class CurrentUserControllerAdvice {
	@Autowired
	private UsersService userService;

	@ModelAttribute("currentUser")
	public UserDto getCurrentUser(Authentication authentication) {
		return (authentication == null) ? null : userService.findByUsername(authentication.getName());
	}
}
