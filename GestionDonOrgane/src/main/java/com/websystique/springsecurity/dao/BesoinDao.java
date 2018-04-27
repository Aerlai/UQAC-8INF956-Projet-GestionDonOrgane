package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Besoin;
import com.websystique.springsecurity.model.BesoinId;

public interface BesoinDao {

		void save(Besoin besoin);
		
		Besoin findById(BesoinId id);
		
		List<Besoin> findAll();

		void save(Besoin besoin, int organeId);

		List<Besoin> getBesoins(int idPatient);
		
}
