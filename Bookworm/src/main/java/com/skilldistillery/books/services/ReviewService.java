package com.skilldistillery.books.services;

import java.util.List;

import com.skilldistillery.books.entities.Review;

public interface ReviewService {
	
	List<Review> findAll();
	Review findById(int id);
	Review create(Review review);
	Review update(Review review, int id);
	boolean delete(int id);

}
