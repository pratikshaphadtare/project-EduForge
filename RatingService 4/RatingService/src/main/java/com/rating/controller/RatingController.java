package com.rating.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rating.exception.RatingNotFoundException;
import com.rating.model.Rating;
import com.rating.service.RatingService;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/ratings")
@CrossOrigin(origins="http://localhost:3000")
public class RatingController {

 @Autowired	
 private RatingService ratingService;


 @PostMapping()
 public ResponseEntity<String> addRating(@RequestBody Rating rating) {
     ratingService.addRating(rating);
     return ResponseEntity.status(HttpStatus.CREATED).body("Rating added successfully");
 }
 
 @GetMapping()
 public ResponseEntity<List<Rating>> getRatings()
 {
     return ResponseEntity.ok(ratingService.getRatings());
 }
 
 @GetMapping("/{courseName}")
 public ResponseEntity<List<Rating>> getRatingsByCourseName(@PathVariable String courseName) {
     try 
     {
         List<Rating> ratings = ratingService.getRatingsByCourseName(courseName);
         return ResponseEntity.ok(ratings);
     } 
     catch (RatingNotFoundException e) 
     {
         return ResponseEntity.notFound().build();
     }
 }

}
 
