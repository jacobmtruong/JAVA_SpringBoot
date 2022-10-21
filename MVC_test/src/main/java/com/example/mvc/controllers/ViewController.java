package com.example.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@Controller
public class ViewController {
	
	
	
	private final BookService bookServ;
	
	public ViewController(BookService bookServ) {
		this.bookServ = bookServ;
	}
	
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Book> alltheBooks = bookServ.allBooks();
		
		model.addAttribute("alltheBooks", alltheBooks);
		
		return "books.jsp";
	}
	
	@RequestMapping("/books/{id}")
	public String onebook(@PathVariable("id") Long id, Model model) {
		Book onebook = bookServ.findBook(id);
		
		model.addAttribute("onebook", onebook);
		
		return "onebook.jsp";
	}
	
	@RequestMapping("/addbook")
	public String addbook() {
		return "create.jsp";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create (
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("language") String language,
			@RequestParam("numberOfPages") Integer numberOfPages
			) {
		
		Book newbook = new Book(title,description,language,numberOfPages);
		bookServ.createBook(newbook);
		
		return "redirect:/";
	}
	
	
	
		
}
