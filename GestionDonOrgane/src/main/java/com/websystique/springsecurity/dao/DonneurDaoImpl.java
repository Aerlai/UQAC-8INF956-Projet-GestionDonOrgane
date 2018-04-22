package com.websystique.springsecurity.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Donneur;

@Repository("donneurDao")
public class DonneurDaoImpl extends AbstractDao<Integer, Donneur>implements DonneurDao {

	public void save(Donneur user) {
		merge(user);
	}
	
	public Donneur findById(int id) {
		return getByKey(id);
	}
	
	public Donneur findByName(String nom) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("nom", nom));
		return (Donneur) crit.uniqueResult();
	}

}