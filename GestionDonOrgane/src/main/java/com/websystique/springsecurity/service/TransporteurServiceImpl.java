package com.websystique.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.TransporteurDao;
import com.websystique.springsecurity.model.Transporteur;

@Service("transporteurService")
@Transactional
public class TransporteurServiceImpl implements TransporteurService{

	@Autowired
	private TransporteurDao dao;

	
	public void save(Transporteur transporteur){
		dao.save(transporteur);
	}
	
	public Transporteur findById(int id) {
		return dao.findById(id);
	}

	
	public Transporteur findByName(String nom) {
		
		return dao.findByName(nom);
	}
	
}