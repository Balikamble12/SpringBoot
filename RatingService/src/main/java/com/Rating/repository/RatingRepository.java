package com.Rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Rating.entity.Rating;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {
    
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
