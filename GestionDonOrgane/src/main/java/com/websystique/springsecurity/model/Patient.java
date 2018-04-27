package com.websystique.springsecurity.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
@PrimaryKeyJoinColumn(name = "id_personne")
public class Patient extends User{
	
	@Column(name="groupe_sang",columnDefinition="VARCHAR(3)")
	private String groupe_sang;
	
	
	
	@ManyToOne
	@JoinColumn(name="id_docteur")
	private Docteur docteur;
//	
//	@Column(name="id_hopital")
//	private int id_hopital;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_adresse")
	private Adresse adresse;
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy="patient", cascade = CascadeType.MERGE)
//	private Set<Besoin> besoins = new HashSet<Besoin>();
//	
//	public Set<Besoin> getBesoins() {
//		return new HashSet<>(besoins);
//	}
//	
//	public void addBesoins(Besoin b) {
//		if(besoins.contains(b)) return;
//		
//		this.besoins.add(b);
//		if(b.getPatient() != this) {
//			b.setPatient(this);
//		}
//	}

	public String getGroupe_sang() {
		return groupe_sang;
	}
	
	public void setGroupe_sang(String groupe_sang) {
		this.groupe_sang = groupe_sang;
	}
	

	
//	
//	public int getId_hopital() {
//		return id_hopital;
//	}
//	
//	public void setId_hopital(int id_hopital) {
//		this.id_hopital = id_hopital;
//	}
	
	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		if(this.docteur != null)
			this.docteur.getPatients().remove(this);
		
		this.docteur = docteur;
		if(!docteur.getPatients().contains(this)) {
			docteur.getPatients().add(this);
		}
	}

	public Adresse getAdresse() {
	    return adresse;
	  }

	  public void setAdresse(Adresse adresse) {
	    this.adresse = adresse;
	  }

	
	
	@Override
	public String toString( ) {
		return super.toString() + ", groupe sanguin=" + this.groupe_sang;
//				+ ", id doc=" + this.id_docteur
//				+", id hop=" + this.id_hopital;
	}
	
	
}
