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
	private int dateDon;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Organe getOrgane() {
		return organe;
	}

	public void setOrgane(Organe organe) {
		this.organe = organe;
	}

	public int getDateDon() {
		return dateDon;
	}

	public void setDateDon(int dateDon) {
		this.dateDon = dateDon;
	}
	
	
}
