package com.management.equipments.mvc.controllers.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.management.equipments.api.dto.UserDto;
import com.management.equipments.api.services.UsersService;
import com.management.equipments.api.services.implementation.exceptions.SaveFailException;
import com.management.equipments.api.util.Constants;

@Controller
@RequestMapping("/admin/users")
public class UsersController {
	@Autowired
	private UsersService service;

	@GetMapping(value = "/list")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();

		List<UserDto> users = service.findAll();

		model.addObject("users", users);
		model.addObject(Constants.KEY_FRAGMENT, "admin/users");
		model.setViewName("admin-home");
		return model;
	}

	@GetMapping(value = "/add-form")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();

		UserDto dto = new UserDto();

		model.addObject("user", dto);
		model.addObject(Constants.KEY_FRAGMENT, "admin/user");
		model.setViewName("admin-home");
		return model;
	}

	@PostMapping(value = "/add")
	public String add(@Valid @ModelAttribute("user")  UserDto dto, BindingResult result) {

		if (result.hasErrors()) {
//			for (ObjectError error : result.getAllErrors()) {
//				for (Object obj : error.getArguments()) {
//					System.out.println("\tArg: " + obj.getClass().getName() + ", " + obj);
//				}
//				System.out.println(error.getDefaultMessage());
//				System.out.println(error.getObjectName());
//				System.out.println(error.getCode());
//				for (String obj : error.getCodes()) {
//					System.out.println("\tCode:: " + obj);
//				}
//				System.out.println("-------------------------");
//			}

			return "redirect:/admin/users/add-form";
		}

		try {
			service.saveUser(dto);
		} catch (SaveFailException e) {
			// TODO: handle exception
		}

		return "redirect:/admin/users/list";
	}
}