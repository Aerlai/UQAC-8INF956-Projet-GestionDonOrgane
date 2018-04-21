package com.websystique.springsecurity.dao;

import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Donneur;

@Repository("donneurDao")
public class DonneurDaoImpl extends AbstractDao<Integer, Donneur>implements DonneurDao {

	public void save(Donneur user) {
		persist(user);
	}
	
	public Donneur findById(int id) {
		return getByKey(id);
	}

}