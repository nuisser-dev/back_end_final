package com.security.users.service.register;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationTokenRepository  extends MongoRepository<VerificationToken, String>{
	 VerificationToken findByToken(String token);
}
