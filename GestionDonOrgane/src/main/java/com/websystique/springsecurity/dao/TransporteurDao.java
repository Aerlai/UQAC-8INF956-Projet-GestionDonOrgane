package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Transporteur;

public interface TransporteurDao {

		void save(Transporteur transporteur);
		
		Transporteur findById(int id);

		Transporteur findByName(String nom);

		List<Transporteur> findAll();
}
