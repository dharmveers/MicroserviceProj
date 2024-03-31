package com.dharam.rating.repositories;

import com.dharam.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,String> {
    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String hotelId);
}
