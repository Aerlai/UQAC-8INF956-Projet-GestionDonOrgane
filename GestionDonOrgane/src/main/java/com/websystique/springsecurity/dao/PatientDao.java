package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Patient;

public interface PatientDao {

	void save(Patient user);
	
	Patient findById(int id);
	
	Patient findBySSO(String sso);
}