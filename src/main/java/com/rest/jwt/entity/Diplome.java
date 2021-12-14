package com.rest.jwt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "diplome")
public class Diplome {

	@Id
	private String id;
	private String libelle;
	private int annee;
	@DBRef
	private Etudiant impetrant;
	
	public Diplome() {
		super();
	}

	public Diplome(String id, String libelle, int annee, Etudiant impetrant) { /*-?|Revue1|Aquilas Damico LEN|c0|*/
		super();
		this.id = id;
		this.libelle = libelle;
		this.annee = annee;
		this.impetrant = impetrant;
	} /*-|Revue1|Aquilas Damico LEN|c0|?*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Etudiant getImpetrant() {
		return impetrant;
	}

	public void setImpetrant(Etudiant impetrant) {
		this.impetrant = impetrant;
	}

	@Override
	public String toString() { /*-?|Revue1|Aquilas Damico LEN|c1|*/
		return "Diplome [id=" + id + ", libelle=" + libelle + ", annee=" + annee + ", impetrant=" + impetrant + "]";
	} /*-|Revue1|Aquilas Damico LEN|c1|?*/
	
	
}
