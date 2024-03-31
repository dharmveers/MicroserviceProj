package com.dharam.hotel.controllers;

import com.dharam.hotel.entities.Hotel;
import com.dharam.hotel.services.HotelService;
import com.dharam.hotel.services.RatingClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class MyController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/saveHotel")
    public ResponseEntity<String> saveHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
    }
    @GetMapping("/getHotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
        return hotelService.getHotel(id);
    }
    @GetMapping("/getHotels")
    public ResponseEntity<List<Hotel>> getHotels(String id){
        return hotelService.getAllHotels();
    }
}
