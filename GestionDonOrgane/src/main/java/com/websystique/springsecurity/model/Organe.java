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

@Entity
@Table(name="ORGANE")
public class Organe {

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
	
	@Column(name="organe",columnDefinition="VARCHAR(20)", nullable=false)
	private String organe;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrgane() {
		return organe;
	}

	public void setOrgane(String organe) {
		this.organe = organe;
	}


	
	
	
}
