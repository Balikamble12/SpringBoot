package com.Food.Service.Food.Service.Repository;

import com.Food.Service.Food.Service.entity.FoodItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, String> {
    List<FoodItem> findByHotelId(String hotelId);
}