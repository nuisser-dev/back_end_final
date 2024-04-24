package com.security.users.restControllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.security.users.entities.Society;
import com.security.users.repos.SocietyRepository;
import com.security.users.service.SocietyService;



@RestController
@RequestMapping("/society")
@CrossOrigin
public class SocietyRestController {

	@Autowired
SocietyService societyservice;
	@Autowired
	SocietyRepository societyrep;
		
	
	@RequestMapping(value="/addsociety",method = RequestMethod.POST)
	public Society createSociety(@RequestBody Society society) {
	return societyservice.saveSociety(society);
	}
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Society> getAllSociety() {
	return societyservice.findAllSociety();
	}
	@RequestMapping(value="del/{code}",method = RequestMethod.DELETE)
	public void deleteSociety(@PathVariable("code") String code)
	{
		societyservice.deleteSocietyByCode(code);
	}
	@RequestMapping(value="get/{id}",method = RequestMethod.GET)
	public Society getSocietyById(@PathVariable("id") String id) {
	return societyservice.getSociety(id);
	 }
	@RequestMapping(value="getby/{code}",method = RequestMethod.GET)
	public Society getSocietyByCode(@PathVariable("code") String code) {
	return societyrep.findByCode(code);
	 }
}
