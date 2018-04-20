package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Hopital;

public interface HopitalDao {

		void save(Hopital user);
		
		Hopital findById(int id);
}
