package com.websystique.springsecurity.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Docteur;
import com.websystique.springsecurity.model.User;

@Repository("docteurDao")
public class DocteurDaoImpl extends AbstractDao<Integer, Docteur>implements DocteurDao {

	@Autowired
	private UserDao userDao;
	
	public void save(Docteur docteur) {
		persist(docteur);
	}
	
	public Docteur findById(int id) {
		return getByKey(id);
	}
	
	public Docteur findBySso(String sso) {
		User u = userDao.findBySSO(sso);
		
		return findById(u.getId());
	}

}