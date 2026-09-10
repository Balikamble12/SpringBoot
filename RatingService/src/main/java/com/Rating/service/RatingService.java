package com.Rating.service;


import java.util.List;

import com.Rating.entity.Rating;



public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getRatingsByHotelId(String hotelId);

    Rating getRatingById(String ratingId);

    List<Rating> findByHotelId(String hotelId);
     
}