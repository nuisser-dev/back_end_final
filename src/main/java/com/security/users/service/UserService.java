package com.security.users.service;
import java.util.List;

import com.security.users.entities.Role;
import com.security.users.entities.User;
import com.security.users.service.register.RegistationRequest;
public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers(); 
	User  registerUser (RegistationRequest request) ;
	public User validateToken(String code);
	
}
