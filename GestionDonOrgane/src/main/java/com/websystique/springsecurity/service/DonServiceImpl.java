package com.websystique.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.DonDao;
import com.websystique.springsecurity.dao.DonneurDao;
import com.websystique.springsecurity.dao.OrganeDao;
import com.websystique.springsecurity.model.Don;
import com.websystique.springsecurity.model.DonId;
import com.websystique.springsecurity.model.Donneur;
import com.websystique.springsecurity.model.Organe;

@Service("donService")
@Transactional
public class DonServiceImpl implements DonService{

	@Autowired
	private DonDao dao;
	
	@Autowired
	private OrganeDao daoOrgane;
	
	@Autowired DonneurDao donneurDao;
	
	public void save(Don don) {
		dao.save(don);
		
	}

	
	public Don findById(DonId id) {
		return dao.findById(id);
	}

	
	public List<Don> findAll() {
		return dao.findAll();
	}


	public void save(Don don, int donneurId, int organeId) {
		Donneur d = donneurDao.findById(donneurId);
		Organe o = daoOrgane.findById(organeId);
		don.setDonneur(d);
		don.setOrgane(o);
		
		dao.save(don);
	}
	
	public void save(Don don, String donneurName, int organeId) {
		Donneur d = donneurDao.findByName(donneurName);
		Organe o = daoOrgane.findById(organeId);
		don.setDonneur(d);
		don.setOrgane(o);
		
		dao.save(don);
	}

}
