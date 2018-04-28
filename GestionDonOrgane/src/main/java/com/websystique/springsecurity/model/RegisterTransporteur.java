package com.websystique.springsecurity.model;

import javax.validation.Valid;

public class RegisterTransporteur {

	@Valid
	private Adresse adresse;
	
	@Valid
	private Transporteur transporteur;
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Transporteur getTransporteur() {
		return transporteur;
	}
	public void setTransporteur(Transporteur transporteur) {
		this.transporteur = transporteur;
	}
	
	
}
