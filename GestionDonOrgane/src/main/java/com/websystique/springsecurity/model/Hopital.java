package com.websystique.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HOPITAL")
public class Hopital {

	/*
	 * id bigint not null auto_increment,
    nom VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    id_adresse bigint,
    constraint FK_ADRESSE foreign key (id_adresse) REFERENCES ADRESSE (id),
    UNIQUE(id_adresse),
    primary key (id)*/
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom",columnDefinition="VARCHAR(30)", nullable=false)
	private String nom;
	
	@Column(name="email",columnDefinition="VARCHAR(30)", nullable=false)
	private String email;
	
	@Column(name="id_adresse", unique=true)
	private int id_adresse;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_adresse() {
		return id_adresse;
	}

	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}
	
	
	
	
	
}
