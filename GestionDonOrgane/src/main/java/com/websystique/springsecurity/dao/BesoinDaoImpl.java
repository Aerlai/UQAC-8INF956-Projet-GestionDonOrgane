package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.BesoinId;
import com.websystique.springsecurity.model.Besoin;
import com.websystique.springsecurity.model.DonId;

@Repository("besoinDao")
public class BesoinDaoImpl extends AbstractDao<BesoinId, Besoin>implements BesoinDao {

	public void save(Besoin besoin) {
		
		//TODO Ajouter le rank
		persist(besoin);
	}
	
	public Besoin findById(BesoinId id) {
		return getByKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Besoin> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("rank"));
		return (List<Besoin>)crit.list();
	}



}