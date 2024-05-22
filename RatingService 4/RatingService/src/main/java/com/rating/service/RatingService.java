package com.rating.service;

import java.util.List;

import com.rating.model.Rating;


public interface RatingService {
	
	Rating addRating(Rating rating);
	
	List<Rating> getRatings();

    List<Rating> getRatingsByCourseName(String courseName);
	
}