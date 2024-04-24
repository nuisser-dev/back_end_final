package com.security.users.restControllers;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.users.entities.Handicap_type;
import com.security.users.entities.Society;
import com.security.users.repos.Handicape_typeRepository;
import com.security.users.repos.SocietyRepository;
import com.security.users.service.SocietyService;



@RestController
@RequestMapping("/handicap_type")
@CrossOrigin
public class Handicap_typeRestcontroller {

	@Autowired
	Handicape_typeRepository handicap;
	
	@RequestMapping(value="/addhandicap",method = RequestMethod.POST)
	public Handicap_type addhandicap(@RequestBody Handicap_type handicap_type) {
	return handicap.save(handicap_type);
	}
	
	@RequestMapping(value="get/{id}",method = RequestMethod.GET)
	public Optional<Handicap_type> gethandicap_type_byid(@PathVariable("id") String id) {
	return handicap.findById(id);
	}
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Handicap_type> getAllSociety() {
	return handicap.findAll();
	}
}
