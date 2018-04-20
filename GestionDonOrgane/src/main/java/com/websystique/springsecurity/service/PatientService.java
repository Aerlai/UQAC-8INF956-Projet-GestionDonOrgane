package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.Patient;

public interface PatientService {

	void save(Patient user);
	
	Patient findById(int id);
	
	Patient findBySso(String sso);
	
}