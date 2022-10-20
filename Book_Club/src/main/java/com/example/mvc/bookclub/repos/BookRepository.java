package com.example.mvc.bookclub.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.mvc.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();
}
