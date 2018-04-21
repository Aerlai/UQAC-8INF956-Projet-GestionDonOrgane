package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.Transporteur;

public interface TransporteurService {

	void save(Transporteur transporteur);
	
	Transporteur findById(int id);
	
}