package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Hopital;

@Repository("hopitalDao")
public class HopitalDaoImpl extends AbstractDao<Integer, Hopital>implements HopitalDao {

	public void save(Hopital hopital) {
		persist(hopital);
	}
	
	public Hopital findById(int id) {
		return getByKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Hopital> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("nom"));
		return (List<Hopital>)crit.list();
	}

	public Hopital findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("nom", name));
		return (Hopital) crit.uniqueResult();
	}

}