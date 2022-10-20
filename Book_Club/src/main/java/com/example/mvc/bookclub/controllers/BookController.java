package com.example.mvc.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.mvc.bookclub.models.Book;
import com.example.mvc.bookclub.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping ("/add/book")
	public String addBookPage(@ModelAttribute("book") Book book,
								HttpSession session) {
		
		Long sessionUser = (Long) session.getAttribute("user_id");
		
		if (sessionUser == null)
			return "redirect:/";
		else	
			return "addBookPage.jsp";
	}
	
	@PostMapping("/add_book")
	public String addBookAction(@Valid @ModelAttribute("book") Book book,
								BindingResult result) {
		if(result.hasErrors()) {
			return "addBookPage.jsp";
		} else
			bookService.createBook(book);
			return "redirect:/welcome";
		}

	// ------- VIEW BOOK --------
	
	@GetMapping("view/book/{id}")
	public String viewBookPage(@PathVariable("id") Long id, Model model) {
		Book thisBook = bookService.findBook(id);
		model.addAttribute("thisBook", thisBook);
		return "viewBook.jsp";
	}
	
	// --------- EDIT BOOK --------
	
	@GetMapping ("edit/book/{id}")
	public String editBookPage(@PathVariable("id") Long id, Model model) {
		Book editBook = bookService.findBook(id);
		model.addAttribute("editBook", editBook);
		return "editBookPage.jsp";
	}
	
	@PutMapping("edit/{id}")
	public String editBookAction(@Valid @ModelAttribute("editBook") Book editBook,
									BindingResult result,
									Model model,
									@PathVariable("id") Long id) {
		if(result.hasErrors()) {
//			Book thisBook = bookService.findBook(id);
//			model.addAttribute("editBook", thisBook);
			return "editBookPage.jsp";	
		} else 
			bookService.updateBook(editBook);
			Book book = bookService.findBook(id);
			Long bookID = book.getId();
			return "redirect:/view/book/" + bookID;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
