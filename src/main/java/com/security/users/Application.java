package com.security.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.security.users.repos.RoleRepository;
import com.security.users.service.UserService;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class Application {
	@Autowired
	UserService userService;
@Autowired 
RoleRepository rolerepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*
	@PostConstruct
	void init_users() {
	Role role =new Role (null,"ADMIN");
	Role role2=new Role (null,"USER");
	rolerepository.save(role);
	rolerepository.save(role2);
	List lst = new ArrayList <Role> ();
	lst.add(role);
	User admin = new User ("1","admin","12345",true,"amine@gmail.com",lst);
	userService.saveUser(admin);
	
	} */
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}
}
