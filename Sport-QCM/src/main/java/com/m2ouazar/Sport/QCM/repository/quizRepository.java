package com.m2ouazar.Sport.QCM.repository;

import com.m2ouazar.Sport.QCM.model.quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizRepository extends MongoRepository<quiz,String> {
}
