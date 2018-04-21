package com.websystique.springsecurity.dao;

import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Docteur;

@Repository("docteurDao")
public class DocteurDaoImpl extends AbstractDao<Integer, Docteur>implements DocteurDao {

	public void save(Docteur docteur) {
		persist(docteur);
	}
	
	public Docteur findById(int id) {
		return getByKey(id);
	}

}