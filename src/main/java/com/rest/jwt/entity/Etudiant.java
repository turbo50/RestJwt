package com.rest.jwt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "etudiant")
public class Etudiant {

	@Id
	private String id;
	private String nom;
	private String age;
	
	public Etudiant() {
		super();
	}
	public Etudiant(String id, String nom, String age) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", age=" + age + "]";
	}
	
	
}
