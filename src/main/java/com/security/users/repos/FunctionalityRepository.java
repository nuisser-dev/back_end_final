package com.security.users.repos;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.security.users.entities.Functionality;




public interface FunctionalityRepository extends MongoRepository<Functionality, String> {
	Functionality findByname(String name);

}
