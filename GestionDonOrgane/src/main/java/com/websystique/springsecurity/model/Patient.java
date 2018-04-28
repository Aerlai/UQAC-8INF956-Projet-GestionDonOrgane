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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PATIENT")
@PrimaryKeyJoinColumn(name = "id_personne")
public class Patient extends User{
	
	@Column(name="groupe_sang",columnDefinition="VARCHAR(3)")
	@NotEmpty
	@Size(max=3, min=2)
	private String groupe_sang;

	@ManyToOne
	@JoinColumn(name="id_docteur")
	private Docteur docteur;

	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_adresse")
	private Adresse adresse;
	

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
