package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Donneur;

public interface DonneurDao {

	void save(Donneur user);
	
	Donneur findById(int id);
}