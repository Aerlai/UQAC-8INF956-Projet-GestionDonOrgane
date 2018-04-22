package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.Don;
import com.websystique.springsecurity.model.Donneur;

public interface DonneurService {

	Donneur save(Donneur user);
	
	Donneur findById(int id);
	
	Donneur findByName(String name);
	
}