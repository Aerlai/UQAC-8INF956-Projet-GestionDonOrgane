package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Docteur;

public interface DocteurService {

	void save(Docteur docteur);
	
	Docteur findById(int id);
	
	Docteur findBySso(String sso);

	List<Docteur> findAllInHopitalId(Integer id);
	
}