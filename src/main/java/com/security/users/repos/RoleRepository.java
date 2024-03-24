package com.security.users.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.security.users.entities.Role;
public interface RoleRepository  extends MongoRepository<Role, String> {
	Role findByRole(String role);
}
