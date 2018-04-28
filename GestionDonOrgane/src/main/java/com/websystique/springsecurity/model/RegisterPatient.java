package com.websystique.springsecurity.model;

import javax.validation.Valid;

public class RegisterPatient {


	@Valid
	private Adresse adresse;
	
	@Valid
	private Patient patient;
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
