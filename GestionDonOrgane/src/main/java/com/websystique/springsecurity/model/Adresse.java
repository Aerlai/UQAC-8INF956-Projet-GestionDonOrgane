package com.websystique.springsecurity.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ADRESSE")
public class Adresse {

	/*	id bigint NOT NULL auto_increment,
	Address1 VARCHAR(120) NOT NULL,
	Address2    VARCHAR(120),
	Address3    VARCHAR(120),
	City        VARCHAR(100) NOT NULL,
    State       CHAR(2),
    Country     CHAR(2) NOT NULL,
    PostalCode  VARCHAR(16) NOT NULL,*/
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message="Entrez votre adresse")
	@Size(max=120, message="120 caractères maximum. Divisez avec les autres champs")
	@Column(name="Address1", nullable=false, columnDefinition="VARCHAR(120)")
	private String address1;
	
	@Size(max=120, message="120 caractères maximum. Divisez avec les autres champs")
	@Column(name="Address2", nullable=true, columnDefinition="VARCHAR(120)")
	private String address2;
		
	@Size(max=120, message="120 caractères maximum. Divisez avec les autres champs")
	@Column(name="Address3", nullable=true, columnDefinition="VARCHAR(120)")
	private String address3;

	@NotEmpty(message = "Entrez votre nom de ville")
	@Size(max=100)
	@Column(name="City", nullable=false, columnDefinition="VARCHAR(100)")
	private String city;

	@Size(max=2, message = "Doit être en deux lettres (ex : Québec = QC)")
	@Column(name="State", nullable=true)
	private String state;
	

	@NotEmpty(message = "Entrez votre indicatif pays")
	@Size(min=2, max=2, message="Doit être en deux lettres (ex : Canada = CA)")
	@Column(name="Country", nullable=false, columnDefinition="VARCHAR(2)")
	private String country;

	@NotEmpty
	@Size(max=16, message="Maximum 16 lettres")
	@Column(name="PostalCode", nullable=false, columnDefinition="VARCHAR(16)")
	private String postalCode;
	

	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}








	public String getAddress1() {
		return address1;
	}




	public void setAddress1(String address1) {
		this.address1 = address1;
	}




	public String getAddress2() {
		return address2;
	}




	public void setAddress2(String address2) {
		this.address2 = address2;
	}




	public String getAddress3() {
		return address3;
	}




	public void setAddress3(String address3) {
		this.address3 = address3;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getPostalCode() {
		return postalCode;
	}




	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}




	@Override
	public String toString() {
		return "Adresse : " + id + " , Adresse 1 :" +address1;
	}

	
}
