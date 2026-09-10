package com.lcwd.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.lcwd.hotel.service.HotelService;
import com.lcwd.hotel.entity.Hotel;

@RestController

@RequestMapping ("/hotels")
public class HotelController {



@Autowired 
private HotelService hotelService;

//create
@PostMapping 
public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
    
    Hotel hotel1= hotelService.createHotel(hotel);

    return ResponseEntity.status(201).body(hotel1);
}

@GetMapping("/{hotelId}")
public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
    
    Hotel hotel= hotelService.getHotel(hotelId);

    return ResponseEntity.ok(hotel);
}

@DeleteMapping("/{hotelId}")
public ResponseEntity<?> deleteHotel(@PathVariable String hotelId) {
    
    hotelService.deleteHotel(hotelId);

    return ResponseEntity.ok("Hotel deleted successfully");
}
@PutMapping("/{hotelId}")
public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId, @RequestBody Hotel hotel) {
    
    Hotel updatedHotel= hotelService.updateHotel(hotelId, hotel);

    return ResponseEntity.ok(updatedHotel);
}
@GetMapping
public ResponseEntity<List<Hotel>> getAllHotels() {
    
    return ResponseEntity.ok(hotelService.getAllHotels());
}
}
