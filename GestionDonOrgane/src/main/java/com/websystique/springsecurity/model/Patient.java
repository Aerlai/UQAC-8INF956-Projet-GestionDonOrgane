package com.websystique.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
@PrimaryKeyJoinColumn(name = "id_personne")
public class Patient extends User{
	
	@Column(name="groupe_sang",columnDefinition="VARCHAR(3)")
	private String groupe_sang;
	
	public String getGroupe_sang() {
		return groupe_sang;
	}
	
	public void setGroupe_sang(String groupe_sang) {
		this.groupe_sang = groupe_sang;
	}
	
	@Override
	public String toString( ) {
		return super.toString() + ", groupe sanguin=" + this.groupe_sang;
	}
	
	
}
