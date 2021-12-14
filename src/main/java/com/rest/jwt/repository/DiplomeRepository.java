package com.rest.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.jwt.entity.*;

@Repository
public interface DiplomeRepository extends MongoRepository<Diplome, String> {

}
