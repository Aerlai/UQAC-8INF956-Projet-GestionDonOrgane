package com.websystique.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.PatientDao;
import com.websystique.springsecurity.model.Patient;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public void save(Patient user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}
	
	public Patient findById(int id) {
		return dao.findById(id);
	}

	public Patient findBySso(String sso) {
		return dao.findBySSO(sso);
	}
	
}