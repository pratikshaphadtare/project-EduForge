package com.rating.repository;

import org.springframework.stereotype.Repository;

import com.rating.model.Rating;

import java.util.List;

//RatingRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	List<Rating> findByCourseName(String courseName);
}
