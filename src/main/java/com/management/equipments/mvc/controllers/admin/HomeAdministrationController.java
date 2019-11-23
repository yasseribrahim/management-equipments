package com.management.equipments.mvc.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.management.equipments.api.util.Constants;

@Controller
@RequestMapping("/admin")
public class HomeAdministrationController {

	@GetMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.addObject(Constants.KEY_FRAGMENT, "admin/home");
		model.setViewName("admin-home");
		return model;
	}
}