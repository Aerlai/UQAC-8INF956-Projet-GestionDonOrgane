package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Don;
import com.websystique.springsecurity.model.DonId;
import com.websystique.springsecurity.model.Hopital;

public interface DonDao {

		void save(Don don);
		
		Don findById(DonId id);
		
		List<Don> findAll();
		
}
