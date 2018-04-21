package com.websystique.springsecurity.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Hopital;
import com.websystique.springsecurity.model.Patient;

@Repository("hopitalDao")
public class HopitalDaoImpl extends AbstractDao<Integer, Hopital>implements HopitalDao {

	public void save(Hopital hopital) {
		persist(hopital);
	}
	
	public Hopital findById(int id) {
		return getByKey(id);
	}

}