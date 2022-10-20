package com.example.mvc.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.bookclub.models.Book;
import com.example.mvc.bookclub.repos.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookService;
	
	
	public List<Book> allBooks(){
		return bookService.findAll();
	}
	
	public Book createBook (Book book) {
		return bookService.save(book);
	}
	
	public Book findBook (Long id){
		Optional<Book> maybeBook = bookService.findById(id);
		if(maybeBook.isPresent())
			return maybeBook.get();
		else
			return null;
	}
	
	public Book updateBook (Book book) {
		return bookService.save(book);
	}
}
