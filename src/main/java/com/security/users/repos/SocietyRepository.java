package com.security.users.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.security.users.entities.Society;



public interface SocietyRepository extends MongoRepository<Society, String>{
Society findByCode(String code);
Society deleteByCode(String code);
}
