package com.lced.user.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lced.user.service.entity.Rating;
import com.lced.user.service.entity.User;
import com.lced.user.service.exception.ResourceNotFoundException;
import com.lced.user.service.repository.UserRepository;
import com.lced.user.service.services.Userservice;

@Service
public class UserServiceImpl implements Userservice {
  @Autowired
    private UserRepository userRepository;

    @Autowired 
    private RestTemplate restTemplate;
  

    private  Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    // Save a new user with a generated UUID
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    // Get all users
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // Get a single user by ID
    @Override
    public User getUser(String userId) {
        User  user= userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server: " + userId));
        Rating[] ratings = restTemplate.getForObject(
                "http://Rating-Service/ratings/users/{userId}", Rating[].class, userId);

        user.setRatings(Arrays.asList(ratings));
        logger.info("Loaded {} ratings for user {}", ratings.length, userId);
        return user;
    }

    // Update user details
    @Override
    public User updateUser(User user) {
        // Optional: validate existence before update
        if (!userRepository.existsById(user.getUserId())) {
            throw new ResourceNotFoundException(
                    "User with given id is not found on server: " + user.getUserId());
        }
        return userRepository.save(user);
    }

    // Delete user by ID
    @Override
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException(
                    "User with given id is not found on server: " + userId);
        }
        userRepository.deleteById(userId);
    }

    // Alias method for clarity (calls getUser)
    @Override
    public User getUserById(String userId) {
        return getUser(userId);
    }
}
