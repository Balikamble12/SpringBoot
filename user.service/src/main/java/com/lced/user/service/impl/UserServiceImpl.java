package com.lced.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lced.user.service.entity.User;
import com.lced.user.service.exception.ResourceNotFoundException;
import com.lced.user.service.repository.UserRepository;
import com.lced.user.service.services.Userservice;

@Service
public class UserServiceImpl  implements Userservice
{    

@Autowired
    private UserRepository userRepository;

    // @Override
    // public User saveUser(User user) {
        
    //    String randomUserId=UUID.randomUUID().toString();
    //    user.setUserId(randomUserId);
      
    //     return userRepository.save(user);
    // }
    @Override
public User saveUser(User user) {

    String randomUserId = UUID.randomUUID().toString();
    user.setUserId(randomUserId);

    return userRepository.save(user);
}
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll() ;

    }   

    // @Override
    // public User getUserById(String userId) {
    //     return userRepository.findById(userId).get();

    // }

     // TODO Auto-generated method stub
    // @Override
    // public void deleteUser(String userId) {
       
        
    // }
    
    @Override
    public User getUser(String userId) {
        // TODO Auto-generated method stub
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server" + userId));
    }



    // TODO Auto-generated method stub
    @Override
    public User updateUser(User user) {
        
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return getUser(userId);
    }



    @Override
    public  void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User with given id is not found on server" + userId);
        }
        userRepository.deleteById(userId);
    }

}
