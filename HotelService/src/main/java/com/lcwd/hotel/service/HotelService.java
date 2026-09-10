package com.lcwd.hotel.service;

import java.util.List;
import com.lcwd.hotel.entity.Hotel;

public interface HotelService {
    // create
    Hotel createHotel(Hotel hotel);

    // get all hotels
    List<Hotel> getAllHotels();

    // get single hotel
    Hotel getHotel(String hotelId);

    // update hotel
    Hotel updateHotel(String hotelId, Hotel hotel);

    // delete hotel
    void deleteHotel(String hotelId);
}
