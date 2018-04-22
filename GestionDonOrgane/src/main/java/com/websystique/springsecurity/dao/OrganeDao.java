package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Organe;

public interface OrganeDao {

		void save(Organe organe);
		
		Organe findById(int id);
		
		List<Organe> findAll();
		
		Organe findByName(String name);
		
}
