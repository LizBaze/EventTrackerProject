package com.skilldistillery.books.services;

import java.util.List;

import com.skilldistillery.books.entities.Book;

public interface BookService {
	
	List<Book> findAll();
	Book getBook(int id);
	Book create(Book book);
	Book update(Book book, int id);
	boolean deleteById(int id);

}
