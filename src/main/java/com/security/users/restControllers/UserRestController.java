package com.security.users.restControllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.users.entities.Handicap_type;
import com.security.users.entities.User;
import com.security.users.service.UserService;
import com.security.users.service.register.RegistationRequest;

@RestController
@CrossOrigin(origins = "*")
/*@RequestMapping("/api")*/
public class UserRestController {

	@Autowired
	UserService userService;
	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
	return userService.findAllUsers();
	}
	@PostMapping("/register") 
	 public User register(@RequestBody  RegistationRequest request) 
	 { 
	  return userService.registerUser(request); 
	 } 
	 @GetMapping("/verifyEmail/{token}") 
	    public User verifyEmail(@PathVariable("token") String token){    
	  return userService.validateToken(token); 
	    } 
	 @PostMapping("/add_handicap_user/{iduser}/{handicapName}") 
	 public User addhandicap_user(@PathVariable("iduser") String iduser ,@PathVariable("handicapName") String handicapName) 
	 { 
	  return userService.addhandicap_user(iduser,handicapName);
	 } 
	 
	 
}
