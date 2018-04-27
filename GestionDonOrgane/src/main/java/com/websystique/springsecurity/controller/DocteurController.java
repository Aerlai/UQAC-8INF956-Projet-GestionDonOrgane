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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springsecurity.model.Besoin;
import com.websystique.springsecurity.model.Docteur;
import com.websystique.springsecurity.model.Don;
import com.websystique.springsecurity.model.Donneur;
import com.websystique.springsecurity.model.Organe;
import com.websystique.springsecurity.model.Patient;
import com.websystique.springsecurity.model.RegisterBesoin;
import com.websystique.springsecurity.model.RegisterDon;
import com.websystique.springsecurity.model.RegisterPatient;
import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.model.UserProfile;
import com.websystique.springsecurity.service.BesoinService;
import com.websystique.springsecurity.service.DocteurService;
import com.websystique.springsecurity.service.DonService;
import com.websystique.springsecurity.service.DonneurService;
import com.websystique.springsecurity.service.OrganeService;
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
	
	@Autowired
	OrganeService organeService;
	
	@Autowired
	DonService donService;
	
	@Autowired
	DocteurService docteurService;
	
	@Autowired
	BesoinService besoinService;
	
	// Gestionnaire admin
	@RequestMapping(value = "/docteur", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		Docteur moi = docteurService.findBySso(getPrincipal());
		model.addAttribute("user", getPrincipal());
		model.addAttribute("patients", moi.getPatients());
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
	
	@RequestMapping(value="/patient/details/{id}", method=RequestMethod.GET)
    public ModelAndView detailPatient(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("detailPatient");
        Patient p = patientService.findById(id);
        modelAndView.addObject("patient",p);
        modelAndView.addObject("besoins", besoinService.getBesoins(p.getId()));
        
        return modelAndView;
    }
	
	@RequestMapping(value="/patient/ajouterBesoin/{id}", method=RequestMethod.GET)
    public ModelAndView ajouterBesoin(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("ajouterBesoin");
        Patient p = patientService.findById(id);
        RegisterBesoin rb = new RegisterBesoin();
        modelAndView.addObject("registerBesoin", rb);
        modelAndView.addObject("patient",p);
        modelAndView.addObject("organes",organeService.findAll());
        
        return modelAndView;
    }
	
	@RequestMapping(value="/patient/ajouterBesoin/{id}", method=RequestMethod.POST)
    public String ajouterBesoin(@ModelAttribute("RegisterBesoin") RegisterBesoin registerBesoin, @PathVariable Integer id, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "/patient/ajouterBesoin/"+id+".html";
		}
		
		//Patient p = patientService.findById(id);
		
		//TODO Faire une classe avec besoin & co ?
		for (Organe organe : registerBesoin.getListeBesoin()) {
			Besoin besoin = new Besoin();
			//besoin.setOrgane(organe);
			//besoin.setPatient(p);
			//TODO Changer le rank
			besoin.setRank(0);
			besoinService.save(besoin, id, organe.getId());
			//besoinService.save(besoin);
		}
		
		model.addAttribute("success", "Besoin ajouté avec succès");
		return "registrationsuccess";
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
		Docteur moi = docteurService.findBySso(getPrincipal());
		registerPatient.getPatient().setDocteur(moi);
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
	
	@RequestMapping(value = "/newDon", method = RequestMethod.GET)
	public ModelAndView newDon(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		RegisterDon donneur = new RegisterDon();
		
		model.addAttribute("registerDon", donneur);
		model.addAttribute("organes",organeService.findAll());
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("newdon");
		return modelAndView;
	}
	
	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/registerNewDon", method = RequestMethod.POST)
	public String saveRegistration(@Valid @ModelAttribute("registerDon") RegisterDon registerDon, BindingResult result, Model model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newdon";
		}
		
		Donneur donneur = registerDon.getDonneur();

		donneur = donneurService.save(donneur);
		
		for (Organe organe : registerDon.getListeDon()) {
			Don don = new Don();
			don.setDateDon(registerDon.getDateDon());
			donService.save(don, donneur.getNom(), organe.getId());
		}
		//userService.save(user);
		
		
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
