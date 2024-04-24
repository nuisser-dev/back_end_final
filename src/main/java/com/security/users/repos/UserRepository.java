package com.security.users.repos;
import java.util.List;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.security.users.entities.User;
@Repository
public interface UserRepository  extends MongoRepository<User, String>{
	User findByUsername(String username);
	Optional<User> findByEmail(String email);
	User findByCode(String code);
	List<User> findAllByCode(String code);
	
	
}
