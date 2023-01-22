package com.skilldistillery.books.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.books.entities.Book;
import com.skilldistillery.books.entities.Review;
import com.skilldistillery.books.entities.User;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	List<Review> findByBookAndUser(Book book, User user);

}
