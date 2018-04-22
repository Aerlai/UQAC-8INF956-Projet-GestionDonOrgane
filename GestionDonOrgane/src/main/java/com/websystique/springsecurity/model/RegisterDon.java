package com.websystique.springsecurity.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public class RegisterDon {
	
	private  Set<Organe> listeDon;
	
	private Donneur donneur;
	
	private Date dateDon;

	public Set<Organe> getListeDon() {
		return listeDon;
	}

	public void setListeDon(Set<Organe> listeDon) {
		this.listeDon = listeDon;
	}

	public Donneur getDonneur() {
		return donneur;
	}

	public void setDonneur(Donneur donneur) {
		this.donneur = donneur;
	}

	public Date getDateDon() {
		return dateDon;
	}

	public void setDateDon(Date dateDon) {
		this.dateDon = dateDon;
	}
	
	

}
