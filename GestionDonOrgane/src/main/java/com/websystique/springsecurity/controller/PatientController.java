package com.websystique.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springsecurity.model.Patient;
import com.websystique.springsecurity.service.PatientService;
import com.websystique.springsecurity.service.UserProfileService;
import com.websystique.springsecurity.service.UserService;

@Controller
public class PatientController {
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		Patient patient = new Patient();
		model.addAttribute("patient", getPrincipal());
		model.addAttribute("sang", getSang());
		return "patient";
	}
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	private String getSang() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String sang = "not found";
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
			Patient p = patientService.findBySso(userName);
			sang = p.getGroupe_sang();
		} else {
			userName = principal.toString();
			Patient p = patientService.findBySso(userName);
			sang = p.getGroupe_sang();
		}
		return sang;
	}

}
