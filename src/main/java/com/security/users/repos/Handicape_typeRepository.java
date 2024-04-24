package com.security.users.repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.security.users.entities.Handicap_type;

@Repository
public interface Handicape_typeRepository extends MongoRepository<Handicap_type, String>{
	
	Optional<Handicap_type> findByTypehandicap(String type_handicap);

}
