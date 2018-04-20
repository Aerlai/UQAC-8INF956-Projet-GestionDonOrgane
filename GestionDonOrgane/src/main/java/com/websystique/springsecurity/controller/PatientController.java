package com.websystique.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springsecurity.service.UserProfileService;
import com.websystique.springsecurity.service.UserService;

@Controller
public class PatientController {
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

}
