package com.Food.Service.Food.Service.ServiceLayer;

import com.Food.Service.Food.Service.entity.FoodItem;
import java.util.List;

public interface FooditemService {
    FoodItem addFoodItem(FoodItem foodItem);

    List<FoodItem> getFoodItemsByHotel(String hotelId);

    FoodItem getFoodItemById(String foodId);

    boolean deleteFoodItem(String foodId);

    FoodItem updateFoodItem(String foodId, FoodItem foodItem);

    List<FoodItem> getAllFoodItems();
}