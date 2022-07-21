package com.levifreire.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.levifreire.springbootmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
