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

import com.websystique.springsecurity.model.Docteur;
import com.websystique.springsecurity.model.Hopital;
import com.websystique.springsecurity.model.RegisterDocteur;
import com.websystique.springsecurity.model.RegisterHopital;
import com.websystique.springsecurity.model.RegisterPatient;
import com.websystique.springsecurity.model.RegisterTransporteur;
import com.websystique.springsecurity.model.Transporteur;
import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.model.UserProfile;
import com.websystique.springsecurity.service.DocteurService;
import com.websystique.springsecurity.service.HopitalService;
import com.websystique.springsecurity.service.TransporteurService;
import com.websystique.springsecurity.service.UserProfileService;
import com.websystique.springsecurity.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HopitalService hopitalService;
	
	@Autowired
	TransporteurService transporteurService;
	
	@Autowired
	DocteurService docteurService;
	
	// Gestionnaire admin
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	
	// Gestionnaire de base de donn�e
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "newuser";
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String saveRegistration(@Valid User user,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newuser";
		}
		userService.save(user);
		
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
		return userProfileService.findAll();
	}
	
//	@ModelAttribute("hopitaux")
//	public List<Hopital> initializeHopital() {
//		return hopitalService.findAll();
//	}
	
	
	
	@RequestMapping(value = "/newHopital", method = RequestMethod.GET)
	public ModelAndView newHopital(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		RegisterHopital registerHopital = new RegisterHopital();
		
		model.addAttribute("registerHopital", registerHopital);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("newhopital");
		return modelAndView;
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/registerNewHopital", method = RequestMethod.POST)
	public String saveRegistration(@Valid @ModelAttribute("registerHopital") RegisterHopital registerHopital, BindingResult result, Model model) { //@ModelAttrbite('User')User user, BindingResult resultUser, 
		//@ModelAttribute('UserProfile')UserProfile userProfile, BindingResult resultProfile

		boolean b = result.hasGlobalErrors();
		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newhopital";
		}
		Hopital hopital = registerHopital.getHopital();
		hopital.setAdresse(registerHopital.getAdresse());
		hopitalService.save(hopital);
		
		model.addAttribute("success", "Hopital " + hopital.getNom() + " has been registered successfully");
		return "registrationsuccess";
	}
	
	@RequestMapping(value = "/newTransporteur", method = RequestMethod.GET)
	public ModelAndView newTransporteur(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		RegisterTransporteur registerTransporteur = new RegisterTransporteur();
		
		model.addAttribute("registerTransporteur", registerTransporteur);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("newtransporteur");
		return modelAndView;
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/registerNewTransporteur", method = RequestMethod.POST)
	public String saveRegistration(@Valid @ModelAttribute("registerTransporteur") RegisterTransporteur registerTransporteur, BindingResult result, Model model) { //@ModelAttrbite('User')User user, BindingResult resultUser, 
		//@ModelAttribute('UserProfile')UserProfile userProfile, BindingResult resultProfile

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newtransporteur";
		}
		//TODO POUR TOUS LES REGISTER : VERIFIER QUE C'EST TOUT BON
		
		Transporteur transporteur = registerTransporteur.getTransporteur();
		transporteur.setAdresse(registerTransporteur.getAdresse());
		
		//userService.save(user);
		//patientService.save(registerPatient.getPatient());
		transporteurService.save(transporteur);
		
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
		
		model.addAttribute("success", "Transporteur " + transporteur.getNom() + " has been registered successfully");
		return "registrationsuccess";
	}

	
	
	@RequestMapping(value = "/newDocteur", method = RequestMethod.GET)
	public ModelAndView newDocteur(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		RegisterDocteur registerDocteur = new RegisterDocteur();
		model.addAttribute("hopitaux", hopitalService.findAll());
		model.addAttribute("registerDocteur", registerDocteur);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("newdocteur");
		return modelAndView;
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/registerNewDocteur", method = RequestMethod.POST)
	public String saveRegistration(@Valid @ModelAttribute("registerDocteur") RegisterDocteur registerDocteur, BindingResult result, Model model) { 

		if (result.hasErrors()) {
			System.out.println("There are errors");
			model.addAttribute("hopitaux", hopitalService.findAll());
			return "newdocteur";
		}
		//TODO POUR TOUS LES REGISTER : VERIFIER QUE C'EST TOUT BON
		//TODO PAS BESOIN DE REGISTERDOCTEUR EN FAIT
		Docteur docteur = registerDocteur.getDocteur();
		docteurService.save(docteur);
		
		model.addAttribute("success", "Docteur " + docteur.getFirstName() + " has been registered successfully");
		return "registrationsuccess";
	}
}
