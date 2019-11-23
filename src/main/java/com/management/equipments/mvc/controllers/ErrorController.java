package com.management.equipments.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.management.equipments.api.util.Constants;

@Controller
public class ErrorController {

	@GetMapping(value = "/error-404")
	public String error404() {
		return "error-404";
	}

	@GetMapping(value = "/error-403")
	public ModelAndView error403() {
		ModelAndView model = new ModelAndView();
		model.addObject(Constants.KEY_FRAGMENT, "error");
		model.addObject(Constants.KEY_ERROR_MESSAGE, "Access Denied");
		model.setViewName("home");
		return model;
	}

	@GetMapping(value = "/error-500")
	public String error500() {
		return "error-500";
	}
}