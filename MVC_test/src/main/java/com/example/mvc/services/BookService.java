package com.example.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mvc.models.Book;
import com.example.mvc.repository.BookRepository;

@Service
public class BookService {

	// C R U D
	
	
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    // Created a BookService (bookRepository) and use it locally
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b); //SAVE method is already in the CrudRepository
    }
    
 
    
    public void deleteBook(Long id) { 
    			bookRepository.deleteById(id);
    }
    
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }




	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		
		Book updatedBook = this.findBook(id);
		
		updatedBook.setTitle(title);
		updatedBook.setDescription(desc);
		updatedBook.setLanguage(lang);
		updatedBook.setNumberOfPages(numOfPages);
		
		// TODO Auto-generated method stub
		return bookRepository.save(updatedBook);
	}












    
}
