package com.websystique.springsecurity.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "BESOIN")
@IdClass(BesoinId.class)
public class Besoin {

	/*#id int not null auto_increment,
    id_organe int,
    id_patient bigint,
    constraint FK_ORGANE_BESOIN foreign key (id_organe) references ORGANE(id),
    constraint FK_PATIENT_BEOSIN foreign key (id_patient) REFERENCES PATIENT (id_personne),
    rank int NOT NULL,
    primary key (id_organe, id_patient) #(id, id_organe, id_patient)*/
	
	
	@Id //@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)  @JoinColumn(name="id_donneur")  @MapsId("donneur")
	private Patient patient;
	
	@Id //@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER) @JoinColumn(name="id_organe") @MapsId("organe")
	private Organe organe;
	
	@Column(name="rank", nullable=false)
	private int rank;

	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		//if(this.patient != null)
		//	this.patient.getBesoins().remove(this);
		
		this.patient = patient;
//		if(!patient.getBesoins().contains(this)) {
//			patient.getBesoins().add(this);
//		}
	}

	public Organe getOrgane() {
		return organe;
	}

	public void setOrgane(Organe organe) {
		this.organe = organe;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
