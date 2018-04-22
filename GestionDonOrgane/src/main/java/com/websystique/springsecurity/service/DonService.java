package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Don;
import com.websystique.springsecurity.model.DonId;

public interface DonService {

	void save(Don don);
	
	Don findById(DonId id);
	
	List<Don> findAll();

	void save(Don don, int donneurId, int organeId);
	
	void save(Don don, String donneurName, int organeId);
	
}