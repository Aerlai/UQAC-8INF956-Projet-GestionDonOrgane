package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Don;
import com.websystique.springsecurity.model.DonId;

@Repository("donDao")
public class DonDaoImpl extends AbstractDao<DonId, Don>implements DonDao {

	public void save(Don don) {
		persist(don);
	}
	
	public Don findById(DonId id) {
		return getByKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Don> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("date_don"));
		return (List<Don>)crit.list();
	}



}