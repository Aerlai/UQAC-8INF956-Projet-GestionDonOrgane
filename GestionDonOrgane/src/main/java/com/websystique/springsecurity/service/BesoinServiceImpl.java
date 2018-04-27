package com.websystique.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.BesoinDao;
import com.websystique.springsecurity.dao.DonDao;
import com.websystique.springsecurity.dao.DonneurDao;
import com.websystique.springsecurity.dao.OrganeDao;
import com.websystique.springsecurity.dao.PatientDao;
import com.websystique.springsecurity.model.Besoin;
import com.websystique.springsecurity.model.BesoinId;
import com.websystique.springsecurity.model.Organe;
import com.websystique.springsecurity.model.Patient;

@Service("besoinService")
@Transactional
public class BesoinServiceImpl implements BesoinService{

	@Autowired
	private BesoinDao dao;
	
	@Autowired
	private OrganeDao daoOrgane;
	
	@Autowired PatientDao patientDao;
	
	public void save(Besoin don) {
		dao.save(don);
		
	}

	
	public Besoin findById(BesoinId id) {
		return dao.findById(id);
	}

	
	public List<Besoin> findAll() {
		return dao.findAll();
	}


	public void save(Besoin besoin, int patientId, int organeId) {
		Patient d = patientDao.findById(patientId);
		Organe o = daoOrgane.findById(organeId);
		besoin.setPatient(d);
		besoin.setOrgane(o);
		
		dao.save(besoin, organeId);
	}
	
	public void save(Besoin besoin, String patientSSO, int organeId) {
		Patient d = patientDao.findBySSO(patientSSO);
		Organe o = daoOrgane.findById(organeId);
		besoin.setPatient(d);
		besoin.setOrgane(o);
		
		dao.save(besoin);
	}


	public List<Besoin> getBesoins(int idPatient) {
		
		return dao.getBesoins(idPatient);
	}

}
