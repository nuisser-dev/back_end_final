package com.ayoub.users.repos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ayoub.users.entities.User;

public interface UserRepository  extends MongoRepository<User, Long>{
	User findByUsername(String username);
	Optional<User> findByEmail(String email);
}
