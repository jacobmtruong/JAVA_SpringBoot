package com.example.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.services.DojoService;
import com.example.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {
	
	@Autowired
	DojoService service;
	
	@Autowired
	NinjaService ninjaService;
	
	// --- Dojo Page & Create new Dojo
	@GetMapping("/create/dojo")
	public String createDojoPage(@ModelAttribute("dojo") Dojo dojo) {
		return "createDojo.jsp";
	}
	
	@PostMapping("/create_dojo")
	public String createDojo (@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors())
			return "createDojo.jsp";
		else {
			service.createDojo(dojo);
			return "redirect:/create/dojo";
		}
	}
	
	@GetMapping("/")
	public String allDojoPage(Model model) {
		
		List<Dojo> allDojo = service.allDojo();
		
		model.addAttribute("allDojo", allDojo);
		
		return "allDojo.jsp";
	}
	
	
	@GetMapping("/dojo/{id}")
	public String viewDojo(@PathVariable("id") Long id, Model model) {
		
		Dojo thisDojo = service.findDojo(id);
		model.addAttribute("thisDojo", thisDojo);
		
		return "viewDojo.jsp";
	}

}
