package com.dharam.hotel.services.Impl;

import com.dharam.hotel.entities.Hotel;
import com.dharam.hotel.entities.Rating;
import com.dharam.hotel.repositories.HotelRepository;
import com.dharam.hotel.services.HotelService;
import com.dharam.hotel.services.RatingClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RatingClientService clientService;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResponseEntity<String> saveHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        hotelRepository.save(hotel);
        return new ResponseEntity<>("Hotel saved successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Hotel> getHotel(String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
//        ArrayList ratingList = restTemplate.getForObject("http://localhost:8082/rating/getAllRatings/hotel/"+id, ArrayList.class);
        List<Rating> ratingList = clientService.getAllRatingsByHotelId(id);
        hotel.setRatings(ratingList);
        return new ResponseEntity<>(hotel,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        hotels.stream().map(hotel -> {
            //ArrayList rattingList = restTemplate.getForObject("http://localhost:8082/rating/getAllRatings/hotel/"+hotel.getId(), ArrayList.class);
            List<Rating> ratingList = clientService.getAllRatingsByHotelId(hotel.getId());
            hotel.setRatings(ratingList);
            return hotel;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(hotels,HttpStatus.FOUND);
    }
}
