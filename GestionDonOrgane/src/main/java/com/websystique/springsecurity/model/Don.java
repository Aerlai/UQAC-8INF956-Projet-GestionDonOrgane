package com.websystique.springsecurity.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DON")
@IdClass(DonId.class)
public class Don {
	
	
	@Id //@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)  @JoinColumn(name="id_donneur")  @MapsId("donneur")
	private Donneur donneur;
	
	@Id //@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER) @JoinColumn(name="id_organe") @MapsId("organe")
	private Organe organe;
	
	@Column(name="date_don", nullable=false)
	private Date dateDon;

	public Donneur getDonneur() {
		return donneur;
	}

	public void setDonneur(Donneur donneur) {
		this.donneur = donneur;
	}

	public Organe getOrgane() {
		return organe;
	}

	public void setOrgane(Organe organe) {
		this.organe = organe;
	}

	public Date getDateDon() {
		return dateDon;
	}

	public void setDateDon(Date dateDon) {
		this.dateDon = dateDon;
	}
	
	
	

}
