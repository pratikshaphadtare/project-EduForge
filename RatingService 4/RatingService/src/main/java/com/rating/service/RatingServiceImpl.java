package com.rating.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.exception.RatingNotFoundException;
import com.rating.model.Rating;
import com.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

 @Autowired
 private RatingRepository ratingRepository;

@Override
public Rating addRating(Rating rating) {
	// TODO Auto-generated method stub
	return ratingRepository.save(rating);
}

@Override
public List<Rating> getRatings() {
	// TODO Auto-generated method stub
	return ratingRepository.findAll();
}

@Override
public List<Rating> getRatingsByCourseName(String courseName) {
    List<Rating> ratings = ratingRepository.findByCourseName(courseName);
    if (ratings.isEmpty()) 
    {
        throw new RatingNotFoundException("No ratings found for course: " + courseName);
    }
    return ratings;
}

 
}

