package com.websystique.springsecurity.model;

import javax.validation.Valid;

public class RegisterHopital {

	@Valid
	private Adresse adresse;
	
	@Valid
	private Hopital hopital;
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Hopital getHopital() {
		return hopital;
	}
	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}
	
}
