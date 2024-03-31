package com.dharam.rating.controllers;

import com.dharam.rating.entities.Rating;
import com.dharam.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService service;
    @GetMapping("/create")
    public ResponseEntity<String> createRating(@RequestBody Rating rating){
        String id= UUID.randomUUID().toString();
        rating.setId(id);
        return service.createRating(rating);
    }
    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return service.getAllRatings();
    }
    @GetMapping("/getAllRatings/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
        return service.getAllRatingsByUserId(userId);
    }
    @GetMapping("/getAllRatings/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
        return service.getAllRatingsByHotelId(hotelId);
    }
}
