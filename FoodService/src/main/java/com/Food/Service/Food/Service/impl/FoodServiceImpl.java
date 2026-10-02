package com.Food.Service.Food.Service.impl;

import com.Food.Service.Food.Service.Repository.FoodItemRepository;
import com.Food.Service.Food.Service.ServiceLayer.FooditemService;
import com.Food.Service.Food.Service.entity.FoodItem;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FoodServiceImpl implements FooditemService {
    private final FoodItemRepository repo;

    public FoodServiceImpl(FoodItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public FoodItem getFoodItemById(String foodId) {
        return repo.findById(foodId).orElse(null);
    }

    @Override
    public boolean deleteFoodItem(String foodId) {
        if (!repo.existsById(foodId)) {
            return false;
        }
        repo.deleteById(foodId);
        return true;
    }

    @Override
    public FoodItem updateFoodItem(String foodId, FoodItem foodItem) {
        FoodItem existingFoodItem = repo.findById(foodId).orElse(null);
        if (existingFoodItem == null) {
            return null;
        }

        existingFoodItem.setFoodName(foodItem.getFoodName());
        existingFoodItem.setPrice(foodItem.getPrice());
        existingFoodItem.setDiscount(foodItem.getDiscount());
        existingFoodItem.setHotelId(foodItem.getHotelId());
        existingFoodItem.setHotelName(foodItem.getHotelName());
        return repo.save(existingFoodItem);
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return repo.findAll();
    }

    @Override
    public FoodItem addFoodItem(FoodItem foodItem) {
        foodItem.setFoodId(UUID.randomUUID().toString());
        return repo.save(foodItem);
    }

    @Override
    public List<FoodItem> getFoodItemsByHotel(String hotelId) {
        return repo.findByHotelId(hotelId);
    }
}