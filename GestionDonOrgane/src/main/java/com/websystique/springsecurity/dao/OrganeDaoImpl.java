package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Donneur;
import com.websystique.springsecurity.model.Organe;

@Repository("organeDao")
public class OrganeDaoImpl extends AbstractDao<Integer, Organe>implements OrganeDao {

	public void save(Organe user) {
		merge(user);
	}
	
	public Organe findById(int id) {
		return getByKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Organe> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("organe"));
		return (List<Organe>)crit.list();
	}

	public Organe findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("organe", name));
		return (Organe) crit.uniqueResult();
	}

}