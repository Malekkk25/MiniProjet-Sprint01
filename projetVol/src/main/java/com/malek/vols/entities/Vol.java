package com.malek.vols.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVol;

	public String getNumVol() {
		return numVol;
	}

	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}

	public void setIdVol(Long idVol) {
		this.idVol = idVol;
	}
	public Long getIdVol() {
		return idVol;
	}
	private String numVol;
	private String agence;
	private Date dateDepart;
	private String destination;
	private String etat;
	
	public Vol() {
		super();
	}
	
	public Vol(String numVol,String agence,Date dateDepart,String destination,String etat) {
		super();
		this.numVol=numVol;
		this.agence=agence;
		this.dateDepart=dateDepart;
		this.destination=destination;
		this.etat=etat;
		
	}
	
	@Override
	public String toString() {
		return "Vol [idVol=" + idVol + ", numVol=" + numVol + ", agence=" + agence + ", dateDepart=" + dateDepart
				+ ", destination=" + destination + ", etat=" + etat + "]";
	}

	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
