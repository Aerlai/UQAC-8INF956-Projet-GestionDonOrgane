package com.websystique.springsecurity.dao;

import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Transporteur;

@Repository("transporteurDao")
public class TransporteurDaoImpl extends AbstractDao<Integer, Transporteur>implements TransporteurDao {

	public void save(Transporteur transporteur) {
		persist(transporteur);
	}
	
	public Transporteur findById(int id) {
		return getByKey(id);
	}

}