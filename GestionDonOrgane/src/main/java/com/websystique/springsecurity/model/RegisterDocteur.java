package com.websystique.springsecurity.model;

import javax.validation.Valid;

public class RegisterDocteur {


	@Valid
	private Hopital hopital;
	
	@Valid
	private Docteur docteur;
	
	
	public Hopital getHopital() {
		return hopital;
	}
	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}
	public Docteur getDocteur() {
		return docteur;
	}
	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}

	
}
