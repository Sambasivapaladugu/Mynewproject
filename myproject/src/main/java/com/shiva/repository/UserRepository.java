package com.shiva.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shiva.model.User;

@Repository
public interface UserRepository extends MongoRepository<User , String> {

}
