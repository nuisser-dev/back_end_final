package com.ayoub.users.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayoub.users.entities.Role;
public interface RoleRepository  extends MongoRepository<Role, Long> {
	Role findByRole(String role);
}
