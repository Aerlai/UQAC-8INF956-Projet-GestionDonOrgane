package com.websystique.springsecurity.service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.DonneurDao;
import com.websystique.springsecurity.model.Donneur;
import com.websystique.springsecurity.model.User;

@Service("donneurService")
@Transactional
public class DonneurServiceImpl implements DonneurService{

	@Autowired
	private DonneurDao dao;
	
	public Donneur save(Donneur user){
		dao.save(user);
		return user;
	}
	
	public Donneur findById(int id) {
		return dao.findById(id);
	}
	
	public Donneur findByName(String nom) {
		return dao.findByName(nom);
	}
	
}