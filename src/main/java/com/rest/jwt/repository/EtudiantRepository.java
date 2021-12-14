package com.rest.jwt.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.jwt.entity.*;

@Repository
public interface EtudiantRepository extends ReactiveMongoRepository<Etudiant, String> {

}
