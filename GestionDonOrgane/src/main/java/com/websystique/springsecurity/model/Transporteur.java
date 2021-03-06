package com.websystique.springsecurity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TRANSPORTEUR")
public class Transporteur {

	/*
	 * id INT NOT NULL AUTO_INCREMENT,
    nom varchar(30) NOT NULL,    
    email VARCHAR(30) NOT NULL,
    id_adresse bigint,
    constraint FK_ADRESSE_TRANSPORTEUR foreign key (id_adresse) REFERENCES ADRESSE (id),
    UNIQUE(nom),
    unique(id_adresse),
    primary key (id)*/
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom",columnDefinition="VARCHAR(30)", nullable=false)
	@NotEmpty
	@Size(max=30)
	private String nom;
	
	@Column(name="email",columnDefinition="VARCHAR(30)", nullable=false)
	@Email
	@NotEmpty
	@Size(max=30)
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
