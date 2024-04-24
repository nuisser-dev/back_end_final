package com.security.users.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.users.entities.Functionality;
import com.security.users.service.FunctionalityService;


@RestController
@RequestMapping("/functionality")
@CrossOrigin
public class FunctionalityRestController {

	@Autowired
	FunctionalityService functservice;
	
	@RequestMapping(value="/addfunctionalty",method = RequestMethod.POST)
	public Functionality createFunctionality(@RequestBody Functionality functionality) {
	return functservice.saveFunctionality(functionality);
	}
	
	@RequestMapping(value="/getall_functionalty",method = RequestMethod.GET)
	public List<Functionality> getall_functionalty() {
	return functservice.findAllFunctionalitys();
	}
	
	@RequestMapping(value="/delfn/{id}",method = RequestMethod.DELETE)
	public void delete_functionalty(@PathVariable("id") String id) {
	 functservice.deleteFunctionalityById(id);}
	
	
}
