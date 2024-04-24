package com.security.users.service;

import java.util.List;


import com.security.users.entities.Society;

public interface SocietyService {
	
	Society saveSociety(Society society);
	Society updateSociety(Society society);
	Society getSociety(String id);
	Society findSocietybycode (String code);
	List<Society> findAllSociety(); 
	void deleteSocietyByCode(String code);

}
