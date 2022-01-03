package com.rest.jwt.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import com.rest.jwt.entity.Etudiant;
import com.rest.jwt.service.EtudiantService;

import reactor.core.publisher.Mono;

@SpringBootTest
@WebMvcTest
public class EtudiantControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebTestClient webTest;
	
	@MockBean
	private EtudiantService etudServ;
	
	private Etudiant et;
	private Mono<Etudiant> monoEt;
	
	@BeforeEach
	public void setUp() {
		et = new Etudiant("23", "Bob", "30");
		monoEt = Mono.just(et);
	}
	
	@Test
	public void test_getEtudiantID() {
		
	}
}
