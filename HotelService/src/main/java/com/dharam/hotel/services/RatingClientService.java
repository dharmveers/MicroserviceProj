package com.dharam.hotel.services;

import com.dharam.hotel.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingClientService {
    @GetMapping("/getAllRatings/hotel/{hotelId}")
    List<Rating> getAllRatingsByHotelId(@PathVariable String hotelId);
}
