package com.management.equipments.mvc.controllers.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.management.equipments.api.util.Constants;

@Controller
@RequestMapping("/normal")
public class HomeNormalController {

	@GetMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.addObject(Constants.KEY_FRAGMENT, "normal/home");
		model.setViewName("normal-home");
		return model;
	}
}