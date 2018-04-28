package com.websystique.springsecurity.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

public class BesoinId implements Serializable {
	
	@Valid
	@Id @ManyToOne @JoinColumn(name="id_patient") //(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)  @JoinColumn(name="id_patient")
	private Patient patient;
	
	@Valid
	@Id @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER) @JoinColumn(name="id_organe")
	private Organe organe;

	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Organe getOrgane() {
		return organe;
	}

	public void setOrgane(Organe organe) {
		this.organe = organe;
	}
}
