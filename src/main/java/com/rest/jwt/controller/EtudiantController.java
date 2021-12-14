package com.rest.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.jwt.entity.Etudiant;
import com.rest.jwt.service.EtudiantService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/ecole/")
public class EtudiantController {
	
	@Autowired 
	private EtudiantService etudiantSer;
	
	@GetMapping("/etudiants")
	public ResponseEntity<Flux<Etudiant>> getliste(){
		return ResponseEntity.ok(etudiantSer.getListe());
	}
	
	@GetMapping("/etudiants/{id}")
	public ResponseEntity<Mono<Etudiant>> getElement(@PathVariable(value = "id") String id){
		return  ResponseEntity.ok(etudiantSer.getElement(id));
	}
	
	@PostMapping("/etudiants")
	public Mono<Etudiant> ajouter(@RequestBody Etudiant et){
		return etudiantSer.ajouter(et);
	}
	
	@PutMapping("/etudiants/{id}")
	public Mono<Etudiant> modifier(@PathVariable String id, @RequestBody Mono<Etudiant> et){
		return etudiantSer.modifier(id, et);
	}

	@DeleteMapping("/etudiants/{id}")
	public Mono<Void> supprimer(@PathVariable String id){
		return etudiantSer.supprimer(id);
	}
}
