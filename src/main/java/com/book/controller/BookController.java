package com.book.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.BookModel;
import com.book.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@GetMapping
	public List<BookModel> getAllBooksDetails(){
		return BookRepository.getBookDetails();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookModel> getBookDetailById(@PathVariable("id")int bookId) {
		
		return BookRepository.getBookDetailById(bookId)
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
