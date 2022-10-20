package com.example.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.repos.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoService;
	
	// --- find all Dojos ---
	
	public List<Dojo> allDojo(){
		return dojoService.findAll();
		}
	
	
	// --- create a Dojo ---
	
	public Dojo createDojo(Dojo dojo) {
		return dojoService.save(dojo);
	}
	
	// --- find a Dojo ---
	
	public Dojo findDojo (Long id) {
		Optional<Dojo> thisDojo = dojoService.findById(id);
		if (thisDojo.isPresent())
			return thisDojo.get();
		else
			return null;
	}
	
	// --- update Dojo infos ---
	
	public Dojo updateDojo(Dojo dojo) {
		return dojoService.save(dojo);
	}
	
	// --- delete a Dojo ---
	
	public void deleteDojo(Long id) {
		dojoService.deleteById(id);
	}
	
	
}
