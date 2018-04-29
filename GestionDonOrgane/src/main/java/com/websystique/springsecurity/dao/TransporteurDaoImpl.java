package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Besoin;
import com.websystique.springsecurity.model.Transporteur;
import com.websystique.springsecurity.model.User;

@Repository("transporteurDao")
public class TransporteurDaoImpl extends AbstractDao<Integer, Transporteur>implements TransporteurDao {

	public void save(Transporteur transporteur) {
		persist(transporteur);
	}
	
	public Transporteur findById(int id) {
		return getByKey(id);
	}

	public Transporteur findByName(String nom) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("nom", nom));
		return (Transporteur) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Transporteur> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("nom"));
		return (List<Transporteur>)crit.list();
	}

}