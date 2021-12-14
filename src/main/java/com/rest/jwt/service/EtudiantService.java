package com.rest.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.jwt.entity.Etudiant;
import com.rest.jwt.repository.EtudiantRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EtudiantService implements IBaseService<Etudiant, String> {

	private EtudiantRepository etudiantRepo;
	
	@Autowired
	public EtudiantService(EtudiantRepository etudiantRepo) {
		super();
		this.etudiantRepo = etudiantRepo;
	}

	@Override
	public Flux<Etudiant> getListe() {
		return etudiantRepo.findAll();
	}

	@Override
	public Mono<Etudiant> getElement(String v) {
		return etudiantRepo.findById(v);
	}

	@Override
	public Mono<Etudiant> ajouter(Etudiant t) {
		return etudiantRepo.insert(t);
	}

	@Override
	public Mono<Etudiant> modifier(String v, Mono<Etudiant> t) {
		return etudiantRepo.findById(v).
				flatMap(etudiant -> t.map(et ->{
						 etudiant.setId(et.getId());
						 etudiant.setNom(et.getNom());
						 etudiant.setAge(et.getAge());
						 return etudiant;
				})).flatMap(et -> etudiantRepo.save(et));
	}

	@Override
	public Mono<Void> supprimer(String v) {
		return etudiantRepo.deleteById(v);
	}

}
