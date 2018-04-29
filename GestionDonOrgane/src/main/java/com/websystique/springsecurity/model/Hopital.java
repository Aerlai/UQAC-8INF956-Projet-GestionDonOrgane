package com.websystique.springsecurity.model;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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
	
	@Column(name="nom",columnDefinition="VARCHAR(30)", nullable=false, unique=true)
	@Size(max=30)
	@NotEmpty
	private String nom;
	
	@Column(name="email",columnDefinition="VARCHAR(30)", nullable=false)
	@Email
	@Size(max=30)
	@NotEmpty
	private String email;
	
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_adresse")
	private Adresse adresse;
	

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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	
	
}
