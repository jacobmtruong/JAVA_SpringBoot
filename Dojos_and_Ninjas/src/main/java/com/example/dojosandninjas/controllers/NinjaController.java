package com.example.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.services.DojoService;
import com.example.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	NinjaService service;
	@Autowired
	DojoService dojoService;

	@GetMapping("/create/ninja")
	public String createNinjaPage(@ModelAttribute("ninja") Ninja ninja, Model model) {

		List<Dojo> allDojos = dojoService.allDojo();
		model.addAttribute("allDojos", allDojos);

		return "createNinja.jsp";
	}

	@PostMapping("/create_ninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojo();
			model.addAttribute("allDojos", allDojos);
			return "createNinja.jsp";
		} else {
			service.createNinja(ninja);
			return "redirect:/";
		}

	}

}
