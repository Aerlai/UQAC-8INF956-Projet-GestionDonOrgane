package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Besoin;
import com.websystique.springsecurity.model.Docteur;
import com.websystique.springsecurity.model.User;

@Repository("docteurDao")
public class DocteurDaoImpl extends AbstractDao<Integer, Docteur>implements DocteurDao {

	@Autowired
	private UserDao userDao;
	
	public void save(Docteur docteur) {
		persist(docteur);
	}
	
	public Docteur findById(int id) {
		return getByKey(id);
	}
	
	public Docteur findBySso(String sso) {
		User u = userDao.findBySSO(sso);
		
		return findById(u.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Docteur> findAllInHopitalId(Integer id) {
		List<Docteur> listeDocteur = getSession().createSQLQuery("SELECT * FROM DOCTEUR LEFT JOIN APP_USER ON DOCTEUR.id_personne=APP_USER.id WHERE id_hopital = "+id).addEntity(Docteur.class).list();
		
		return listeDocteur;
	}

}