package com.example.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.repos.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaService;
	
	
	// --- get all Ninjas ---
	
	public List<Ninja> allNinja(){
		return ninjaService.findAll();
	}
	
	// --- create a Ninja ---
	
	public Ninja createNinja (Ninja ninja) {
		return ninjaService.save(ninja);
	}
	
	// --- update a Ninja info ---
	
	public Ninja updateNinja (Ninja ninja) {
		return ninjaService.save(ninja);	
	}
	
	// --- find a Ninja ---
	
	public Ninja findNinja (Long id) {
		Optional<Ninja> thisNinja = ninjaService.findById(id);
		if (thisNinja.isPresent())
			return thisNinja.get();
		else 
			return null;
	}
	
	// --- delete a Ninja ---
	
	public void deleteNinja(Long id) {
		ninjaService.deleteById(id);
	}
	
//	public Optional<Ninja> allNinjainDojo(Long dojo_id){
//		return ninjaService.findById(dojo_id);
//	}
	
}
