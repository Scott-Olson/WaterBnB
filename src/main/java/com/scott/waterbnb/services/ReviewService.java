package com.scott.waterbnb.services;

import org.springframework.stereotype.Service;

import com.scott.waterbnb.models.Review;
import com.scott.waterbnb.repositories.ReviewRepo;

@Service
public class ReviewService {
	private ReviewRepo reviewRepo;
	
	public ReviewService(ReviewRepo reviewRepo) {
		this.reviewRepo = reviewRepo;
	}
	
	public Review createReview(Review review) {
		
		return reviewRepo.save(review);
	}

}
