package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Transporteur;

public interface TransporteurService {

	void save(Transporteur transporteur);
	
	Transporteur findById(int id);

	Transporteur findByName(String nom);

	List<Transporteur> findAll();
	
}