package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Hopital;

public interface HopitalDao {

		void save(Hopital hopital);
		
		Hopital findById(int id);
		
		List<Hopital> findAll();
		
		Hopital findByName(String name);
		
}
