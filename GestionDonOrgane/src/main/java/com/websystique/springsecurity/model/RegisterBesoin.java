package com.websystique.springsecurity.model;

import java.util.Set;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisterBesoin {
	
	
	private  Set<Organe> listeBesoin;

	public Set<Organe> getListeBesoin() {
		return listeBesoin;
	}

	public void setListeBesoin(Set<Organe> listeDon) {
		this.listeBesoin = listeDon;
	}
	
	
}
