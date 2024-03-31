package com.dharam.hotel.services;

import com.dharam.hotel.entities.Hotel;
import com.dharam.hotel.repositories.HotelRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService{
    ResponseEntity<String> saveHotel(Hotel hotel);

    ResponseEntity<Hotel> getHotel(String id);

    ResponseEntity<List<Hotel>> getAllHotels();
}
