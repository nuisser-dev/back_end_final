package com.security.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.users.entities.Functionality;
import com.security.users.repos.FunctionalityRepository;


@Service
public class FunctionalityServiceimpl implements FunctionalityService{

	
	@Autowired
	FunctionalityRepository functionaltyrespo;
	
	
	@Override
	public Functionality saveFunctionality(Functionality functionality) {
		
		return functionaltyrespo.save(functionality);
	}

	@Override
	public Functionality updateFunctionality(Functionality functionality) {
		
		return functionaltyrespo.save(functionality);
	}

	@Override
	public Functionality getFunctionality(String id) {
		
		return functionaltyrespo.findById(id).get();
	}

	@Override
	public Functionality findFunctionalitybyname(String name) {
		
		return functionaltyrespo.findByname(name);
	}

	@Override
	public List<Functionality> findAllFunctionalitys() {
		
		return functionaltyrespo.findAll();
	}

	@Override
	public void deleteFunctionality(Functionality functionality) {
		functionaltyrespo.delete(functionality);
		
	}

	@Override
	public void deleteFunctionalityById(String id) {
		functionaltyrespo.deleteById(id);
		
	}

}
