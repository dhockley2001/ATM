package com.dhockley2001.atm.atm.service;

import java.util.List;

import com.dhockley2001.atm.atm.models.User;

public interface UserService {
    
    User createUser (User user);

    List<User> getAllUsers();

    User getUserById(Long userId);

    User updateUser(User user, Long userId);

    void deleteUserById(Long userId);
}
