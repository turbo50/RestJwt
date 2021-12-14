package com.rest.jwt.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rest.jwt.entity.Etudiant;
import com.rest.jwt.repository.EtudiantRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class EtudiantServiceTest {

	@Mock
	private EtudiantRepository etudiantRepo;
	
	
	private EtudiantService etudServ;
	
	private Flux<Etudiant> fluxEtud;
	
	private Etudiant et = new Etudiant("ID", "Bob", "24");
	private Etudiant et2 = new Etudiant("ID2", "Bob", "24");
	
	@BeforeEach
	public void setUp() {
		etudServ = new EtudiantService(etudiantRepo);
		fluxEtud = Flux.just(et);
		when(etudiantRepo.findAll()).thenReturn(fluxEtud);
		//Preparation données pour l'ajout
		when(etudiantRepo.insert(any(Etudiant.class))).thenReturn(Mono.just(et2));
	}
	
	@Test
	public void Test_getListeOK1() {
		StepVerifier.create(etudServ.getListe()).
		expectNext(et).
		verifyComplete();
		verify(etudiantRepo).findAll();
	}
	
	@Test
	public void Test_getListeOK() {
		StepVerifier.create(fluxEtud).
		expectNext(et).
		verifyComplete();
	}
	
	@Test
	public void test_ajouterEtudiant() {
		StepVerifier.create(etudiantRepo.insert(et)).
		expectNext(et2).
		verifyComplete();
		verify(etudiantRepo).insert(eq(et));
		
	}
	
}
