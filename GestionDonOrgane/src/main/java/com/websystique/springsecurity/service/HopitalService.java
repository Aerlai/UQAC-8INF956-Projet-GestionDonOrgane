package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.Hopital;

public interface HopitalService {

	void save(Hopital user);
	
	Hopital findById(int id);
	
}