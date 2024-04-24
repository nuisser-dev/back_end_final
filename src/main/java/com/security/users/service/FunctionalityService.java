package com.security.users.service;

import java.util.List;


import com.security.users.entities.Functionality;

public interface FunctionalityService {
	
	Functionality saveFunctionality(Functionality functionality);
	Functionality updateFunctionality(Functionality functionality);
	Functionality getFunctionality(String id);
	Functionality findFunctionalitybyname (String name);
	List<Functionality> findAllFunctionalitys(); 
	void deleteFunctionality(Functionality functionality);
	void deleteFunctionalityById(String id);

}
