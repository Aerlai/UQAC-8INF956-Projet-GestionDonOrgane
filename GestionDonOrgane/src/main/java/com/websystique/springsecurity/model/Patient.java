package com.websystique.springsecurity.model;

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
	
//	@Column(name="id_docteur")
//	private int id_docteur;
//	
//	@Column(name="id_hopital")
//	private int id_hopital;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_adresse")
	private Adresse adresse;
	
	public String getGroupe_sang() {
		return groupe_sang;
	}
	
	public void setGroupe_sang(String groupe_sang) {
		this.groupe_sang = groupe_sang;
	}
	
//	public int getId_docteur() {
//		return id_docteur;
//	}
//	
//	public void setId_docteur(int id_docteur) {
//		this.id_docteur = id_docteur;
//	}
//	
//	public int getId_hopital() {
//		return id_hopital;
//	}
//	
//	public void setId_hopital(int id_hopital) {
//		this.id_hopital = id_hopital;
//	}
	
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
