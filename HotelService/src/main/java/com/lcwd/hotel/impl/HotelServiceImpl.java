package com.lcwd.hotel.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.Exception.ResourceNotFoundException;
import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.repositories.HotelRepository;
import com.lcwd.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired 
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hotel with given id not found on server !! : " + hotelId));
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hotel with given id not found on server !! : " + hotelId));

        existingHotel.setName(hotel.getName());         
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setAbout(hotel.getAbout());   

        return hotelRepository.save(existingHotel);         
    }

    @Override
    public void deleteHotel(String hotelId) {
        Hotel existingHotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hotel with given id not found on server !! : " + hotelId));
        hotelRepository.delete(existingHotel);
    }
}
