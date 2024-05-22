package com.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.*;
 
import java.util.ArrayList;
import java.util.List;
 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import com.rating.model.Rating;
import com.rating.repository.RatingRepository;
import com.rating.service.RatingServiceImpl;
 
public class RatingServiceApplicationTests {
 
    @Mock
    private RatingRepository ratingRepository;
 
    @InjectMocks
    private RatingServiceImpl ratingService;
 
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testAddRating() {
        Rating rating = new Rating();
        rating.setRating(5);
        rating.setMessage("Great course!");
        rating.setCourseName("Java Programming");
 
        when(ratingRepository.save(any(Rating.class))).thenReturn(rating);
 
        Rating savedRating = ratingService.addRating(rating);
 
        assertEquals(rating, savedRating);
    }
 
    @Test
    public void testGetRatings() {
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating());
        ratings.add(new Rating());
 
        when(ratingRepository.findAll()).thenReturn(ratings);
 
        List<Rating> retrievedRatings = ratingService.getRatings();
 
        assertEquals(2, retrievedRatings.size());
    }
 
    @Test
    public void testGetRatingsByCourseName() {
        String courseName = "Java Programming";
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating());
        ratings.add(new Rating());
 
        when(ratingRepository.findByCourseName(courseName)).thenReturn(ratings);
 
        List<Rating> retrievedRatings = ratingService.getRatingsByCourseName(courseName);
 
        assertEquals(2, retrievedRatings.size());
    }
}