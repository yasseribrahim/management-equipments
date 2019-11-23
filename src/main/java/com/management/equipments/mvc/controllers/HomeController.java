package com.management.equipments.mvc.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.management.equipments.api.util.Constants;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public String home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String home = "redirect:/normal/home";
		System.out.println("HomeController: " + authentication.getAuthorities());
		if (authentication.getAuthorities().stream()
				.anyMatch(authority -> authority.getAuthority().equalsIgnoreCase(Constants.ROLE_ADMIN))) {
			home = "redirect:/admin/home";
		} else if (authentication.getAuthorities().stream()
				.anyMatch(authority -> authority.getAuthority().equalsIgnoreCase(Constants.ROLE_NORMAL))) {
			home = "redirect:/normal/home";
		}
		return home;
	}
}