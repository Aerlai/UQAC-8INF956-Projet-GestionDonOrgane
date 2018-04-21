package com.websystique.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.DonneurDao;
import com.websystique.springsecurity.model.Donneur;

@Service("donneurService")
@Transactional
public class DonneurServiceImpl implements DonneurService{

	@Autowired
	private DonneurDao dao;
	
	public void save(Donneur user){
		dao.save(user);
	}
	
	public Donneur findById(int id) {
		return dao.findById(id);
	}
	
}