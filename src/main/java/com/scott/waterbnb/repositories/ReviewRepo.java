package com.scott.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.scott.waterbnb.models.Review;

public interface ReviewRepo extends CrudRepository<Review, Long>{
	List<Review> findAll();
}
