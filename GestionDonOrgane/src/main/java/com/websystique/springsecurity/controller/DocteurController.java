package com.websystique.springsecurity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springsecurity.model.Donneur;
import com.websystique.springsecurity.model.RegisterPatient;
import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.model.UserProfile;
import com.websystique.springsecurity.service.DonneurService;
import com.websystique.springsecurity.service.PatientService;
import com.websystique.springsecurity.service.UserProfileService;
import com.websystique.springsecurity.service.UserService;

@Controller
public class DocteurController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PatientService patientService;
	@Autowired
	DonneurService donneurService;
	
	// Gestionnaire admin
	@RequestMapping(value = "/docteur", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "docteur";
	}
	
	@RequestMapping(value = "/newPatient", method = RequestMethod.GET)
	public ModelAndView newRegistration(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		RegisterPatient registerPatient = new RegisterPatient();
		
		model.addAttribute("registerPatient", registerPatient);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("newpatient");
		return modelAndView;
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/registerNewPatient", method = RequestMethod.POST)
	public String saveRegistration(@Valid @ModelAttribute("registerPatient") RegisterPatient registerPatient, BindingResult result, Model model) { //@ModelAttrbite('User')User user, BindingResult resultUser, 
		//@ModelAttribute('UserProfile')UserProfile userProfile, BindingResult resultProfile

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newuser";
		}
		registerPatient.getPatient().setAdresse(registerPatient.getAdresse());
		User user = registerPatient.getPatient();
		//userService.save(user);
		patientService.save(registerPatient.getPatient());
		
		System.out.println("First Name : "+user.getFirstName());
		System.out.println("Last Name : "+user.getLastName());
		System.out.println("SSO ID : "+user.getSsoId());
		System.out.println("Password : "+user.getPassword());
		System.out.println("Email : "+user.getEmail());
		System.out.println("Birthday : "+user.getBirthday());
		System.out.println("Checking UsrProfiles....");
		if(user.getUserProfiles()!=null){
			for(UserProfile profile : user.getUserProfiles()){
				System.out.println("Profile : "+ profile.getType());
			}
		}
		
		model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
		return "registrationsuccess";
	}
	
	@RequestMapping(value = "/newDonneur", method = RequestMethod.GET)
	public ModelAndView newDonneur(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		Donneur donneur = new Donneur();
		
		model.addAttribute("donneur", donneur);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("newdonneur");
		return modelAndView;
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/registerNewDonneur", method = RequestMethod.POST)
	public String saveRegistration(@Valid @ModelAttribute("donneur") Donneur donneur, BindingResult result, Model model) { //@ModelAttrbite('User')User user, BindingResult resultUser, 
		//@ModelAttribute('UserProfile')UserProfile userProfile, BindingResult resultProfile

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newdonneur";
		}
		
		//userService.save(user);
		donneurService.save(donneur);
		
//		System.out.println("First Name : "+user.getFirstName());
//		System.out.println("Last Name : "+user.getLastName());
//		System.out.println("SSO ID : "+user.getSsoId());
//		System.out.println("Password : "+user.getPassword());
//		System.out.println("Email : "+user.getEmail());
//		System.out.println("Birthday : "+user.getBirthday());
//		System.out.println("Checking UsrProfiles....");
//		if(user.getUserProfiles()!=null){
//			for(UserProfile profile : user.getUserProfiles()){
//				System.out.println("Profile : "+ profile.getType());
//			}
//		}
		
		model.addAttribute("success", "Donneur " + donneur.getNom() + " has been registered successfully");
		return "registrationsuccess";
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
	
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		//TODO Un docteur ne devrait pas pouvoir set tous les roles
		return userProfileService.findAll();
	}

}
