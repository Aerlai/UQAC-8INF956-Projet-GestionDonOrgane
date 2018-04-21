package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Transporteur;

public interface TransporteurDao {

		void save(Transporteur transporteur);
		
		Transporteur findById(int id);
}
