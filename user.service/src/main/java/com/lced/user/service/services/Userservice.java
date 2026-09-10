package com.lced.user.service.services;
import java.util.List;

import com.lced.user.service.entity.User;

public interface Userservice {

//user opration


//Create

User saveUser(User user);
   

//get alll user
List<User> getAllUser();

//get single  user of given userId

User getUserById(String userId);

// get user
public User getUser(String userId);

//TODO:delete


public void deleteUser(String userId);


//TODO:Update
public User updateUser(User user);

}
