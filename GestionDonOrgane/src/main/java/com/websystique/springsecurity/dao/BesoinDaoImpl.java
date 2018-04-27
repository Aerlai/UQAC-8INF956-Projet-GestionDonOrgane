package com.websystique.springsecurity.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.BesoinId;
import com.websystique.springsecurity.model.Besoin;

@Repository("besoinDao")
public class BesoinDaoImpl extends AbstractDao<BesoinId, Besoin>implements BesoinDao {

	public void save(Besoin besoin) {
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

	
	public void save(Besoin besoin, int organeId) {
		
		Integer maxRank = (Integer) getSession().createSQLQuery("SELECT max(rank) FROM BESOIN WHERE id_organe = "+organeId).uniqueResult();
		
		if(maxRank == null) maxRank  = 0;
		
		maxRank ++;
		besoin.setRank(maxRank);
		save(besoin);
		
	}

	@SuppressWarnings("unchecked")
	public List<Besoin> getBesoins(int idPatient) {
		
		List<Besoin> listeBesoins = getSession().createSQLQuery("SELECT * FROM BESOIN WHERE id_patient = "+idPatient).addEntity(Besoin.class).list();
		
		return listeBesoins;
	}



}