package com.security.users.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.security.users.entities.Society;
import com.security.users.entities.Handicap_type;
import com.security.users.entities.Role;
import com.security.users.entities.User;
import com.security.users.repos.Handicape_typeRepository;
import com.security.users.repos.RoleRepository;
import com.security.users.repos.SocietyRepository;
import com.security.users.repos.UserRepository;
import com.security.users.service.exception.ExpiredTokenException;
import com.security.users.service.exception.InvalidTokenException;
import com.security.users.service.register.RegistationRequest;
import com.security.users.service.register.VerificationToken;
import com.security.users.service.register.VerificationTokenRepository;


@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	VerificationTokenRepository verificationTokenRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	SocietyRepository societyrepo;
	
	
	@Autowired
	Handicape_typeRepository hanicape;
	
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);

	}
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRep.findByUsername(username);

	}
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRep.save(role);

	}
	@Override
	public User addRoleToUser(String username, String rolename) {
		// TODO Auto-generated method stub
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;
	}
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}
	
	
	 
	@Override 
	 public User registerUser(RegistationRequest request) { 
	/*  Optional<User> optionaluser = userRep.findByEmail(request.getEmail()); 
	  if(optionaluser.isPresent()) 
	   throw new EmailAlreadyExistsException("email déjà existant!"); */
	   
	     User newUser = new User(); 
	       
	        newUser.setUsername(request.getUsername()); 
	        newUser.setEmail(request.getEmail()); 
	        newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword())); 
	        newUser.setEnabled(false);
	        newUser.setCode(request.getCode());
	        userRep.save(newUser); 
	 
	        //ajouter à newUser le role par défaut USER 
	        Role r = roleRep.findByRole("USER"); 
	        List<Role> roles = new ArrayList<>(); 
	        roles.add(r); 
	        newUser.setRoles(roles); 
	       
	        userRep.save(newUser); 
	        
	        
	        Society s = societyrepo.findByCode(request.getCode());
		       
		       List <User> lst =userRep.findAllByCode(request.getCode());
		       
		       s.setUsers(lst);
		       societyrepo.save(s);
		      
		       
	        
	        
	          
	         
	   
	        return newUser; 
	 } 
	public String  generateCode() { 
	     Random random = new Random(); 
	     Integer code = 100000 + random.nextInt(900000);  
	      
	     return code.toString(); 
	 } 
	
	@Override 
	 public User validateToken(String code) {  
	   VerificationToken token = verificationTokenRepo.findByToken(code); 
	         if(token == null){ 
	          throw new InvalidTokenException("Invalid Token"); 
	         } 
	        
	         User user = token.getUser(); 
	         Calendar calendar = Calendar.getInstance(); 
	if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){ 
	          verificationTokenRepo.delete(token); 
	          throw new ExpiredTokenException("expired Token"); 
	         } 
	         user.setEnabled(true); 
	         userRep.save(user); 
	         return user; 
	 }
	@Override
	public User addhandicap_user(String iduser, String handicapName) {
		User usr=userRep.findById(iduser).orElseThrow(() -> new NoSuchElementException("No handicap found with id: " + iduser));
		Handicap_type handicap=hanicape.findByTypehandicap(handicapName).orElseThrow(() -> new NoSuchElementException("No handicap found with id: " + handicapName));
		List<Handicap_type> hand =new ArrayList<>();
		hand.add(handicap);
		usr.setHandicap_type(hand);
		String code = this.generateCode(); 
        
        VerificationToken token = new VerificationToken(code, usr); 
        verificationTokenRepo.save(token); 
		return userRep.save(usr);
	}
	
	
		
}
