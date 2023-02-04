package com.skilldistillery.books.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.books.entities.Review;
import com.skilldistillery.books.services.ReviewService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class ReviewController {
	
	@Autowired
	private ReviewService revServ;
	
	@GetMapping("reviews")
	public List<Review> findAll() {
		return revServ.findAll();
	}
	
	@GetMapping("reviews/{id}")
	public Review findById(@PathVariable int id, HttpServletResponse resp) {
		Review review = revServ.findById(id);
		if (review == null) {
			resp.setStatus(404);
		}
		return review;
	}
	
	@PostMapping("reviews")
	public Review create(@RequestBody Review review, HttpServletResponse resp) {
		
		review = revServ.create(review);
		if (review == null) {
			resp.setStatus(404);
		} else {
			resp.setStatus(201);
		}
		return review;
	}
	
	
	@PutMapping("reviews/{id}")
	public Review update(@RequestBody Review review, @PathVariable int id, HttpServletResponse resp) {
		
		review = revServ.update(review, id);
		if (review == null) {
			resp.setStatus(404);
		} else {
			resp.setStatus(200);
		}
		return review;
	}
	
	@DeleteMapping("reviews/{id}")
	public void delete(@PathVariable int id, HttpServletResponse resp) {
		boolean deleted = revServ.delete(id);
		if (deleted) {
			resp.setStatus(204);
		} else {
			resp.setStatus(404);
		}
	}
	

}
