package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Besoin;
import com.websystique.springsecurity.model.BesoinId;

public interface BesoinService {

	void save(Besoin besoin);
	
	Besoin findById(BesoinId id);
	
	List<Besoin> findAll();

	void save(Besoin don, int patientId, int organeId);
	
	void save(Besoin don, String patientSSO, int organeId);
	
}