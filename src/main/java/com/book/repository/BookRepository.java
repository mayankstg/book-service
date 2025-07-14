package com.book.repository;

import java.util.List;
import java.util.Optional;

import com.book.model.BookModel;

public class BookRepository {

	private static final List<BookModel> BOOK_MODELS_LIST = List.of(
				new BookModel(1, "Spring in Action", "Craig Walls", 500),
				new BookModel(2, "Java 8 Programming Black Book", "D.T. Editorial Services", 965)
			);
	
	public static List<BookModel> getBookDetails(){
		return BOOK_MODELS_LIST;
	}
	
	public static Optional<BookModel> getBookDetailById(int id){
		return BOOK_MODELS_LIST.stream()
				.filter(b->b.getId()==id)
				.findFirst();
	}
}
