package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Docteur;
import com.websystique.springsecurity.model.Hopital;

public interface HopitalService {

	void save(Hopital user);
	
	Hopital findById(int id);
	
	Hopital findByName(String name);
	
	List<Hopital> findAll();
	
}