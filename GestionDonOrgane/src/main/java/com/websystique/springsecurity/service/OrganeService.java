package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Organe;

public interface OrganeService {

	void save(Organe organe);
	
	Organe findById(int id);
	
	Organe findByName(String name);
	
	List<Organe> findAll();
	
}