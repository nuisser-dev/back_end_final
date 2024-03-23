package com.ayoub.users.service;
import java.util.List;
import java.util.Optional;

import com.ayoub.users.entities.Role;
import com.ayoub.users.entities.User;
import com.ayoub.users.service.register.RegistationRequest;
public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers(); 
	User  registerUser (RegistationRequest request) ;
	public User validateToken(String code);
	
}
