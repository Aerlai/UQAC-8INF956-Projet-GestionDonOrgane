package com.websystique.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.OrganeDao;
import com.websystique.springsecurity.model.Organe;

@Service("organeService")
@Transactional
public class OrganeServiceImpl implements OrganeService{

	@Autowired
	private OrganeDao dao;

	public void save(Organe organe) {
		dao.save(organe);
	}
	
	public Organe findById(int id) {
		return dao.findById(id);
	}

	public List<Organe> findAll() {
		return dao.findAll();
	}

	@Override
	public Organe findByName(String name) {
		return dao.findByName(name);
	}
	
}