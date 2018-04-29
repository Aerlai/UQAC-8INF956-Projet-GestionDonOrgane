package com.websystique.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.DocteurDao;
import com.websystique.springsecurity.model.Docteur;

@Service("docteurService")
@Transactional
public class DocteurServiceImpl implements DocteurService{

	@Autowired
	private DocteurDao dao;
	
	public void save(Docteur docteur){
		dao.save(docteur);
	}
	
	public Docteur findById(int id) {
		return dao.findById(id);
	}
	
	public Docteur findBySso(String sso) {
		return dao.findBySso(sso);
	}

	
	public List<Docteur> findAllInHopitalId(Integer id) {
		return dao.findAllInHopitalId(id);
	}
	
}