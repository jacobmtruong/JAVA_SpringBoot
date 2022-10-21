package com.example.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@Controller
public class FormController {
	
	private final BookService service;
	
	public FormController(BookService service) {
		this.service = service;
	}
	
	
	// Mapping for form:form -- this function means create a blank book
	@GetMapping("/books/new") 
	public String newNook(@ModelAttribute("book") Book book) {
		return "anotherAdd.jsp";
	}
	
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors())
			return "anotherAdd.jsp";
		else
			service.createBook(book);
			return "redirect:/";
	}
}
