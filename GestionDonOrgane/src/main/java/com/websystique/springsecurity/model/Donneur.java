package com.websystique.springsecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DONNEUR")
public class Donneur {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom",columnDefinition="VARCHAR(30)", nullable=false)
	private String nom;
	
	@Column(name="groupe_sang",columnDefinition="VARCHAR(3)")
	private String groupe_sang;
	
	
	public String getGroupe_sang() {
		return groupe_sang;
	}
	
	public void setGroupe_sang(String groupe_sang) {
		this.groupe_sang = groupe_sang;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString( ) {
		return super.toString() + ", groupe sanguin=" + this.groupe_sang;
//				+ ", id doc=" + this.id_docteur
//				+", id hop=" + this.id_hopital;
	}
	
	
}
