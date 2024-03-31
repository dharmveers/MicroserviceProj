package com.dharam.rating.services;

import com.dharam.rating.entities.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingService {
    //create Rating
    ResponseEntity<String> createRating(Rating rating);

    //get all Ratings
    ResponseEntity<List<Rating>> getAllRatings();

    //getRatings by userid
    ResponseEntity<List<Rating>> getAllRatingsByUserId(String userid);

    //get All Rating by hotelId
    ResponseEntity<List<Rating>> getAllRatingsByHotelId(String hotelId);
}
