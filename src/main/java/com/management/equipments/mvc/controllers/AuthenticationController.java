package com.management.equipments.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.management.equipments.api.dto.UserDto;
import com.management.equipments.api.services.UsersService;

@Controller
public class AuthenticationController {
	@Autowired
	private UsersService userService;

	@GetMapping(value={"/", "/login"})
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		System.out.println(getClass().getSimpleName() + ": Login...");
		return modelAndView;
	}
	
	@GetMapping(value="/registration")
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(getClass().getSimpleName() + ": Registration...");
		UserDto user = new UserDto();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@PostMapping(value = "/registration")
	public ModelAndView createNewUser(@Valid UserDto dto, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		UserDto userExists = userService.findByUsername(dto.getUsername());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			try {
			userService.saveUser(dto);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new UserDto());
			modelAndView.setViewName("registration");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return modelAndView;
	}
}