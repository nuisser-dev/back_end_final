package com.security.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.users.entities.Society;
import com.security.users.repos.SocietyRepository;


@Service
public class SocietyServiceimpl implements SocietyService {

	@Autowired
	SocietyRepository societyrepo;
	
	
	
	@Override
	public Society saveSociety(Society society) {
		// TODO Auto-generated method stub
		return societyrepo.save(society);
	}

	@Override
	public Society updateSociety(Society society) {
		// TODO Auto-generated method stub
		return societyrepo.save(society);
	}

	@Override
	public Society getSociety(String id) {
		// TODO Auto-generated method stub
		return societyrepo.findById(id).get();
	}

	@Override
	public Society findSocietybycode(String code) {
		// TODO Auto-generated method stub
		return societyrepo.findByCode(code);
	}

	@Override
	public List<Society> findAllSociety() {
		// TODO Auto-generated method stub
		return societyrepo.findAll();
	}

	@Override
	public void deleteSocietyByCode(String code) {
		// TODO Auto-generated method stub
		societyrepo.deleteByCode(code);
	}

}
