package com.websystique.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.HopitalDao;
import com.websystique.springsecurity.model.Hopital;

@Service("hopitalService")
@Transactional
public class HopitalServiceImpl implements HopitalService{

	@Autowired
	private HopitalDao dao;

	
	public void save(Hopital hopital){
		dao.save(hopital);
	}
	
	public Hopital findById(int id) {
		return dao.findById(id);
	}
	
}