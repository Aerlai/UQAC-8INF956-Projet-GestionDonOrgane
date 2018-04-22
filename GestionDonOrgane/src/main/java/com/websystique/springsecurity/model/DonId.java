package com.websystique.springsecurity.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


public class DonId implements Serializable {
	
	@Id @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)  @JoinColumn(name="id_donneur")
	private Donneur donneur;
	
	@Id @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER) @JoinColumn(name="id_organe")
	private Organe organe;

	public Donneur getDonneur() {
		return donneur;
	}

	public void setDonneur(Donneur donneur) {
		this.donneur = donneur;
	}

	public Organe getOrgane() {
		return organe;
	}

	public void setOrgane(Organe organe) {
		this.organe = organe;
	}
	
	
	
//	private int id;
//	
//	private int donneur;
//	
//	private int organe;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getDonneur() {
//		return donneur;
//	}
//
//	public void setDonneur(int donneur) {
//		this.donneur = donneur;
//	}
//
//	public int getOrgane() {
//		return organe;
//	}
//
//	public void setOrgane(int organe) {
//		this.organe = organe;
//	}
	
	
}
