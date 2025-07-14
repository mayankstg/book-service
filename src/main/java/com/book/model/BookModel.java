package com.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookModel {

	private int id;
	private String title;
	private String author;
	private double price;
}
