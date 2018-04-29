package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Docteur;

public interface DocteurDao {

	void save(Docteur docteur);
	
	Docteur findById(int id);
	
	Docteur findBySso(String sso);

	List<Docteur> findAllInHopitalId(Integer id);
}