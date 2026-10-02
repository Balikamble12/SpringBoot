package com.Food.Service.Food.Service.controller;

import com.Food.Service.Food.Service.ServiceLayer.FooditemService;
import com.Food.Service.Food.Service.entity.FoodItem;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodItemController {
    private final FooditemService service;

    public FoodItemController(FooditemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addFoodItem(foodItem));
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        return ResponseEntity.ok(service.getAllFoodItems());
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable String foodId) {
        FoodItem foodItem = service.getFoodItemById(foodId);
        return foodItem == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(foodItem);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<FoodItem>> getFoodItemsByHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok(service.getFoodItemsByHotel(hotelId));
    }

    @PutMapping("/{foodId}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable String foodId, @RequestBody FoodItem foodItem) {
        FoodItem updatedFoodItem = service.updateFoodItem(foodId, foodItem);
        return updatedFoodItem == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedFoodItem);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable String foodId) {
        return service.deleteFoodItem(foodId)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}