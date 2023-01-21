package com.skilldistillery.books.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.books.entities.Book;
import com.skilldistillery.books.services.BookService;

@RestController
@RequestMapping("api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("books")
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	@GetMapping("books/{id}")
	public Book findBook(@PathVariable int id) {
		return bookService.getBook(id);
	}
	
	@PostMapping("books")
	public Book createBook(@RequestBody Book book) {
		bookService.create(book);
		return book;
	}
	
	@PutMapping("books/{id}")
	public Book update(@PathVariable int id, @RequestBody Book book, HttpServletResponse resp) {
		
		
		book = bookService.update(book, id);
		if (book == null) {
			resp.setStatus(404);
		}
		return book;
	}
	
	@DeleteMapping("books/{id}")
	public void delete(@PathVariable int id, HttpServletResponse resp) {
		
		if (bookService.deleteById(id) == true) {
			resp.setStatus(204);
		} else {
			resp.setStatus(404);
		}
		
	}
	
	
	

}
