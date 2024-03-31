package com.dharam.rating.services.Impl;

import com.dharam.rating.entities.Rating;
import com.dharam.rating.entities.User;
import com.dharam.rating.repositories.RatingRepo;
import com.dharam.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResponseEntity<String> createRating(Rating rating) {
        ratingRepo.save(rating);
        return new ResponseEntity<>("Rating created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingRepo.findAll();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            User user = restTemplate.getForObject("http://localhost:8080/user/getUser/" + rating.getUserId(), User.class);
            rating.setUser(user);
            return rating;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(ratingList,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(String userid) {
        List<Rating> byUserId = ratingRepo.findByUserId(userid);
        List<Rating> ratingList = byUserId.stream().map(rating -> {
            User user = restTemplate.getForObject("http://localhost:8080/user/getUser/" + rating.getUserId(), User.class);
            rating.setUser(user);
            return rating;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(ratingList,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(String hotelId) {
        List<Rating> byHotelId = ratingRepo.findByHotelId(hotelId);
        byHotelId.stream().map(rating -> {
            User user = restTemplate.getForObject("http://localhost:8080/user/getUser/" + rating.getUserId(), User.class);
            rating.setUser(user);
            return rating;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(ratingRepo.findByHotelId(hotelId),HttpStatus.FOUND);
    }
}
