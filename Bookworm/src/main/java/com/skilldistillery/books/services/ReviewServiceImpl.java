package com.skilldistillery.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.books.entities.Review;
import com.skilldistillery.books.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository revRepo;

	@Override
	public List<Review> findAll() {
		return revRepo.findAll();
	}

	@Override
	public Review findById(int id) {
		Optional<Review> revOpt = revRepo.findById(id);
		Review rev = null;
		if (revOpt.isPresent()) {
			rev = revOpt.get();
		}
		return rev;
	}

	@Override
	public Review create(Review review) {
		revRepo.saveAndFlush(review);

		return review;
	}

	@Override
	public Review update(Review review, int id) {
		Review updated = null;
		Optional<Review> revOpt = revRepo.findById(id);
		if (revOpt.isPresent()) {
			updated = revOpt.get();
			updated.setDescription(review.getDescription());
			updated.setCoverArt(review.getCoverArt());
			updated.setSynopsis(review.getSynopsis());
			updated.setTitle(review.getTitle());
			revRepo.saveAndFlush(updated);
		}
		return updated;
	}

	@Override
	public boolean delete(int id) {
		boolean deleted = false;
		Optional<Review> revOpt = revRepo.findById(id);
		if (revOpt.isPresent()) {
			revRepo.delete(revOpt.get());
			deleted = true;
		}
		return deleted;
	}

}
