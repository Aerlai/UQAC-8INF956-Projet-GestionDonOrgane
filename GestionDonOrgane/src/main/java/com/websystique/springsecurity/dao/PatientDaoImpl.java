package com.websystique.springsecurity.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Patient;

@Repository("patientDao")
public class PatientDaoImpl extends AbstractDao<Integer, Patient>implements PatientDao {

	public void save(Patient user) {
		persist(user);
	}
	
	public Patient findById(int id) {
		return getByKey(id);
	}
	
	public Patient findBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (Patient) crit.uniqueResult();
	}

}