package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Docteur;

public interface DocteurDao {

	void save(Docteur docteur);
	
	Docteur findById(int id);
	
	Docteur findBySso(String sso);
}