package com.rest.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.rest.jwt.entity.Etudiant;
import com.rest.jwt.service.EtudiantService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/ecole/")
public class EtudiantController2 {
	@Autowired
	private EtudiantService etudiantSer;
	
	@GetMapping(value = "etudiant_stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE )
	public Flux<Etudiant> liste(){
		Flux<Long> interval=Flux.interval(Duration.ofMillis(1000));
		Flux<Etudiant> f = etudiantSer.getListe();
		return Flux.zip(interval, f).
				map(e  ->  e.getT2()).
				share();
	}
}
