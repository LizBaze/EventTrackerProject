package com.skilldistillery.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.books.entities.Book;
import com.skilldistillery.books.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBook(int id) {
		Optional<Book> bookOpt = bookRepo.findById(id);
		Book book = null;
		if (bookOpt.isPresent()) {
			book = bookOpt.get();
		}
		return book;
	}

	@Override
	public Book create(Book book) {
		
		bookRepo.saveAndFlush(book);
		
		return book;
	}

	@Override
	public Book update(Book book, int id) {
		Optional<Book> bookOpt = bookRepo.findById(id);
		Book updated = null;
		if (bookOpt.isPresent()) {
			updated = bookOpt.get();
			updated.setAuthor(book.getAuthor());
			updated.setSynopsis(book.getSynopsis());
			updated.setTitle(book.getTitle());
			updated.setCoverArt(book.getCoverArt());
		} 
		
		return updated;
	}

	@Override
	public boolean deleteById(int id) {
		boolean deleted = false;
		Optional<Book> bookOpt = bookRepo.findById(id);
		Book book = null;
		if(bookOpt.isPresent()) {
			book = bookOpt.get();
			bookRepo.delete(book);
			deleted = true;
		}
		return deleted;
	}
	
	
	

}
