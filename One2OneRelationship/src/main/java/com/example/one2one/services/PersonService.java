package com.example.one2one.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.one2one.models.Person;
import com.example.one2one.repos.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personService;
	
	public List<Person> allPerson(){
		return personService.findAll();
		}
	
	
	
}
