package com.security.users.security;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.users.entities.Handicap_type;
import com.security.users.entities.User;
import com.security.users.repos.UserRepository;
import com.security.users.service.UserService;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private AuthenticationManager authenticationManager;
	private UserRepository userrepo;
	 
	
	 
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) 
	{
	super();
	this.authenticationManager = authenticationManager;
	
	
	}
	
	
	public JWTAuthenticationFilter(AuthenticationManager authMgr, UserRepository userrepo2) {
		super();
		this.authenticationManager = authMgr;
		this.userrepo=userrepo2;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException {
	User user =null;
	try {
	user = new ObjectMapper().readValue(request.getInputStream(),User.class);
	
	
	} catch (JsonParseException e) {
	e.printStackTrace();
	} catch (JsonMappingException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
	return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,Authentication authResult) throws IOException, ServletException 
	{
	org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
	
	/*User usrr=userRepository.findByUsername(springUser.getUsername());
	List<Handicap_type> handicaps = userService.findHandicap_typeByUsername(usrr.getUsername());
	List<String> handicapTypes = new ArrayList<>();
    for (Handicap_type handicap : handicaps) {
        handicapTypes.add(handicap.getType_handicap());
    }
	*/
	//User user = new ObjectMapper().readValue(request.getInputStream(),User.class);
	
	
	 User user = this.userrepo.findByUsername(springUser.getUsername());

List<String> handicapTypes = new ArrayList<>();
if (user != null && user.getHandicap_type() != null) {
    for (Handicap_type handicap : user.getHandicap_type()) {
        handicapTypes.add(handicap.getTypehandicap());
    }
}
     
     
	
	
	
	
	
	List<String> roles = new ArrayList<>();
	springUser.getAuthorities().forEach(au-> {roles.add(au.getAuthority());});
	
	
	 String jwt = JWT.create()
	            .withSubject(springUser.getUsername())
	            .withClaim("id", user.getId())
	            .withArrayClaim("roles", roles.toArray(new String[0]))
	            .withArrayClaim("handicap_types", handicapTypes.toArray(new String[0]))
	            .withExpiresAt(new Date(System.currentTimeMillis() + SecParams.EXP_TIME))
	            .sign(Algorithm.HMAC256(SecParams.SECRET));
	response.addHeader("Authorization", jwt);
	}

}
