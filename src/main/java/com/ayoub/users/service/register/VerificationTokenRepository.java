package com.ayoub.users.service.register;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationTokenRepository  extends MongoRepository<VerificationToken, Long>{
	 VerificationToken findByToken(String token);
}
