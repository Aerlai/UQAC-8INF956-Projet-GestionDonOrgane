package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.Donneur;

public interface DonneurService {

	void save(Donneur user);
	
	Donneur findById(int id);
	
}