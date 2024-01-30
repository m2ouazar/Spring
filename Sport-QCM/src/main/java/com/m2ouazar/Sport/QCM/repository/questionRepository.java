package com.m2ouazar.Sport.QCM.repository;

import com.m2ouazar.Sport.QCM.model.question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionRepository extends MongoRepository<question,String> {

    List<question> findByRubrique(String rubrique);

}
