package com.m2ouazar.Sport.QCM.repository;

import com.m2ouazar.Sport.QCM.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<user,String> {
}
