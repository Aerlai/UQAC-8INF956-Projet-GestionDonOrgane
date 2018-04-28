package com.websystique.springsecurity.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "DOCTEUR")
@PrimaryKeyJoinColumn(name = "id_personne")
public class Docteur extends User{
	
	/*id_personne bigint,
    id_hopital bigint,
    specialite varchar(30) NOT NULL,
    #id_specialite int,
    constraint FK_PERSONNE foreign key (id_personne) REFERENCES APP_USER (id),
    constraint FK_HOPITAL foreign key (id_hopital) REFERENCES HOPITAL (id),
    #constraint FK_SPRECIALITE foreign key (id_specialite) REFERENCES SPECIALITE (id),
    PRIMARY KEY (id_personne, id_hopital),#, id_specialite),
    UNIQUE(id_personne)
    */
	
	@ManyToOne//(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_hopital")
	@NotNull
	private Hopital hopital;
	
	@Column(name="specialite",columnDefinition="VARCHAR(30)",nullable=false)
	@NotEmpty
	@Size(max=30)
	private String specialite;
	
//	@OneToOne(cascade=CascadeType.PERSIST)
//	@JoinColumn(name="id_adresse")
//	private Adresse adresse;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="docteur", cascade = CascadeType.MERGE)
	private Collection<Patient> patients = new ArrayList<Patient>();
	
	
	
	
	public Collection<Patient> getPatients() {
		return new ArrayList<>(patients);
	}
	
	public void addPatient(Patient p) {
		if(patients.contains(p)) return;
		
		this.patients.add(p);
		if(p.getDocteur() != this) {
			p.setDocteur(this);
		}
	}

	public Hopital getHopital() {
		return hopital;
	}

	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	
	@Override
	public String toString( ) {
		return super.toString() + ", Specialite =" + this.specialite;
//				+ ", id doc=" + this.id_docteur
//				+", id hop=" + this.id_hopital;
	}
	
	
}
