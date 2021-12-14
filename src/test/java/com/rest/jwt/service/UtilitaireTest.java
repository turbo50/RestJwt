package com.rest.jwt.service;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilitaireTest {

	@Autowired
	private Utilitaire palindromeTester;
	
	@Test
	public void whenEmptyString_thenAccept() {
	    assertTrue(palindromeTester.isPalindrome(""));
	}
}
